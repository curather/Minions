package com.gum.minions.gui.renderer;

import com.gum.minions.minions.AbstractMinionItem;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SkullPlayerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.SkullTileEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.SkullTileEntity;
import org.apache.commons.lang3.StringUtils;

//@OnlyIn(Dist.CLIENT)
public class MinionItemRenderer extends ItemStackTileEntityRenderer {

    @Override
    public void renderByItem(ItemStack p_239207_1_, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack p_239207_3_, IRenderTypeBuffer p_239207_4_, int p_239207_5_, int p_239207_6_) {
        Item item = p_239207_1_.getItem();
        p_239207_1_ = item.getDefaultInstance();
        Block block = new SkullPlayerBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(1.0F));
        if (item instanceof AbstractMinionItem) {
            GameProfile gameprofile = null;
            if (p_239207_1_.hasTag()) {
                CompoundNBT compoundnbt = p_239207_1_.getTag();
                if (compoundnbt.contains("SkullOwner", 10)) {
                    gameprofile = NBTUtil.readGameProfile(compoundnbt.getCompound("SkullOwner"));
                } else if (compoundnbt.contains("SkullOwner", 8) && !StringUtils.isBlank(compoundnbt.getString("SkullOwner"))) {
                    GameProfile gameprofile1 = new GameProfile(null, compoundnbt.getString("SkullOwner"));
                    gameprofile = SkullTileEntity.updateGameprofile(gameprofile1);
                    compoundnbt.remove("SkullOwner");
                    compoundnbt.put("SkullOwner", NBTUtil.writeGameProfile(new CompoundNBT(), gameprofile));
                }
            }

            SkullTileEntityRenderer.renderSkull(null, 180.0F, ((AbstractSkullBlock)block).getType(), gameprofile, 0.0F, p_239207_3_, p_239207_4_, p_239207_5_);
        }

    }
}
