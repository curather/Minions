package com.gum.minions.minions;

import com.gum.minions.Minions;
import com.gum.minions.minions.types.farming.cocoa_beansMinionEntity;
import com.gum.minions.minions.types.farming.mushroomMinionEntity;
import com.gum.minions.util.Utils;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

public abstract class AbstractMinionEntity extends ArmorStandEntity implements IInventoryChangedListener, INamedContainerProvider, Minion {
    private static final Predicate<LivingEntity> OTHER_MINION_SELECTOR = (p_213797_0_) -> {
        return p_213797_0_ instanceof AbstractMinionEntity;
    };
    private static final EntityPredicate PARTNERS = (new EntityPredicate()).range(25.0D);
    protected int tickCount = 0;
    protected int nextAction = 0;
    protected int Speed = 10 * 20;
    protected int ChatSpeed = 10 * 20;
    protected int radius = 2;
    protected Block minionType = Blocks.COBBLESTONE;
    boolean alternatingCells = false;
    public BlockPos nextPosition;
    World world;
    public Item returnItem = Items.COBBLESTONE;
    private ArrayList<String> currentSaying= null;
    protected long nextSayingEnd = Integer.MAX_VALUE;
    private AbstractMinionEntity chatEntity = null;
    public boolean invalidSoil = false;
    public int returnQuanity = 1;
    HashMap<Item, Float> bonusItem = new HashMap<Item, Float>();//return if lucky
    private final Inventory inventory = new Inventory(9);//27 half 54 whole chest

    public AbstractMinionEntity(EntityType<? extends ArmorStandEntity> p_i50225_1_, World p_i50225_2_) {
        super(p_i50225_1_, p_i50225_2_);
        init(p_i50225_2_);
    }

    public AbstractMinionEntity(ServerWorld p_i45855_1_, double p_i45855_2_, double p_i45855_4_, double p_i45855_6_) {
        this(EntityType.ARMOR_STAND, p_i45855_1_);
        this.setPos(p_i45855_2_, p_i45855_4_, p_i45855_6_);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public void init(World p_i50225_2_) {
        this.world = p_i50225_2_;

        this.setNoGravity(true);

        //small
        this.entityData.set(DATA_CLIENT_FLAGS, this.setBit(this.entityData.get(DATA_CLIENT_FLAGS), 1, true));
        //arms
        this.entityData.set(DATA_CLIENT_FLAGS, this.setBit(this.entityData.get(DATA_CLIENT_FLAGS), 4, true));
        //no base plate
        this.entityData.set(DATA_CLIENT_FLAGS, this.setBit(this.entityData.get(DATA_CLIENT_FLAGS), 8, true));

        this.nextPosition = this.nextPosition(this.blockPosition().below());

        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.put("Inventory", this.inventory.createTag());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);

        this.inventory.fromTag(p_70037_1_.getList("Inventory", 10));
    }

    public IInventory getInventory() {
        return this.inventory;
    }

    @Override
    public boolean setSlot(int p_174820_1_, ItemStack p_174820_2_) {
        //if (super.setSlot(p_174820_1_, p_174820_2_)) {
        //    return true;
        //} else {
        int i = p_174820_1_ - 300;
        if (i >= 0 && i < this.inventory.getContainerSize()) {
            this.inventory.setItem(i, p_174820_2_);
            return true;
        } else {
            return false;
        }
        //}
    }

    private byte setBit(byte p_184797_1_, int p_184797_2_, boolean p_184797_3_) {
        if (p_184797_3_) {
            p_184797_1_ = (byte) (p_184797_1_ | p_184797_2_);
        } else {
            p_184797_1_ = (byte) (p_184797_1_ & ~p_184797_2_);
        }

        return p_184797_1_;
    }

    @Override
    public ArrayList<String> getCurrentSaying() {
        return currentSaying;
    }

    @Override
    public void setCurrentSaying(ArrayList<String> tmp) {
        this.currentSaying = tmp;
    }

    @Override
    public AbstractMinionEntity getChatEntity() {
        return chatEntity;
    }

