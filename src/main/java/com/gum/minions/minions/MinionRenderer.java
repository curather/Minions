package com.gum.minions.minions;

import com.gum.minions.util.Utils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.ArmorStandArmorModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class MinionRenderer extends LivingRenderer<AbstractMinionEntity, MinionArmorModel> {
    public static final ResourceLocation DEFAULT_SKIN_LOCATION = new ResourceLocation("textures/entity/armorstand/wood.png");

    public MinionRenderer(EntityRendererManager p_i46195_1_) {
        super(p_i46195_1_, new MinionStandModel(), 0.0F);
        this.addLayer(new BipedArmorLayer<>(this, new MinionArmorModel(0.5F), new MinionArmorModel(1.0F)));
        this.addLayer(new HeldItemLayer<>(this));
        this.addLayer(new ElytraLayer<>(this));
        this.addLayer(new HeadLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractMinionEntity p_110775_1_) {
        return DEFAULT_SKIN_LOCATION;
    }
    @Override
    protected boolean shouldShowName(AbstractMinionEntity p_177070_1_) {
        return true;
    }

    @SuppressWarnings("rawtypes")
    public static class RenderFactory implements IRenderFactory {
        @Override
        public EntityRenderer<? super AbstractMinionEntity> createRenderFor(EntityRendererManager manager) {
            return new MinionRenderer(manager);
        }
    }
}
