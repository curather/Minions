package com.gum.minions.minions;

import com.gum.minions.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CombatMinionEntity extends AbstractMinionEntity {
    EntityType minionType = EntityType.ZOMBIE;
    Class minionClass = ZombieEntity.class;
    int spawnLimit = 5;

    public CombatMinionEntity(EntityType<? extends ArmorStandEntity> p_i50225_1_, World p_i50225_2_) {
        super(p_i50225_1_, p_i50225_2_);
    }

    public void setMinionType(EntityType tmp) {
        this.minionType = tmp;
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
                    List<Entity> entityList = this.level.getEntitiesOfClass(minionType.create(this.level).getClass(), this.getBoundingBox().inflate(radius + 1));
                    if (entityList.size() < spawnLimit) {
                        this.minionType.spawn((ServerWorld) this.world, null, null, null, this.nextPosition, SpawnReason.SPAWN_EGG, true, false);
                    } else {
                        IInventory chest = findContainer();
                        boolean bonus = false;
                        Entity entitySelected = entityList.get(Utils.random(entityList.size()));
                        entitySelected.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);


                        ItemStack retItem = new ItemStack(this.returnItem, returnQuanity);
                        if (bonusItem.size() > 0) {
                            for (Map.Entry mapElement : bonusItem.entrySet()) {
                                ItemStack tmp = new ItemStack((Item) mapElement.getKey());
                                Float chance = (Float) mapElement.getValue();
                                if ((Math.random() * 100) <= chance && !bonus) {
                                    if (chest == null) {
                                        addItem(this.getInventory(), tmp);
                                    } else {
                                        addItem(chest, tmp);
                                    }
                                    bonus=true;
                                    break;
                                }
                            }
                        }
                        if (!bonus) {
                            if (chest == null) {
                                addItem(this.getInventory(), retItem);
                            } else {
                                addItem(chest, retItem);
                            }
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

    @Override
    public BlockPos nextPosition(BlockPos center) {
        ArrayList<BlockPos> listOfPotentialBlocks = new ArrayList<>();
        BlockPos tmp;
        for (int x = -radius; x < radius + 1; x++)
            for (int z = -radius; z < radius + 1; z++) {
                tmp = new BlockPos(center.getX() + x, center.getY(), center.getZ() + z);
                if (Utils.getDistanceToEntity(this, tmp) > 1.0D) {
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