    @Override
    public void setChatEntity(AbstractMinionEntity tmp) {
        chatEntity = tmp;
    }

    @Override
    public long getNextSayingEnd() {
        return nextSayingEnd;
    }

    @Override
    public void setNextSayingEnd(long tmp) {
        nextSayingEnd=tmp;
    }

    public static String getMinionId(Minion minion) {
        String[] name = minion.getClass().getName().split("\\.");
        return name[name.length - 1];
    }

    public static String getTranslationKey(Minion minion) {
        return "minion.minions." + getMinionId(minion);
    }

    public IFormattableTextComponent translateText() {
        return new TranslationTextComponent(getTranslationKey(this));
    }

    @Override
    public ActionResultType interactAt(PlayerEntity player, Vector3d p_184199_2_, Hand p_184199_3_) {
        if (!player.level.isClientSide) {
            player.openMenu(this);
            //Minecraft.getInstance().setScreen(new MinionChestScreen(createMenu(0,player.inventory),player.inventory, new StringTextComponent("Minion Inventory")));
            return ActionResultType.PASS;
        }
        return ActionResultType.FAIL;
    }

    /*@Override
    public IPacket<?> getAddEntityPacket() {
        super.getAddEntityPacket();
        return NetworkHooks.getEntitySpawningPacket(this);
    }*/

    @Override
    public void tick() {
        if (!this.level.isClientSide)
            chatTick();
        if (this instanceof CombatMinionEntity ||
                this instanceof ForestMinionEntity ||
                this instanceof cocoa_beansMinionEntity ||
                this instanceof FarmingMinionEntity ||
                this instanceof mushroomMinionEntity) {
            if (!this.level.isClientSide)
                this.tickCount++;
            super.tick();

            return;
        }
        if (invalidSoil) {
            this.nextPosition = this.nextPosition(this.blockPosition().below());
            return;
        }
        if (!this.level.isClientSide) {
            if (this.getTickCount() > (this.getTickCount() + ((this.getTickCount() - this.getNextAction()) / 2)) && this.nextPosition != null)
                animateMinion(new Vector3d(this.nextPosition.getX(), this.nextPosition.getY(), this.nextPosition.getZ()));
            if (this.getTickCount() > this.getNextAction()) {
                this.setNextAction(Speed + this.getTickCount());
                if (this.nextPosition == null) {
                    if (ServerLifecycleHooks.getCurrentServer() != null)
                        ServerLifecycleHooks.getCurrentServer().sendMessage(new StringTextComponent("No Suitable position to lay block " + this.getMinionType().toString()), UUID.randomUUID());
                    else
                        Minecraft.getInstance().player.sendMessage(new StringTextComponent("No Suitable position to lay block " + this.getMinionType().toString()), UUID.randomUUID());
                } else {
                    if (this.level.getBlockState(this.nextPosition) != this.getMinionType().defaultBlockState()) {
                        this.level.setBlockAndUpdate(this.nextPosition, this.minionType.defaultBlockState());
                    } else {
                        IInventory chest = findContainer();
                        this.level.destroyBlock(this.nextPosition, false);


                        ItemStack retItem = new ItemStack(this.returnItem, returnQuanity);
                        if (bonusItem.size() > 0) {
                            for (Map.Entry mapElement : bonusItem.entrySet()) {
                                ItemStack tmp = new ItemStack((Item) mapElement.getKey());
                                Float chance = (Float) mapElement.getValue();
                                if ((Math.random() * 100) <= chance) {
                                    if (chest == null) {
                                        addItem(this.getInventory(), tmp);
                                    } else {
                                        addItem(chest, tmp);
                                    }
                                }
                            }
                        }

                        if (chest == null) {
                            addItem(this.getInventory(), retItem);
                        } else {
                            addItem(chest, retItem);
                        }
                        //this.setNextAction(3 * 20 + this.getTickCount());
                    }

                }
                this.nextPosition = this.nextPosition(this.blockPosition().below());
            }
            this.tickCount++;
        }

        super.tick();
    }

