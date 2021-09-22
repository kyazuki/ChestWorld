package com.github.kyazuki.chestworld.world.biome;

import com.github.kyazuki.chestworld.ChestWorld;
import com.github.kyazuki.chestworld.world.gen.feature.structure.ChestVillagePools;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ChestWorldBiomeMaker extends BiomeMaker {
    public static final BaseTreeFeatureConfig CHEST_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ChestWorld.CHEST_BLOCK.getDefaultState()), new SimpleBlockStateProvider(ChestWorld.CHEST_BLOCK_LEAVES.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
    public static final BlockStateProvidingFeatureConfig HAY_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(ChestWorld.CHEST_BLOCK.getDefaultState()));

    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome makeChestBiome() {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withSpawnsWithHorseAndDonkey(mobspawninfo$builder);
        mobspawninfo$builder.isValidSpawnBiomeForPlayer();

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(ChestWorld.CHEST_BLOCK.getDefaultState(), ChestWorld.CHEST_BLOCK.getDefaultState(), ChestWorld.CHEST_BLOCK.getDefaultState())));
        ChestVillagePools.init();
        biomegenerationsettings$builder.withStructure(Structure.VILLAGE.withConfiguration(new VillageConfig(() -> {
            return ChestVillagePools.field_244090_a;
        }, 6)));

//        // DefaultBiomeFeatures.withStrongholdAndMineshaft(biomegenerationsettings$builder);
//        // biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL);
        biomegenerationsettings$builder.withCarver(GenerationStage.Carving.AIR, ChestWorld.CHEST_CAVE.func_242761_a(new ProbabilityConfig(0.14285715F)));
        biomegenerationsettings$builder.withCarver(GenerationStage.Carving.AIR, ChestWorld.CHEST_CANYON.func_242761_a(new ProbabilityConfig(0.02F)));
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, ChestWorld.CHEST_LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, ChestWorld.CHEST_LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.LAVA.getDefaultState())).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
//        // DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);

        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.withConfiguration(CHEST_TREE_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));

        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(new LiquidsConfig(Fluids.WATER.getDefaultState(), true, 4, 1, ImmutableSet.of(ChestWorld.CHEST_BLOCK))).withPlacement(Placement.RANGE_BIASED.configure(new TopSolidRangeConfig(8, 8, 256))).square().count(50));
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(new LiquidsConfig(Fluids.LAVA.getDefaultState(), true, 4, 1, ImmutableSet.of(ChestWorld.CHEST_BLOCK))).withPlacement(Placement.RANGE_VERY_BIASED.configure(new TopSolidRangeConfig(8, 16, 256))).square().count(20));
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }
}
