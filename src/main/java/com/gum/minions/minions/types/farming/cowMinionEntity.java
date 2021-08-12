package com.gum.minions.minions.types.farming;

import com.gum.minions.minions.CombatMinionEntity;
import com.gum.minions.minions.MinionSkins;
import com.gum.minions.registers.ItemRegister;
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

public class cowMinionEntity extends CombatMinionEntity {
    /*
    CUSTOMIZABLE MINION ATTRIBUTES
    get Textures and ids from https://minecraft-heads.com/
     */
    ItemStack playerHead = MinionSkins.COW_MINION.playerHead();
    int armorColor = DyeColor.BROWN.getColorValue();
    EntityType setEntity = EntityType.COW;
    HashMap<Item, Float> bonusItemList = new HashMap<>();
    Item retItem = Items.BEEF;
    int minionSpeed = 26 * 20;
    Item MinionItem = ItemRegister.COW_MINION;
    /*
    DON'T EDIT BELOW HERE
     */
    static cowMinionEntity armorstandentity;

    public cowMinionEntity(EntityType<? extends ArmorStandEntity> p_i50225_1_, World p_i50225_2_) {
        super(p_i50225_1_, p_i50225_2_);
        this.setMinionType(setEntity);
        this.setReturnItem(retItem);
        this.setSpeed(minionSpeed);
        bonusItemList.put(Items.LEATHER, 35f);
        this.setBonusItem(bonusItemList);
        this.setReturnQuanity(1);
        this.setItemSlot(EquipmentSlotType.HEAD, playerHead);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
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

