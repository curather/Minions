package com.gum.minions.mixins;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin {

    @Inject(method = "Lnet/minecraft/entity/MobEntity;dropFromLootTable(Lnet/minecraft/util/DamageSource;Z)V",
            at = @At("HEAD"),
            cancellable = true)
    public void dropFromLootTable(DamageSource p_213354_1_, boolean p_213354_2_, CallbackInfo ci) {
        //Hacky way to disable mob drops if Minion kills the mob
        if (p_213354_1_ == DamageSource.OUT_OF_WORLD)
            ci.cancel();
    }
}
