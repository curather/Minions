package com.gum.minions.minions.types.farming;

import com.gum.minions.minions.AbstractMinionEntity;
import com.gum.minions.minions.MinionSkins;
import com.gum.minions.registers.ItemRegister;
import com.gum.minions.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.ArrayList;
import java.util.UUID;

public class mushroomMinionEntity extends AbstractMinionEntity {
    /*
    CUSTOMIZABLE MINION ATTRIBUTES
    get Textures and ids from https://minecraft-heads.com/
     */
    ItemStack playerHead = MinionSkins.MUSHROOM_MINION.playerHead();
    int armorColor = DyeColor.RED.getColorValue();
    Block setBlock = Blocks.RED_MUSHROOM;
    Block setBlock2 = Blocks.BROWN_MUSHROOM;
    Item retItem = Items.RED_MUSHROOM;
    int minionSpeed = 27 * 20;
    Item MinionItem = ItemRegister.MUSHROOM_MINION;
    /*
    DON'T EDIT BELOW HERE
     */
    static mushroomMinionEntity armorstandentity;

    public mushroomMinionEntity(EntityType<? extends ArmorStandEntity> p_i50225_1_, World p_i50225_2_) {
        super(p_i50225_1_, p_i50225_2_);
        this.setMinionType(setBlock);
        this.setReturnItem(retItem);
        this.setSpeed(minionSpeed);
        this.setReturnQuanity(1);
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

                    if (((tmp.getX() % 2) == 0 && (tmp.getZ() % 2) == 0)
                        && this.level.getBlockState(this.nextPosition) != this.setBlock.defaultBlockState()) {
                        this.level.setBlockAndUpdate(this.nextPosition, this.setBlock.defaultBlockState());
                    } else if ((tmp.getX() % 2 != 0 || tmp.getZ() % 2 != 0)
                            && this.level.getBlockState(this.nextPosition) != setBlock2.defaultBlockState()) {
                        this.level.setBlockAndUpdate(this.nextPosition, setBlock2.defaultBlockState());
                    } else {
                        IInventory chest = findContainer();
                        ItemStack retItem = new ItemStack(this.level.getBlockState(this.nextPosition).getBlock().asItem(), returnQuanity);

                        this.level.destroyBlock(this.nextPosition, false);

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

    boolean validSpot(BlockPos tmp) {
        return (this.level.getBlockState(tmp).getBlock().is(Blocks.PODZOL) ||
                this.level.getBlockState(tmp).getBlock().is(Blocks.MYCELIUM) ||
                this.level.getBlockState(tmp).getBlock().is(Blocks.CRIMSON_NYLIUM) ||
                this.level.getBlockState(tmp).getBlock().is(Blocks.WARPED_NYLIUM) ||
                this.level.getBlockState(tmp).getBlock().is(Blocks.RED_MUSHROOM) ||
                this.level.getBlockState(tmp).getBlock().is(Blocks.BROWN_MUSHROOM));
    }

    public BlockPos nextPosition(BlockPos center) {
        ArrayList<BlockPos> listOfPotentialBlocks = new ArrayList<>();
        BlockPos tmp;
        for (int x = -radius; x < radius + 1; x++)
            for (int z = -radius; z < radius + 1; z++) {
                if ((x % 2) == 0 && (z % 2) == 0) {
                    tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                    if (this.level.getBlockState(tmp).getBlock() != this.getMinionType() && Utils.getDistanceToEntity(this, tmp) > 0.5D) {
                        if (this.level.getBlockState(tmp).getBlock() == Blocks.VOID_AIR)
                            return null;
                        if (!this.validSpot(tmp.below())) {
                            Utils.printLogger("blockpos not perfect: " + tmp.below());
                            Utils.printLogger("BLOCKSTATE# not perfect: " + this.level.getBlockState(tmp.below()));
                            this.setCustomName(new StringTextComponent("This location isn't perfect! :(").withStyle(Style.EMPTY.withColor(TextFormatting.DARK_RED)));
                            invalidSoil = true;
                            if (this.getCurrentSaying() != null) {
                                AbstractMinionEntity otherMinion = this.getChatEntity();
                                resetChat(otherMinion);
                            }
                            return null;
                        }
                        listOfPotentialBlocks.add(tmp);
                    }
                }
            }
        if (listOfPotentialBlocks.size() == 0) {
            for (int x = -radius; x < radius + 1; x++)
                for (int z = -radius; z < radius + 1; z++)
                    if ((x % 2) != 0 || (z % 2) != 0) {
                        tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);

                        if (this.level.getBlockState(tmp).getBlock() != setBlock2 && Utils.getDistanceToEntity(this, tmp) > 0.5D) {
                            if (!this.validSpot(tmp.below())) {
                                Utils.printLogger("blockpos not perfect: " + tmp.below());
                                Utils.printLogger("BLOCKSTATE# not perfect: " + this.level.getBlockState(tmp.below()));
                                this.setCustomName(new StringTextComponent("This location isn't perfect! :(").withStyle(Style.EMPTY.withColor(TextFormatting.DARK_RED)));
                                invalidSoil = true;
                                if (this.getCurrentSaying() != null) {
                                    AbstractMinionEntity otherMinion = this.getChatEntity();
                                    resetChat(otherMinion);
                                }
                                return null;
                            }
                            listOfPotentialBlocks.add(tmp);
                        }
                    }
        }
        if (listOfPotentialBlocks.size() == 0) {
            for (int x = -radius - 1; x < radius + 1; x++)
                for (int z = -radius - 1; z < radius + 1; z++) {
                    tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                        if (this.level.getBlockState(tmp) == setBlock2.defaultBlockState() &&
                                Utils.getDistanceToEntity(this, tmp) > 1.0D)
                            listOfPotentialBlocks.add(tmp);
                }
        }
        if (listOfPotentialBlocks.size() > 0) {
            BlockPos ret = listOfPotentialBlocks.get(Utils.random(listOfPotentialBlocks.size()));
            return ret;
        }
        return null;
    }
}


