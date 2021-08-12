package com.gum.minions;

import com.gum.minions.minions.AbstractMinionEntity;
import com.gum.minions.minions.MinionRenderer;
import com.gum.minions.minions.MinionSayings;
import com.gum.minions.registers.EntityRegister;
import com.gum.minions.registers.ItemRegister;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("deprecation")
@Mod(Minions.MODID)
@Mod.EventBusSubscriber(modid = Minions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Minions {
    // Directly reference a log4j logger.
    public static boolean minionChatting=false;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "minions";
    public static boolean isDevelopment = !FMLEnvironment.production;
    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public Minions() {

        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register Custom Entities
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onEntityAttributeCreation);
        FMLJavaModLoadingContext.get().getModEventBus().register(this);

        EntityRegister.ENTITIES.register(modEventBus);
        ItemRegister.ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MinionSayings.init();
    }

    @SubscribeEvent
    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(EntityRegister.COBBLESTONE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.COAL_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.DIAMOND_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.EMERALD_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.GLOWSTONE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.GOLD_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.GRAVEL_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.ICE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.IRON_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.LAPIS_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.OBSIDIAN_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.QUARTZ_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.REDSTONE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.SAND_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.NETHERITE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.SNOW_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.ACACIA_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.BIRCH_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.JUNGLE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.DARKOAK_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.OAK_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.SPRUCE_MINION, AbstractMinionEntity.registerAttributes().build());

        event.put(EntityRegister.ZOMBIE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.SKELETON_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.SPIDER_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.CAVE_SPIDER_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.CREEPER_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.ENDERMAN_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.GHAST_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.SLIME_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.BLAZE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.MAGMA_CUBE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.END_STONE_MINION, AbstractMinionEntity.registerAttributes().build());

        event.put(EntityRegister.RABBIT_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.SHEEP_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.CHICKEN_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.PIG_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.COW_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.SUGAR_CANE_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.CACTUS_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.COCOA_BEANS_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.MUSHROOM_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.MELON_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.PUMPKIN_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.POTATO_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.CARROT_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.WHEAT_MINION, AbstractMinionEntity.registerAttributes().build());
        event.put(EntityRegister.NETHER_WART_MINION, AbstractMinionEntity.registerAttributes().build());

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        // Register Minions on the client
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.COBBLESTONE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.COAL_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.DIAMOND_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.EMERALD_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.GLOWSTONE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.GOLD_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.GRAVEL_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.ICE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.IRON_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.LAPIS_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.OBSIDIAN_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.QUARTZ_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.REDSTONE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.SAND_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.NETHERITE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.SNOW_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.ACACIA_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.BIRCH_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.JUNGLE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.DARKOAK_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.OAK_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.SPRUCE_MINION, new MinionRenderer.RenderFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.ZOMBIE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.SKELETON_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.SPIDER_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.CAVE_SPIDER_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.CREEPER_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.ENDERMAN_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.GHAST_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.SLIME_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.BLAZE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.MAGMA_CUBE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.END_STONE_MINION, new MinionRenderer.RenderFactory());

        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.RABBIT_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.SHEEP_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.CHICKEN_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.PIG_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.COW_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.SUGAR_CANE_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.CACTUS_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.COCOA_BEANS_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.MUSHROOM_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.MELON_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.PUMPKIN_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.POTATO_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.CARROT_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.WHEAT_MINION, new MinionRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityRegister.NETHER_WART_MINION, new MinionRenderer.RenderFactory());

    }
}