    public void chatTick() {
        List<PlayerEntity> players = new ArrayList<>();
        for (PlayerEntity player : this.level.players()) {
            //Utils.printLogger("DISTANCE TO PLAYER: "+player.distanceTo(this));
            if (player.distanceTo(this) <= ((radius+1) * 3 + 1))
                players.add(player);
        }
        List<AbstractMinionEntity> entityList = this.level.getEntitiesOfClass(AbstractMinionEntity.class, this.getBoundingBox().inflate((radius+1)*6 + 1));
        entityList.remove(this);
        //Utils.printLogger("minionChatting: "+ServerTickHandler.minionChatting);
        //Utils.printLogger("check 0: "+this.getTickCount() % (20 * 5));
        if (players.size() == 0)
            return;

        //Displaying invalid soil.
        if (this.invalidSoil)
            return;
        if (!Minions.minionChatting) {
            if (!this.getCustomName().getString().equalsIgnoreCase(this.translateText().getString()))
                this.setCustomName(translateText().withStyle(Style.EMPTY.withColor(TextFormatting.GREEN)));
            if (this.level.getGameTime() % (20 * 5) == 0) {
                //Utils.printLogger("Player: "+players);
                //Utils.printLogger("entityList: "+entityList);
                if (players.size() > 0) {
                    Minions.minionChatting = true;
                        PlayerEntity player = players.get(Utils.random(players.size()));
                        ArrayList<String> singleChat = new ArrayList<>();
                        if (player.getItemInHand(Hand.MAIN_HAND).getItem().getItemCategory() == ItemGroup.TAB_COMBAT && Utils.random(100) < 25)
                            singleChat.add("Nice sword you have there <PLAYER>!".replace("<PLAYER>", player.getName().getString()));
                        else if (player.getItemBySlot(EquipmentSlotType.HEAD) != ItemStack.EMPTY &&
                                player.getItemBySlot(EquipmentSlotType.CHEST) != ItemStack.EMPTY &&
                                player.getItemBySlot(EquipmentSlotType.LEGS) != ItemStack.EMPTY &&
                                player.getItemBySlot(EquipmentSlotType.FEET) != ItemStack.EMPTY &&
                                Utils.random(100) < 25) {
                            singleChat.add("Nice armor you have there <PLAYER>!".replace("<PLAYER>", player.getName().getString()));
                        } else {
                            singleChat.add(MinionSayings.returnSingleSayings().get(Utils.random(MinionSayings.returnSingleSayings().size())).replace("<PLAYER>", player.getName().getString()));
                        }
                        this.setCurrentSaying(singleChat);
                        this.nextSayingEnd = this.level.getGameTime() + ChatSpeed;
                } else if (entityList.size() > 0 && Utils.random(100) < 25) {
                    Minions.minionChatting = true;
                    AbstractMinionEntity otherMinion = null;
                    while (otherMinion == null) {
                        otherMinion = entityList.get(Utils.random(entityList.size()));
                        if (otherMinion.invalidSoil) {
                            entityList.remove(otherMinion);
                            otherMinion = null;
                        }
                        if (entityList.size() < 1)
                            return;
                    }
                    this.setChatEntity(otherMinion);
                    otherMinion.setChatEntity(this);
                    //Utils.printLogger("MINION SAYING SIZE: " + MinionSayings.returnMinionSayings().size());
                    int randomNum = Utils.random(MinionSayings.minionSayingsSize());
                    //Utils.printLogger("random num: "+randomNum);
                    //Utils.printLogger("MinionSaying size: "+(MinionSayings.minionSayingsSize()));
                    //MinionSayings.MinionSaying conversation = MinionSayings.returnMinionSayings().get(randomNum);
                    ArrayList<String> tmp = MinionSayings.returnMinion1(randomNum);
                    //Utils.printLogger("Minion1 SIZE: " + tmp.size());
                    for (int i = 0; i < tmp.size(); i++) {
                        tmp.set(i,tmp.get(i).replace("<TYPE_MINION>", this.getCustomName().getString()));
                    }
                    this.setCurrentSaying(tmp);
                    //Utils.printLogger("Minion1: " + this.getName());
                    //Utils.printLogger("Minion1 SIZE: " + tmp);

                    tmp = MinionSayings.returnMinion2(randomNum);
                    //Utils.printLogger("Minion2 SIZE: " + tmp);
                    for (int i = 0; i < tmp.size(); i++) {
                        tmp.set(i,tmp.get(i).replace("<TYPE_MINION>", otherMinion.getCustomName().getString()));
                    }
                    otherMinion.setCurrentSaying(tmp);
                    //Utils.printLogger("Minion2: " + otherMinion.getName());
                    //Utils.printLogger("Minion2 SIZE: " + tmp.size());
                    this.nextSayingEnd = this.level.getGameTime() + ChatSpeed;
                    if (MinionSayings.returnMinion1(randomNum).get(0).equalsIgnoreCase("3,2,1")) {
                        otherMinion.setNextSayingEnd(this.level.getGameTime() + ChatSpeed);
                    } else {
                        otherMinion.setNextSayingEnd(this.level.getGameTime() + (ChatSpeed+(ChatSpeed) / 2));
                        //Utils.printLogger("saying end 1:"+this.nextSayingEnd);
                        //Utils.printLogger("saying end 2: "+otherMinion.nextSayingEnd);
                    }
                }

            }
        } else{
            if (this.level.getGameTime() > this.getNextSayingEnd()) {
                AbstractMinionEntity otherMinion = this.getChatEntity();
                if (this.getCurrentSaying() == null) {
                    resetChat(otherMinion);
                    //Utils.printLogger("NULL reset");
                    return;
                }
                //Utils.printLogger("currentSaying size: "+this.getCurrentSaying().size());
                if (this.getCurrentSaying().size() > 0) {
                    this.setCustomName(new StringTextComponent(this.getCurrentSaying().get(0)));
                    //Utils.printLogger(this.getName().getString() + ": "+ this.getCurrentSaying().get(0));
                    this.getCurrentSaying().remove(0);
                } else if (this.getCurrentSaying().size() < 1) {
                    resetChat(otherMinion);
                    //Utils.printLogger("SIZE reset");
                    return;
                }
                //Utils.printLogger("before next saying: "+this.getNextSayingEnd());
                //Utils.printLogger("TICK COUNT: "+this.level.getGameTime());
                //Utils.printLogger("ChatSpeed: "+ChatSpeed);
                //Utils.printLogger("COMBINED: "+(this.level.getGameTime()+ChatSpeed));
                this.setNextSayingEnd(this.level.getGameTime() +ChatSpeed);
                //Utils.printLogger("after next saying: "+this.getNextSayingEnd());
            }
        }
    }
    public void resetChat(AbstractMinionEntity otherMinion) {
        Minions.minionChatting=false;
        this.setCustomName(translateText().withStyle(TextFormatting.GREEN));
        this.setCurrentSaying(null);
        this.setNextSayingEnd(Long.MAX_VALUE);
        if (otherMinion != null) {
            otherMinion.setCustomName(otherMinion.translateText().withStyle(TextFormatting.GREEN));
            otherMinion.setCurrentSaying(null);
            otherMinion.setNextSayingEnd(Long.MAX_VALUE);
            //otherMinion.setCurrentSaying(null);
        }
    }

