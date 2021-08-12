package com.gum.minions.minions;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.Map;
import java.util.UUID;

public class ForestMinionEntity extends AbstractMinionEntity {

    public ForestMinionEntity(EntityType<? extends ArmorStandEntity> p_i50225_1_, World p_i50225_2_) {
        super(p_i50225_1_, p_i50225_2_);
    }

    @Override
    public void tick() {
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
                        this.level.setBlockAndUpdate(this.nextPosition.above(), this.minionType.defaultBlockState());
                        this.level.setBlockAndUpdate(this.nextPosition.above(2), this.minionType.defaultBlockState());
                    } else {
                        IInventory chest = findContainer();
                        this.level.destroyBlock(this.nextPosition, false);
                        this.level.destroyBlock(this.nextPosition.above(), false);
                        this.level.destroyBlock(this.nextPosition.above(2), false);

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
                this.nextPosition = this.nextPosition(this.blockPosition());
            }
        }
        this.tickCount++;
        super.tick();
    }
}
