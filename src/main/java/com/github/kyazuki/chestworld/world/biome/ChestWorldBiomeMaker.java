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
    public static final BaseTreeFeatureConfig CHEST_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ChestWorld.CHEST_BLOCK.defaultBlockState()), new SimpleBlockStateProvider(ChestWorld.CHEST_BLOCK_LEAVES.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build();
    public static final BlockStateProvidingFeatureConfig HAY_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(ChestWorld.CHEST_BLOCK.defaultBlockState()));

    private static int calculateSkyColor(float p_244206_0_) {
        float lvt_1_1_ = p_244206_0_ / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome chestBiome() {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.plainsSpawns(mobspawninfo$builder);
        mobspawninfo$builder.setPlayerCanSpawn();

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(ChestWorld.CHEST_BLOCK.defaultBlockState(), ChestWorld.CHEST_BLOCK.defaultBlockState(), ChestWorld.CHEST_BLOCK.defaultBlockState())));
        ChestVillagePools.init();
        biomegenerationsettings$builder.addStructureStart(Structure.VILLAGE.configured(new VillageConfig(() -> {
            return ChestVillagePools.START;
        }, 6)));

        // DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
        // biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        biomegenerationsettings$builder.addCarver(GenerationStage.Carving.AIR, ChestWorld.CHEST_CAVE.configured(new ProbabilityConfig(0.14285715F)));
        biomegenerationsettings$builder.addCarver(GenerationStage.Carving.AIR, ChestWorld.CHEST_CANYON.configured(new ProbabilityConfig(0.02F)));
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.LAKES, ChestWorld.CHEST_LAKE.configured(new BlockStateFeatureConfig(Blocks.WATER.defaultBlockState())).decorated(Placement.WATER_LAKE.configured(new ChanceConfig(4))));
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.LAKES, ChestWorld.CHEST_LAKE.configured(new BlockStateFeatureConfig(Blocks.LAVA.defaultBlockState())).decorated(Placement.LAVA_LAKE.configured(new ChanceConfig(80))));
        // DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);

        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.configured(CHEST_TREE_CONFIG).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));

        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING.configured(new LiquidsConfig(Fluids.WATER.defaultFluidState(), true, 4, 1, ImmutableSet.of(ChestWorld.CHEST_BLOCK))).decorated(Placement.RANGE_BIASED.configured(new TopSolidRangeConfig(8, 8, 256))).squared().count(50));
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING.configured(new LiquidsConfig(Fluids.LAVA.defaultFluidState(), true, 4, 1, ImmutableSet.of(ChestWorld.CHEST_BLOCK))).decorated(Placement.RANGE_VERY_BIASED.configured(new TopSolidRangeConfig(8, 16, 256))).squared().count(20));
        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.8F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }
}
