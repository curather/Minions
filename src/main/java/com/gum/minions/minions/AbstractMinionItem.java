package com.gum.minions.minions;

import com.google.common.collect.Maps;
import com.gum.minions.util.Utils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Map;

public class AbstractMinionItem extends Item {
    private static final Map<EntityType<?>, AbstractMinionItem> BY_ID = Maps.newIdentityHashMap();
    private final EntityType<?> defaultType;
    String texture;
    String oldid;

    public AbstractMinionItem(EntityType<?> minionType, String tex, String id, Properties p_i48487_1_) {
        super(p_i48487_1_);
        this.defaultType = minionType;
        this.texture = tex;
        this.oldid = id;
        BY_ID.put(minionType, this);

    }
    @Override
    public ItemStack getDefaultInstance() {
        return Utils.getTexturedHead(this.texture, this.oldid, 1);
        //return new ItemStack(this);
    }

    public ActionResultType useOn(ItemUseContext p_195939_1_) {
        Direction direction = p_195939_1_.getClickedFace();
        if (direction == Direction.DOWN) {
            return ActionResultType.FAIL;
        } else {
            World world = p_195939_1_.getLevel();
            BlockItemUseContext blockitemusecontext = new BlockItemUseContext(p_195939_1_);
            BlockPos blockpos = blockitemusecontext.getClickedPos();
            ItemStack itemstack = p_195939_1_.getItemInHand();
            Vector3d vector3d = Vector3d.atBottomCenterOf(blockpos);
            AxisAlignedBB axisalignedbb = new AxisAlignedBB(new BlockPos(vector3d.x(), vector3d.y(), vector3d.z()));
            if (world.noCollision(null, axisalignedbb, (p_242390_0_) -> {
                return true;
            }) && world.getEntities(null, axisalignedbb).isEmpty()) {
                if (world instanceof ServerWorld) {
                    EntityType<?> entitytype = this.getType(itemstack.getTag());
                    if (entitytype.spawn((ServerWorld) world, itemstack, p_195939_1_.getPlayer(), blockpos, SpawnReason.SPAWN_EGG, true, true) != null) {
                        itemstack.shrink(1);
                    }
                    return ActionResultType.CONSUME;
                }

                itemstack.shrink(1);
                return ActionResultType.sidedSuccess(world.isClientSide);
            } else {
                return ActionResultType.FAIL;
            }
        }
    }

    public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
        if (p_208076_1_ != null && p_208076_1_.contains("EntityTag", 10)) {
            CompoundNBT compoundnbt = p_208076_1_.getCompound("EntityTag");
            if (compoundnbt.contains("id", 8)) {
                return EntityType.byString(compoundnbt.getString("id")).orElse(this.defaultType);
            }
        }

        return this.defaultType;
    }
}
