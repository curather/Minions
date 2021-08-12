package com.gum.minions.minions.types.farming;

import com.gum.minions.minions.AbstractMinionEntity;
import com.gum.minions.minions.MinionSkins;
import com.gum.minions.registers.ItemRegister;
import com.gum.minions.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CocoaBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.ArrayList;
import java.util.UUID;

public class cocoa_beansMinionEntity extends AbstractMinionEntity {
    /*
    CUSTOMIZABLE MINION ATTRIBUTES
    get Textures and ids from https://minecraft-heads.com/
     */
    ItemStack playerHead = MinionSkins.COCOA_BEANS_MINION.playerHead();
    int armorColor = DyeColor.BROWN.getColorValue();
    Block setBlock = Blocks.JUNGLE_LOG;
    Block setBlock2 = Blocks.COCOA;
    Item retItem = Items.COCOA_BEANS;
    int minionSpeed = 27 * 20;
    Item MinionItem = ItemRegister.COCOA_BEANS_MINION;
    /*
    DON'T EDIT BELOW HERE
     */
    static cocoa_beansMinionEntity armorstandentity;

    public cocoa_beansMinionEntity(EntityType<? extends ArmorStandEntity> p_i50225_1_, World p_i50225_2_) {
        super(p_i50225_1_, p_i50225_2_);
        this.setMinionType(setBlock);
        this.setReturnItem(retItem);
        this.setSpeed(minionSpeed);
        this.setReturnQuanity(3);
        this.setAlternatingCells(true);
        this.setItemSlot(EquipmentSlotType.HEAD, playerHead);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.WOODEN_HOE));
        ItemStack bodyArmor = new ItemStack(Items.LEATHER_CHESTPLATE);
        bodyArmor.getOrCreateTagElement("display").putInt("color", armorColor);
        this.setItemSlot(EquipmentSlotType.CHEST, bodyArmor);

        ItemStack legArmor = new ItemStack(Items.LEATHER_LEGGINGS);
        legArmor.getOrCreateTagElement("display").putInt("color", armorColor);
        this.setItemSlot(EquipmentSlotType.LEGS, legArmor);

        ItemStack feetArmor = new ItemStack(Items.LEATHER_BOOTS);
        feetArmor.getOrCreateTagElement("display").putInt("color", armorColor);
        this.setItemSlot(EquipmentSlotType.FEET, feetArmor);

        this.setCustomName(translateText().withStyle(TextFormatting.GREEN));
        this.setCustomNameVisible(true);
    }

    @Override
    public void remove(boolean keepData) {
        if (!this.removed) {
            ItemEntity itementity = new ItemEntity(this.level, this.blockPosition().getX(), this.blockPosition().getY(), this.blockPosition().getZ(), new ItemStack(this.MinionItem));
            this.level.addFreshEntity(itementity);
        }
        super.remove(keepData);
    }

    @Override
    public void tick() {
        if (invalidSoil) {
            this.nextPosition = this.nextPosition(this.blockPosition());
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
                    BlockPos tmp = (new BlockPos(this.blockPosition().getX()-this.nextPosition.getX(),
                            this.nextPosition.getY(),this.blockPosition().getZ()-this.nextPosition.getZ()));
                    if (tmp.getX() % 2 == 0 && tmp.getZ() % 2 == 0
                        && this.level.getBlockState(this.nextPosition).getBlock() != this.setBlock) {

                        this.level.setBlockAndUpdate(this.nextPosition, this.minionType.defaultBlockState());
                        this.level.setBlockAndUpdate(this.nextPosition.above(), this.minionType.defaultBlockState());
                        this.level.setBlockAndUpdate(this.nextPosition.above(2), this.minionType.defaultBlockState());
                    } else if ((tmp.getX() % 2 != 0 || tmp.getZ() % 2 != 0)
                            && this.level.getBlockState(this.nextPosition).getBlock() != setBlock2) {
                        Direction direction = Direction.WEST;
                        if (tmp.getZ() == 1 && tmp.getX() % 2 == 0)
                            direction = Direction.NORTH;
                        else if (tmp.getZ() == -1 && tmp.getX() % 2 == 0)
                            direction = Direction.SOUTH;
                        else if (tmp.getX() == -1 && tmp.getZ() % 2 == 0)
                            direction = Direction.EAST;
                        Utils.printLogger("BLOCK:"+this.level.getBlockState(this.nextPosition).getBlock());

                        //Utils.printLogger(tmp.getX()+", "+tmp.getZ()+": "+direction);

                        this.level.setBlockAndUpdate(this.nextPosition, setBlock2.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, direction));
                        this.level.setBlockAndUpdate(this.nextPosition.above(), setBlock2.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, direction));
                        this.level.setBlockAndUpdate(this.nextPosition.above(2), setBlock2.defaultBlockState().setValue(CocoaBlock.AGE, 2).setValue(CocoaBlock.FACING, direction));
                    } else {
                        IInventory chest = findContainer();

                        this.level.destroyBlock(this.nextPosition, false);
                        this.level.destroyBlock(this.nextPosition.above(), false);
                        this.level.destroyBlock(this.nextPosition.above(2), false);

                        ItemStack retItem = new ItemStack(this.setBlock2, returnQuanity);

                        if (chest == null) {
                            addItem(this.getInventory(), retItem);
                        } else {
                            addItem(chest, retItem);
                        }
                        //this.setNextAction(3 * 20 + this.getTickCount());
                    }

                }
                this.nextPosition = this.nextPosition(this.blockPosition());
            }
        }
        this.tickCount++;
        super.tick();
    }

    public BlockPos nextPosition(BlockPos center) {
        ArrayList<BlockPos> listOfPotentialBlocks = new ArrayList<>();
        BlockPos tmp;
        Boolean nextCell = true;
        for (int x = -radius; x < radius + 1; x++)
            for (int z = -radius; z < radius + 1; z++) {
                tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                nextCell = (x % 2) == 0 && (z % 2) == 0;
                if (nextCell) {
                    if (this.level.getBlockState(tmp) != this.getMinionType().defaultBlockState() &&
                            Utils.getDistanceToEntity(this, tmp) > 1.0D) {
                        listOfPotentialBlocks.add(tmp);
                    }
                }
            }
        if (listOfPotentialBlocks.size() == 0) {
            for (int x = -radius; x < radius + 1; x++)
                for (int z = -radius; z < radius + 1; z++) {
                    tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                    nextCell = (((x % 2) != 0 && z % 2 == 0) || (x % 2 == 0 && (z % 2) != 0));
                    if (nextCell) {
                        //Utils.printLogger(x+", "+z);;

                        if (this.level.getBlockState(tmp).getBlock() != setBlock2 &&
                                Utils.getDistanceToEntity(this, tmp) > 0D) {
                            //Utils.printLogger("BLOCKSTATE: "+this.level.getBlockState(tmp));
                            listOfPotentialBlocks.add(tmp);
                        }
                    }
                }
        }
        if (listOfPotentialBlocks.size() == 0) {
            for (int x = -radius; x < radius + 1; x++)
                for (int z = -radius; z < radius + 1; z++) {
                    tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                    nextCell = (((x % 2) != 0 && z % 2 == 0) || (x % 2 == 0 && (z % 2) != 0));
                    if (nextCell) {
                        if (this.level.getBlockState(tmp).getBlock() == setBlock2 &&
                                Utils.getDistanceToEntity(this, tmp) > 0D) {
                            //Utils.printLogger("BLOCKSTATE: "+this.level.getBlockState(tmp));
                            listOfPotentialBlocks.add(tmp);
                        }
                    }
                }
        }
        if (listOfPotentialBlocks.size() > 0) {
            BlockPos ret = listOfPotentialBlocks.get(Utils.random(listOfPotentialBlocks.size()));
            //Utils.printLogger("POS: "+ret);
            return ret;
        }
        return null;
    }
}


