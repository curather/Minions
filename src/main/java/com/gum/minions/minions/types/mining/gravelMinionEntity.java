package com.gum.minions.minions.types.mining;

import com.gum.minions.minions.AbstractMinionEntity;
import com.gum.minions.minions.MinionSkins;
import com.gum.minions.registers.EntityRegister;
import com.gum.minions.registers.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.HashMap;

public class gravelMinionEntity extends AbstractMinionEntity {
    /*
    CUSTOMIZABLE MINION ATTRIBUTES
    get Textures and ids from https://minecraft-heads.com/
     */
    ItemStack playerHead = MinionSkins.GRAVEL_MINION.playerHead();
    int armorColor = DyeColor.BLACK.getColorValue();
    Block setBlock = Blocks.GRAVEL;
    Item retItem = Items.GRAVEL;
    HashMap<Item, Float> bonusItemList = new HashMap<>();
    int minionSpeed = 26 * 20;
    Item MinionItem = ItemRegister.GRAVEL_MINION;
    static EntityType<gravelMinionEntity> typeofMinion = EntityRegister.GRAVEL_MINION;
    /*
    DON'T EDIT BELOW HERE
     */
    static gravelMinionEntity armorstandentity;

    public gravelMinionEntity(EntityType<? extends ArmorStandEntity> p_i50225_1_, World p_i50225_2_) {
        super(p_i50225_1_, p_i50225_2_);
        this.setMinionType(setBlock);
        this.setReturnItem(retItem);
        bonusItemList.put(Items.FLINT, 10f);
        this.setBonusItem(bonusItemList);
        this.setSpeed(minionSpeed);
        this.setItemSlot(EquipmentSlotType.HEAD, playerHead);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.WOODEN_SHOVEL));
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
}

