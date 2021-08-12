package com.gum.minions.registers;

import com.gum.minions.Minions;
import com.gum.minions.minions.AbstractMinionItem;
import com.gum.minions.minions.MinionSkins;
import com.gum.minions.gui.renderer.MinionItemRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Minions.MODID);

    public static final Item COBBLESTONE_MINION = new AbstractMinionItem(EntityRegister.COBBLESTONE_MINION,
            MinionSkins.COBBLESTONE_MINION.returnTexture(), MinionSkins.COBBLESTONE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> COBBLESTONE_MINION_REG = ITEMS.register("cobblestone_minion", () -> COBBLESTONE_MINION);

    public static final Item COAL_MINION = new AbstractMinionItem(EntityRegister.COAL_MINION,
            MinionSkins.COAL_MINION.returnTexture(), MinionSkins.COAL_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> COAL_MINION_REG = ITEMS.register("coal_minion", () -> COAL_MINION);

    public static final Item DIAMOND_MINION = new AbstractMinionItem(EntityRegister.DIAMOND_MINION,
            MinionSkins.DIAMOND_MINION.returnTexture(), MinionSkins.DIAMOND_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> DIAMOND_MINION_REG = ITEMS.register("diamond_minion", () -> DIAMOND_MINION);

    public static final Item EMERALD_MINION = new AbstractMinionItem(EntityRegister.EMERALD_MINION,
            MinionSkins.EMERALD_MINION.returnTexture(), MinionSkins.EMERALD_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> EMERALD_MINION_REG = ITEMS.register("emerald_minion", () -> EMERALD_MINION);

    public static final Item GLOWSTONE_MINION = new AbstractMinionItem(EntityRegister.GLOWSTONE_MINION,
            MinionSkins.GLOWSTONE_MINION.returnTexture(), MinionSkins.GLOWSTONE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> GLOWSTONE_MINION_REG = ITEMS.register("glowstone_minion", () -> GLOWSTONE_MINION);

    public static final Item GOLD_MINION = new AbstractMinionItem(EntityRegister.GOLD_MINION,
            MinionSkins.GOLD_MINION.returnTexture(), MinionSkins.GOLD_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> GOLD_MINION_REG = ITEMS.register("gold_minion", () -> GOLD_MINION);

    public static final Item GRAVEL_MINION = new AbstractMinionItem(EntityRegister.GRAVEL_MINION,
            MinionSkins.GRAVEL_MINION.returnTexture(), MinionSkins.GRAVEL_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> GRAVEL_MINION_REG = ITEMS.register("gravel_minion", () -> GRAVEL_MINION);

    public static final Item ICE_MINION = new AbstractMinionItem(EntityRegister.ICE_MINION,
            MinionSkins.ICE_MINION.returnTexture(), MinionSkins.ICE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> ICE_MINION_REG = ITEMS.register("ice_minion", () -> ICE_MINION);

    public static final Item IRON_MINION = new AbstractMinionItem(EntityRegister.IRON_MINION,
            MinionSkins.IRON_MINION.returnTexture(), MinionSkins.IRON_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> IRON_MINION_REG = ITEMS.register("iron_minion", () -> IRON_MINION);

    public static final Item LAPIS_MINION = new AbstractMinionItem(EntityRegister.LAPIS_MINION,
            MinionSkins.LAPIS_MINION.returnTexture(), MinionSkins.LAPIS_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> LAPIS_MINION_REG = ITEMS.register("lapis_minion", () -> LAPIS_MINION);

    public static final Item OBSIDIAN_MINION = new AbstractMinionItem(EntityRegister.OBSIDIAN_MINION,
            MinionSkins.OBSIDIAN_MINION.returnTexture(), MinionSkins.OBSIDIAN_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> OBSIDIAN_MINION_REG = ITEMS.register("obsidian_minion", () -> OBSIDIAN_MINION);

    public static final Item QUARTZ_MINION = new AbstractMinionItem(EntityRegister.QUARTZ_MINION,
            MinionSkins.QUARTZ_MINION.returnTexture(), MinionSkins.QUARTZ_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> QUARTZ_MINION_REG = ITEMS.register("quartz_minion", () -> QUARTZ_MINION);

    public static final Item REDSTONE_MINION = new AbstractMinionItem(EntityRegister.REDSTONE_MINION,
            MinionSkins.REDSTONE_MINION.returnTexture(), MinionSkins.REDSTONE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> REDSTONE_MINION_REG = ITEMS.register("redstone_minion", () -> REDSTONE_MINION);

    public static final Item SAND_MINION = new AbstractMinionItem(EntityRegister.SAND_MINION,
            MinionSkins.SAND_MINION.returnTexture(), MinionSkins.SAND_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> SAND_MINION_REG = ITEMS.register("sand_minion", () -> SAND_MINION);

    public static final Item NETHERITE_MINION = new AbstractMinionItem(EntityRegister.NETHERITE_MINION,
            MinionSkins.COBBLESTONE_MINION.returnTexture(), MinionSkins.COBBLESTONE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> NETHERITE_MINION_REG = ITEMS.register("netherite_minion", () -> NETHERITE_MINION);

    public static final Item SNOW_MINION = new AbstractMinionItem(EntityRegister.SNOW_MINION,
            MinionSkins.SNOW_MINION.returnTexture(), MinionSkins.SNOW_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> SNOW_MINION_REG = ITEMS.register("snow_minion", () -> SNOW_MINION);

    public static final Item ACACIA_MINION = new AbstractMinionItem(EntityRegister.ACACIA_MINION,
            MinionSkins.ACACIA_MINION.returnTexture(), MinionSkins.ACACIA_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> ACACIA_MINION_REG = ITEMS.register("acacia_minion", () -> ACACIA_MINION);

    public static final Item BIRCH_MINION = new AbstractMinionItem(EntityRegister.BIRCH_MINION,
            MinionSkins.BIRCH_MINION.returnTexture(), MinionSkins.BIRCH_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> BIRCH_MINION_REG = ITEMS.register("birch_minion", () -> BIRCH_MINION);

    public static final Item JUNGLE_MINION = new AbstractMinionItem(EntityRegister.JUNGLE_MINION,
            MinionSkins.JUNGLE_MINION.returnTexture(), MinionSkins.JUNGLE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> JUNGLE_MINION_REG = ITEMS.register("jungle_minion", () -> JUNGLE_MINION);

    public static final Item DARKOAK_MINION = new AbstractMinionItem(EntityRegister.DARKOAK_MINION,
            MinionSkins.DARKOAK_MINION.returnTexture(), MinionSkins.DARKOAK_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> DARKOAK_MINION_REG = ITEMS.register("darkoak_minion", () -> DARKOAK_MINION);

    public static final Item OAK_MINION = new AbstractMinionItem(EntityRegister.OAK_MINION,
            MinionSkins.OAK_MINION.returnTexture(), MinionSkins.OAK_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> OAK_MINION_REG = ITEMS.register("oak_minion", () -> OAK_MINION);

    public static final Item SPRUCE_MINION = new AbstractMinionItem(EntityRegister.SPRUCE_MINION,
            MinionSkins.SPRUCE_MINION.returnTexture(), MinionSkins.SPRUCE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> SPRUCE_MINION_REG = ITEMS.register("spruce_minion", () -> SPRUCE_MINION);

    public static final Item ZOMBIE_MINION = new AbstractMinionItem(EntityRegister.ZOMBIE_MINION,
            MinionSkins.ZOMBIE_MINION.returnTexture(), MinionSkins.ZOMBIE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> ZOMBIE_MINION_REG = ITEMS.register("zombie_minion", () -> ZOMBIE_MINION);

    public static final Item SKELETON_MINION = new AbstractMinionItem(EntityRegister.SKELETON_MINION,
            MinionSkins.SKELETON_MINION.returnTexture(), MinionSkins.SKELETON_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> SKELETON_MINION_REG = ITEMS.register("skeleton_minion", () -> SKELETON_MINION);

    public static final Item SPIDER_MINION = new AbstractMinionItem(EntityRegister.SPIDER_MINION,
            MinionSkins.SPIDER_MINION.returnTexture(), MinionSkins.SPIDER_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> SPIDER_MINION_REG = ITEMS.register("spider_minion", () -> SPIDER_MINION);

    public static final Item CAVE_SPIDER_MINION = new AbstractMinionItem(EntityRegister.CAVE_SPIDER_MINION,
            MinionSkins.CAVE_SPIDER_MINION.returnTexture(), MinionSkins.CAVE_SPIDER_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> cave_spider_MINION_REG = ITEMS.register("cave_spider_minion", () -> CAVE_SPIDER_MINION);

    public static final Item CREEPER_MINION = new AbstractMinionItem(EntityRegister.CREEPER_MINION,
            MinionSkins.CREEPER_MINION.returnTexture(), MinionSkins.CREEPER_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> CREEPER_MINION_REG = ITEMS.register("creeper_minion", () -> CREEPER_MINION);

    public static final Item ENDERMAN_MINION = new AbstractMinionItem(EntityRegister.ENDERMAN_MINION,
            MinionSkins.ENDERMAN_MINION.returnTexture(), MinionSkins.ENDERMAN_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> ENDERMAN_MINION_REG = ITEMS.register("enderman_minion", () -> ENDERMAN_MINION);

    public static final Item GHAST_MINION = new AbstractMinionItem(EntityRegister.GHAST_MINION,
            MinionSkins.GHAST_MINION.returnTexture(), MinionSkins.GHAST_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> GHAST_MINION_REG = ITEMS.register("ghast_minion", () -> GHAST_MINION);

    public static final Item SLIME_MINION = new AbstractMinionItem(EntityRegister.SLIME_MINION,
            MinionSkins.SLIME_MINION.returnTexture(), MinionSkins.SLIME_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> SLIME_MINION_REG = ITEMS.register("slime_minion", () -> SLIME_MINION);

    public static final Item BLAZE_MINION = new AbstractMinionItem(EntityRegister.BLAZE_MINION,
            MinionSkins.BLAZE_MINION.returnTexture(), MinionSkins.BLAZE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> BLAZE_MINION_REG = ITEMS.register("blaze_minion", () -> BLAZE_MINION);

    public static final Item MAGMA_CUBE_MINION = new AbstractMinionItem(EntityRegister.MAGMA_CUBE_MINION,
            MinionSkins.MAGMA_CUBE_MINION.returnTexture(), MinionSkins.MAGMA_CUBE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> MAGMA_CUBE_MINION_REG = ITEMS.register("magma_cube_minion", () -> MAGMA_CUBE_MINION);

    public static final Item END_STONE_MINION = new AbstractMinionItem(EntityRegister.END_STONE_MINION,
            MinionSkins.END_STONE_MINION.returnTexture(), MinionSkins.END_STONE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> END_STONE_MINION_REG = ITEMS.register("end_stone_minion", () -> END_STONE_MINION);

    public static final Item RABBIT_MINION = new AbstractMinionItem(EntityRegister.RABBIT_MINION,
            MinionSkins.RABBIT_MINION.returnTexture(), MinionSkins.RABBIT_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> RABBIT_MINION_REG = ITEMS.register("rabbit_minion", () -> RABBIT_MINION);

    public static final Item SHEEP_MINION = new AbstractMinionItem(EntityRegister.SHEEP_MINION,
            MinionSkins.SHEEP_MINION.returnTexture(), MinionSkins.SHEEP_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> SHEEP_MINION_REG = ITEMS.register("sheep_minion", () -> SHEEP_MINION);

    public static final Item CHICKEN_MINION = new AbstractMinionItem(EntityRegister.CHICKEN_MINION,
            MinionSkins.CHICKEN_MINION.returnTexture(), MinionSkins.CHICKEN_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> CHICKEN_MINION_REG = ITEMS.register("chicken_minion", () -> CHICKEN_MINION);

    public static final Item PIG_MINION = new AbstractMinionItem(EntityRegister.PIG_MINION,
            MinionSkins.PIG_MINION.returnTexture(), MinionSkins.PIG_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> PIG_MINION_REG = ITEMS.register("pig_minion", () -> PIG_MINION);

    public static final Item COW_MINION = new AbstractMinionItem(EntityRegister.COW_MINION,
            MinionSkins.COW_MINION.returnTexture(), MinionSkins.COW_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> COW_MINION_REG = ITEMS.register("cow_minion", () -> COW_MINION);

    public static final Item SUGAR_CANE_MINION = new AbstractMinionItem(EntityRegister.SUGAR_CANE_MINION,
            MinionSkins.SUGAR_CANE_MINION.returnTexture(), MinionSkins.SUGAR_CANE_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> SUGAR_CANE_MINION_REG = ITEMS.register("sugar_cane_minion", () -> SUGAR_CANE_MINION);

    public static final Item CACTUS_MINION = new AbstractMinionItem(EntityRegister.CACTUS_MINION,
            MinionSkins.CACTUS_MINION.returnTexture(), MinionSkins.CACTUS_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> CACTUS_MINION_REG = ITEMS.register("cactus_minion", () -> CACTUS_MINION);

    public static final Item COCOA_BEANS_MINION = new AbstractMinionItem(EntityRegister.COCOA_BEANS_MINION,
            MinionSkins.COCOA_BEANS_MINION.returnTexture(), MinionSkins.COCOA_BEANS_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> COCOA_BEANS_MINION_REG = ITEMS.register("cocoa_beans_minion", () -> COCOA_BEANS_MINION);

    public static final Item MUSHROOM_MINION = new AbstractMinionItem(EntityRegister.MUSHROOM_MINION,
            MinionSkins.MUSHROOM_MINION.returnTexture(), MinionSkins.MUSHROOM_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> MUSHROOM_MINION_REG = ITEMS.register("mushroom_minion", () -> MUSHROOM_MINION);

    public static final Item MELON_MINION = new AbstractMinionItem(EntityRegister.MELON_MINION,
            MinionSkins.MELON_MINION.returnTexture(), MinionSkins.MELON_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> MELON_MINION_REG = ITEMS.register("melon_minion", () -> MELON_MINION);

    public static final Item PUMPKIN_MINION = new AbstractMinionItem(EntityRegister.PUMPKIN_MINION,
            MinionSkins.PUMPKIN_MINION.returnTexture(), MinionSkins.PUMPKIN_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> PUMPKIN_MINION_REG = ITEMS.register("pumpkin_minion", () -> PUMPKIN_MINION);

    public static final Item POTATO_MINION = new AbstractMinionItem(EntityRegister.POTATO_MINION,
            MinionSkins.POTATO_MINION.returnTexture(), MinionSkins.POTATO_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> POTATO_MINION_REG = ITEMS.register("potato_minion", () -> POTATO_MINION);

    public static final Item CARROT_MINION = new AbstractMinionItem(EntityRegister.CARROT_MINION,
            MinionSkins.CARROT_MINION.returnTexture(), MinionSkins.CARROT_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> CARROT_MINION_REG = ITEMS.register("carrot_minion", () -> CARROT_MINION);

    public static final Item WHEAT_MINION = new AbstractMinionItem(EntityRegister.WHEAT_MINION,
            MinionSkins.WHEAT_MINION.returnTexture(), MinionSkins.WHEAT_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> WHEAT_MINION_REG = ITEMS.register("wheat_minion", () -> WHEAT_MINION);

    public static final Item NETHER_WART_MINION = new AbstractMinionItem(EntityRegister.NETHER_WART_MINION,
            MinionSkins.NETHER_WART_MINION.returnTexture(), MinionSkins.NETHER_WART_MINION.returnId(), (new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_MISC).setISTER(() -> MinionItemRenderer::new));
    public static final RegistryObject<Item> NETHER_WART_MINION_REG = ITEMS.register("nether_wart_minion", () -> NETHER_WART_MINION);



}
