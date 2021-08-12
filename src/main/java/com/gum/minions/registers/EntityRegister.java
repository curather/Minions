package com.gum.minions.registers;

import com.gum.minions.Minions;
import com.gum.minions.minions.types.combat.*;
import com.gum.minions.minions.types.farming.*;
import com.gum.minions.minions.types.foraging.*;
import com.gum.minions.minions.types.mining.*;
import com.gum.minions.minions.types.other.iceMinionEntity;
import com.gum.minions.minions.types.other.snowMinionEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegister {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Minions.MODID);

    public static final EntityType<cobblestoneMinionEntity> COBBLESTONE_MINION = EntityType.Builder.of(cobblestoneMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "cobblestone_minion").toString());
    public static final RegistryObject<EntityType<cobblestoneMinionEntity>>
            COBBLESTONE_MINION_REG = ENTITIES.register("cobblestone_minion", () -> COBBLESTONE_MINION);

    public static final EntityType<coalMinionEntity> COAL_MINION = EntityType.Builder.of(coalMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "coal_minion").toString());

    public static final RegistryObject<EntityType<coalMinionEntity>>
            COAL_MINION_REG = ENTITIES.register("coal_minion", () -> COAL_MINION);

    public static final EntityType<diamondMinionEntity> DIAMOND_MINION = EntityType.Builder.of(diamondMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "diamond_minion").toString());
    public static final RegistryObject<EntityType<diamondMinionEntity>>
            DIAMOND_MINION_REG = ENTITIES.register("diamond_minion", () -> DIAMOND_MINION);

    public static final EntityType<emeraldMinionEntity> EMERALD_MINION = EntityType.Builder.of(emeraldMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "emerald_minion").toString());
    public static final RegistryObject<EntityType<emeraldMinionEntity>>
            EMERALD_MINION_REG = ENTITIES.register("emerald_minion", () -> EMERALD_MINION);

    public static final EntityType<glowstoneMinionEntity> GLOWSTONE_MINION = EntityType.Builder.of(glowstoneMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "glowstone_minion").toString());
    public static final RegistryObject<EntityType<glowstoneMinionEntity>>
            GLOWSTONE_MINION_REG = ENTITIES.register("glowstone_minion", () -> GLOWSTONE_MINION);

    public static final EntityType<goldMinionEntity> GOLD_MINION = EntityType.Builder.of(goldMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "gold_minion").toString());
    public static final RegistryObject<EntityType<goldMinionEntity>>
            GOLD_MINION_REG = ENTITIES.register("gold_minion", () -> GOLD_MINION);

    public static final EntityType<gravelMinionEntity> GRAVEL_MINION = EntityType.Builder.of(gravelMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "gravel_minion").toString());
    public static final RegistryObject<EntityType<gravelMinionEntity>>
            GRAVEL_MINION_REG = ENTITIES.register("gravel_minion", () -> GRAVEL_MINION);

    public static final EntityType<iceMinionEntity> ICE_MINION = EntityType.Builder.of(iceMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "ice_minion").toString());
    public static final RegistryObject<EntityType<iceMinionEntity>>
            ICE_MINION_REG = ENTITIES.register("ice_minion", () -> ICE_MINION);

    public static final EntityType<ironMinionEntity> IRON_MINION = EntityType.Builder.of(ironMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "iron_minion").toString());
    public static final RegistryObject<EntityType<ironMinionEntity>>
            IRON_MINION_REG = ENTITIES.register("iron_minion", () -> IRON_MINION);

    public static final EntityType<lapisMinionEntity> LAPIS_MINION = EntityType.Builder.of(lapisMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "lapis_minion").toString());
    public static final RegistryObject<EntityType<lapisMinionEntity>>
            LAPIS_MINION_REG = ENTITIES.register("lapis_minion", () -> LAPIS_MINION);

    public static final EntityType<obsidianMinionEntity> OBSIDIAN_MINION = EntityType.Builder.of(obsidianMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "obsidian_minion").toString());
    public static final RegistryObject<EntityType<obsidianMinionEntity>>
            OBSIDIAN_MINION_REG = ENTITIES.register("obsidian_minion", () -> OBSIDIAN_MINION);

    public static final EntityType<quartzMinionEntity> QUARTZ_MINION = EntityType.Builder.of(quartzMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "quartz_minion").toString());
    public static final RegistryObject<EntityType<quartzMinionEntity>>
            QUARTZ_MINION_REG = ENTITIES.register("quartz_minion", () -> QUARTZ_MINION);

    public static final EntityType<redstoneMinionEntity> REDSTONE_MINION = EntityType.Builder.of(redstoneMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "redstone_minion").toString());
    public static final RegistryObject<EntityType<redstoneMinionEntity>>
            REDSTONE_MINION_REG = ENTITIES.register("redstone_minion", () -> REDSTONE_MINION);

    public static final EntityType<sandMinionEntity> SAND_MINION = EntityType.Builder.of(sandMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "sand_minion").toString());
    public static final RegistryObject<EntityType<sandMinionEntity>>
            SAND_MINION_REG = ENTITIES.register("sand_minion", () -> SAND_MINION);

    public static final EntityType<netheriteMinionEntity> NETHERITE_MINION = EntityType.Builder.of(netheriteMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "netherite_minion").toString());
    public static final RegistryObject<EntityType<netheriteMinionEntity>>
            NETHERITE_MINION_REG = ENTITIES.register("netherite_minion", () -> NETHERITE_MINION);

    public static final EntityType<snowMinionEntity> SNOW_MINION = EntityType.Builder.of(snowMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "snow_minion").toString());
    public static final RegistryObject<EntityType<snowMinionEntity>>
            SNOW_MINION_REG = ENTITIES.register("snow_minion", () -> SNOW_MINION);

    public static final EntityType<acaciaMinionEntity> ACACIA_MINION = EntityType.Builder.of(acaciaMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "acacia_minion").toString());
    public static final RegistryObject<EntityType<acaciaMinionEntity>>
            ACACIA_MINION_REG = ENTITIES.register("acacia_minion", () -> ACACIA_MINION);

    public static final EntityType<birchMinionEntity> BIRCH_MINION = EntityType.Builder.of(birchMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "birch_minion").toString());
    public static final RegistryObject<EntityType<birchMinionEntity>>
            BIRCH_MINION_REG = ENTITIES.register("birch_minion", () -> BIRCH_MINION);

    public static final EntityType<jungleMinionEntity> JUNGLE_MINION = EntityType.Builder.of(jungleMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "jungle_minion").toString());
    public static final RegistryObject<EntityType<jungleMinionEntity>>
            JUNGLE_MINION_REG = ENTITIES.register("jungle_minion", () -> JUNGLE_MINION);

    public static final EntityType<darkoakMinionEntity> DARKOAK_MINION = EntityType.Builder.of(darkoakMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "darkoak_minion").toString());
    public static final RegistryObject<EntityType<darkoakMinionEntity>>
            DARKOAK_MINION_REG = ENTITIES.register("darkoak_minion", () -> DARKOAK_MINION);

    public static final EntityType<oakMinionEntity> OAK_MINION = EntityType.Builder.of(oakMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "oak_minion").toString());
    public static final RegistryObject<EntityType<oakMinionEntity>>
            OAK_MINION_REG = ENTITIES.register("oak_minion", () -> OAK_MINION);

    public static final EntityType<spruceMinionEntity> SPRUCE_MINION = EntityType.Builder.of(spruceMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "spruce_minion").toString());
    public static final RegistryObject<EntityType<spruceMinionEntity>>
            SPRUCE_MINION_REG = ENTITIES.register("spruce_minion", () -> SPRUCE_MINION);

    public static final EntityType<sugar_caneMinionEntity> SUGAR_CANE_MINION = EntityType.Builder.of(sugar_caneMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "sugar_cane_minion").toString());
    public static final RegistryObject<EntityType<sugar_caneMinionEntity>>
            SUGAR_CANE_MINION_REG = ENTITIES.register("sugar_cane_minion", () -> SUGAR_CANE_MINION);

    public static final EntityType<cactusMinionEntity> CACTUS_MINION = EntityType.Builder.of(cactusMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "cactus_minion").toString());
    public static final RegistryObject<EntityType<cactusMinionEntity>>
            CACTUS_MINION_REG = ENTITIES.register("cactus_minion", () -> CACTUS_MINION);

    public static final EntityType<cocoa_beansMinionEntity> COCOA_BEANS_MINION = EntityType.Builder.of(cocoa_beansMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "cocoa_beans_minion").toString());
    public static final RegistryObject<EntityType<cocoa_beansMinionEntity>>
            COCOA_BEANS_MINION_REG = ENTITIES.register("cocoa_beans_minion", () -> COCOA_BEANS_MINION);

    public static final EntityType<mushroomMinionEntity> MUSHROOM_MINION = EntityType.Builder.of(mushroomMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "mushroom_minion").toString());
    public static final RegistryObject<EntityType<mushroomMinionEntity>>
            MUSHROOM_MINION_REG = ENTITIES.register("mushroom_minion", () -> MUSHROOM_MINION);

    public static final EntityType<melonMinionEntity> MELON_MINION = EntityType.Builder.of(melonMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "melon_minion").toString());
    public static final RegistryObject<EntityType<melonMinionEntity>>
            MELON_MINION_REG = ENTITIES.register("melon_minion", () -> MELON_MINION);

    public static final EntityType<pumpkinMinionEntity> PUMPKIN_MINION = EntityType.Builder.of(pumpkinMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "pumpkin_minion").toString());
    public static final RegistryObject<EntityType<pumpkinMinionEntity>>
            PUMPKIN_MINION_REG = ENTITIES.register("pumpkin_minion", () -> PUMPKIN_MINION);

    public static final EntityType<potatoMinionEntity> POTATO_MINION = EntityType.Builder.of(potatoMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "potato_minion").toString());
    public static final RegistryObject<EntityType<potatoMinionEntity>>
            POTATO_MINION_REG = ENTITIES.register("potato_minion", () -> POTATO_MINION);

    public static final EntityType<carrotMinionEntity> CARROT_MINION = EntityType.Builder.of(carrotMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "carrot_minion").toString());
    public static final RegistryObject<EntityType<carrotMinionEntity>>
            CARROT_MINION_REG = ENTITIES.register("carrot_minion", () -> CARROT_MINION);

    public static final EntityType<wheatMinionEntity> WHEAT_MINION = EntityType.Builder.of(wheatMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "wheat_minion").toString());
    public static final RegistryObject<EntityType<wheatMinionEntity>>
            WHEAT_MINION_REG = ENTITIES.register("wheat_minion", () -> WHEAT_MINION);

    public static final EntityType<end_stoneMinionEntity> END_STONE_MINION = EntityType.Builder.of(end_stoneMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "end_stone_minion").toString());
    public static final RegistryObject<EntityType<end_stoneMinionEntity>>
            END_STONE_MINION_REG = ENTITIES.register("end_stone_minion", () -> END_STONE_MINION);

    public static final EntityType<nether_wartMinionEntity> NETHER_WART_MINION = EntityType.Builder.of(nether_wartMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "nether_wart_minion").toString());
    public static final RegistryObject<EntityType<nether_wartMinionEntity>>
            NETHER_WART_MINION_REG = ENTITIES.register("nether_wart_minion", () -> NETHER_WART_MINION);

    public static final EntityType<rabbitMinionEntity> RABBIT_MINION = EntityType.Builder.of(rabbitMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "rabbit_minion").toString());
    public static final RegistryObject<EntityType<rabbitMinionEntity>>
            RABBIT_MINION_REG = ENTITIES.register("rabbit_minion", () -> RABBIT_MINION);

    public static final EntityType<sheepMinionEntity> SHEEP_MINION = EntityType.Builder.of(sheepMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "sheep_minion").toString());
    public static final RegistryObject<EntityType<sheepMinionEntity>>
            SHEEP_MINION_REG = ENTITIES.register("sheep_minion", () -> SHEEP_MINION);

    public static final EntityType<chickenMinionEntity> CHICKEN_MINION = EntityType.Builder.of(chickenMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "chicken_minion").toString());
    public static final RegistryObject<EntityType<chickenMinionEntity>>
            CHICKEN_MINION_REG = ENTITIES.register("chicken_minion", () -> CHICKEN_MINION);

    public static final EntityType<pigMinionEntity> PIG_MINION = EntityType.Builder.of(pigMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "pig_minion").toString());
    public static final RegistryObject<EntityType<pigMinionEntity>>
            PIG_MINION_REG = ENTITIES.register("pig_minion", () -> PIG_MINION);

    public static final EntityType<cowMinionEntity> COW_MINION = EntityType.Builder.of(cowMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "cow_minion").toString());
    public static final RegistryObject<EntityType<cowMinionEntity>>
            COW_MINION_REG = ENTITIES.register("cow_minion", () -> COW_MINION);

    public static final EntityType<zombieMinionEntity> ZOMBIE_MINION = EntityType.Builder.of(zombieMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "zombie_minion").toString());
    public static final RegistryObject<EntityType<zombieMinionEntity>>
            ZOMBIE_MINION_REG = ENTITIES.register("zombie_minion", () -> ZOMBIE_MINION);

    public static final EntityType<skeletonMinionEntity> SKELETON_MINION = EntityType.Builder.of(skeletonMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "skeleton_minion").toString());
    public static final RegistryObject<EntityType<skeletonMinionEntity>>
            SKELETON_MINION_REG = ENTITIES.register("skeleton_minion", () -> SKELETON_MINION);

    public static final EntityType<spiderMinionEntity> SPIDER_MINION = EntityType.Builder.of(spiderMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "spider_minion").toString());
    public static final RegistryObject<EntityType<spiderMinionEntity>>
            SPIDER_MINION_REG = ENTITIES.register("spider_minion", () -> SPIDER_MINION);

    public static final EntityType<cave_spiderMinionEntity> CAVE_SPIDER_MINION = EntityType.Builder.of(cave_spiderMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "cave_spider_minion").toString());
    public static final RegistryObject<EntityType<cave_spiderMinionEntity>>
            CAVE_SPIDER_MINION_REG = ENTITIES.register("cave_spider_minion", () -> CAVE_SPIDER_MINION);

    public static final EntityType<creeperMinionEntity> CREEPER_MINION = EntityType.Builder.of(creeperMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "creeper_minion").toString());
    public static final RegistryObject<EntityType<creeperMinionEntity>>
            CREEPER_MINION_REG = ENTITIES.register("creeper_minion", () -> CREEPER_MINION);

    public static final EntityType<endermanMinionEntity> ENDERMAN_MINION = EntityType.Builder.of(endermanMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "enderman_minion").toString());
    public static final RegistryObject<EntityType<endermanMinionEntity>>
            ENDERMAN_MINION_REG = ENTITIES.register("enderman_minion", () -> ENDERMAN_MINION);

    public static final EntityType<ghastMinionEntity> GHAST_MINION = EntityType.Builder.of(ghastMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "ghast_minion").toString());
    public static final RegistryObject<EntityType<ghastMinionEntity>>
            GHAST_MINION_REG = ENTITIES.register("ghast_minion", () -> GHAST_MINION);

    public static final EntityType<slimeMinionEntity> SLIME_MINION = EntityType.Builder.of(slimeMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "slime_minion").toString());
    public static final RegistryObject<EntityType<slimeMinionEntity>>
            SLIME_MINION_REG = ENTITIES.register("slime_minion", () -> SLIME_MINION);

    public static final EntityType<blazeMinionEntity> BLAZE_MINION = EntityType.Builder.of(blazeMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "blaze_minion").toString());
    public static final RegistryObject<EntityType<blazeMinionEntity>>
            BLAZE_MINION_REG = ENTITIES.register("blaze_minion", () -> BLAZE_MINION);

    public static final EntityType<magma_cubeMinionEntity> MAGMA_CUBE_MINION = EntityType.Builder.of(magma_cubeMinionEntity::new, EntityClassification.MISC).sized(0.5F, 1.975F).
            build(new ResourceLocation(Minions.MODID, "magma_cube_minion").toString());
    public static final RegistryObject<EntityType<magma_cubeMinionEntity>>
            MAGMA_CUBE_MINION_REG = ENTITIES.register("magma_cube_minion", () -> MAGMA_CUBE_MINION);


}