    public void animateMinion(Vector3d tmp) {
        this.lookAt(EntityAnchorArgument.Type.FEET, tmp);
    }

    public IInventory findContainer() {
        IInventory container;
        for (int x = -1; x < 2; x++)
            for (int z = -1; z < 2; z++) {
                container = getContainerAt(this.level, this.position().x + x, this.position().y, this.position().z + z);
                if (container != null)
                    return container;
            }
        return null;

    }

    public BlockPos nextPosition(BlockPos center) {
        ArrayList<BlockPos> listOfPotentialBlocks = new ArrayList<>();
        BlockPos tmp;
        Boolean nextCell = true;
         for (int x = -radius; x < radius + 1; x++)
            for (int z = -radius; z < radius + 1; z++) {
                tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                if (alternatingCells) {
                    nextCell = (x % 2) == 0 && (z % 2) == 0;
                    //if (nextCell)
                    //    Utils.printLogger(this.getCustomName().getString() + ": "+x+", " + z);
                }
                if (this.level.getBlockState(tmp.below()) != Blocks.WATER.defaultBlockState()) {
                    boolean perfect = true;
                    if (this.minionType instanceof CropsBlock) {
                        perfect = (!this.minionType.canSustainPlant(this.level.getBlockState(tmp), this.level, tmp, Direction.UP, ((IPlantable) this.minionType.getBlock())));
                    }
                    if (!perfect) {
                        this.setCustomName(new StringTextComponent("This location isn't perfect! :(").withStyle(Style.EMPTY.withColor(TextFormatting.DARK_RED)));
                        invalidSoil = true;
                        if (this.getCurrentSaying() != null) {
                            AbstractMinionEntity otherMinion = this.getChatEntity();
                            resetChat(otherMinion);
                        }
                        return null;
                    }
                    if (nextCell) {
                        if (this.level.getBlockState(tmp) != this.getMinionType().defaultBlockState() &&
                                Utils.getDistanceToEntity(this, tmp) > 1.0D) {
                            listOfPotentialBlocks.add(tmp);
                        }
                    }
                }
            }
        if (listOfPotentialBlocks.size() == 0) {
            for (int x = -radius - 1; x < radius + 1; x++)
                for (int z = -radius - 1; z < radius + 1; z++) {
                    tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                        if (this.level.getBlockState(tmp) == this.getMinionType().defaultBlockState() &&
                                x != 0 && z != 0)
                                //Utils.getDistanceToEntity(this, tmp) > 0.5D)
                            listOfPotentialBlocks.add(tmp);
                }
        }
        if (listOfPotentialBlocks.size() > 0) {
            BlockPos ret = listOfPotentialBlocks.get(Utils.random(listOfPotentialBlocks.size()));
            return ret;
        }
        return null;
    }

    @Override
    public int getTickCount() {
        return tickCount;
    }

    @Override
    public int getNextAction() {
        return nextAction;
    }

    @Override
    public Block getMinionType() {
        return minionType;
    }

    @Override
    public void setMinionType(Block tmp) {
        this.minionType = tmp;
    }

    @Override
    public void setBonusItem(HashMap<Item, Float> tmp) {
        this.bonusItem = tmp;
    }

    @Override
    public void setAlternatingCells(boolean tmp) {
        this.alternatingCells = tmp;
    }

    @Override
    public void setSpeed(int tmp) {
        this.Speed = tmp;
    }

    @Override
    public void remove() {
        if (!this.level.isClientSide) {
            for (int i1 = 0; i1 < this.inventory.getContainerSize(); ++i1) {
                ItemStack item = this.inventory.getItem(i1);
                if (item != null) {
                    this.level.addFreshEntity(new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), item));
                }
            }
        }
        super.remove();
    }

    @Override
    public void setReturnItem(Item tmp) {
        this.returnItem = tmp;
    }

    @Override
    public void setNextAction(int inputNextAction) {
        this.nextAction = inputNextAction;
    }

    @Override
    public void setReturnQuanity(int tmp) {
        this.returnQuanity = tmp;
    }

    @Override
    public void setTickCount(int tickCount) {
        this.tickCount = tickCount;
    }

    private static ItemStack tryMoveInItem(IInventory p_174916_1_, ItemStack p_174916_2_, int p_174916_3_) {
        ItemStack itemstack = p_174916_1_.getItem(p_174916_3_);
        /*Utils.printLogger("can place: "+canPlaceItemInContainer(p_174916_1_, p_174916_2_, p_174916_3_));
        Utils.printLogger("can Merge: "+canMergeItems(itemstack, p_174916_2_));*/
        if (canPlaceItemInContainer(p_174916_1_, p_174916_2_, p_174916_3_)) {
            if (itemstack.isEmpty()) {
                p_174916_1_.setItem(p_174916_3_, p_174916_2_);
                p_174916_2_ = ItemStack.EMPTY;
            } else if (canMergeItems(itemstack, p_174916_2_)) {
                int i = p_174916_2_.getMaxStackSize() - itemstack.getCount();
                int j = Math.min(p_174916_2_.getCount(), i);
                p_174916_2_.shrink(j);
                itemstack.grow(j);
            }
        }
        return p_174916_2_;
    }

    public static ItemStack addItem(IInventory p_174918_1_, ItemStack p_174918_2_) {
        int i = p_174918_1_.getContainerSize();

        for (int j = 0; j < i && !p_174918_2_.isEmpty(); ++j) {
            p_174918_2_ = tryMoveInItem(p_174918_1_, p_174918_2_, j);
        }
        return p_174918_2_;
    }

    private static boolean canPlaceItemInContainer(IInventory p_174920_0_, ItemStack p_174920_1_, int p_174920_2_) {
        if (!p_174920_0_.canPlaceItem(p_174920_2_, p_174920_1_)) {
            return false;
        } else {
            return !(p_174920_0_ instanceof ISidedInventory);
        }
    }

    private static boolean canMergeItems(ItemStack p_145894_0_, ItemStack p_145894_1_) {
        if (p_145894_0_.getItem() != p_145894_1_.getItem()) {
            return false;
        } else if (p_145894_0_.getDamageValue() != p_145894_1_.getDamageValue()) {
            return false;
        } else if (p_145894_0_.getCount() > p_145894_0_.getMaxStackSize()) {
            return false;
        } else {
            return ItemStack.tagMatches(p_145894_0_, p_145894_1_);
        }
    }

    @Nullable
    public static IInventory getContainerAt(World p_145893_0_, double p_145893_1_, double p_145893_3_, double p_145893_5_) {
        IInventory iinventory = null;
        BlockPos blockpos = new BlockPos(p_145893_1_, p_145893_3_, p_145893_5_);
        BlockState blockstate = p_145893_0_.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof ISidedInventoryProvider) {
            iinventory = ((ISidedInventoryProvider) block).getContainer(blockstate, p_145893_0_, blockpos);
        } else if (blockstate.hasTileEntity()) {
            TileEntity tileentity = p_145893_0_.getBlockEntity(blockpos);
            if (tileentity instanceof IInventory) {
                iinventory = (IInventory) tileentity;
                if (iinventory instanceof ChestTileEntity && block instanceof ChestBlock) {
                    iinventory = ChestBlock.getContainer((ChestBlock) block, blockstate, p_145893_0_, blockpos, true);
                }
            }
        }

        if (iinventory == null) {
            List<Entity> list = p_145893_0_.getEntities((Entity) null, new AxisAlignedBB(p_145893_1_ - 0.5D, p_145893_3_ - 0.5D, p_145893_5_ - 0.5D, p_145893_1_ + 0.5D, p_145893_3_ + 0.5D, p_145893_5_ + 0.5D), EntityPredicates.CONTAINER_ENTITY_SELECTOR);
            if (!list.isEmpty()) {
                iinventory = (IInventory) list.get(p_145893_0_.random.nextInt(list.size()));
            }
        }

        return iinventory;
    }

    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.util.Direction facing) {
        if (this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemHandler != null)
            return itemHandler.cast();
        return super.getCapability(capability, facing);
    }

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        if (itemHandler != null) {
            net.minecraftforge.common.util.LazyOptional<?> oldHandler = itemHandler;
            itemHandler = null;
            oldHandler.invalidate();
        }
    }

    @Override
    public void containerChanged(IInventory p_76316_1_) {
        //Utils.printLogger("Updating Inventory"+p_76316_1_.getContainerSize());
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return new ChestContainer(ContainerType.GENERIC_9x1, p_createMenu_1_, p_createMenu_2_, this.inventory, 1);
    }

    @Override
    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        if (p_70097_1_.getEntity() instanceof PlayerEntity)
            return super.hurt(p_70097_1_,p_70097_2_);
        else
            return false;
    }
}
