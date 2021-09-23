package com.github.kyazuki.chestworld.world.biome;

import com.github.kyazuki.chestworld.ChestWorld;
import com.github.kyazuki.chestworld.world.gen.feature.structure.ChestVillagePools;
import com.google.common.collect.ImmutableSet;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.heightproviders.VeryBiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.ChanceDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.material.Fluids;

public class ChestWorldBiomes {
    public static final TreeConfiguration CHEST_TREE = (new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(ChestWorld.CHEST_BLOCK.defaultBlockState()), new StraightTrunkPlacer(5, 2, 0), new SimpleStateProvider(ChestWorld.CHEST_BLOCK_LEAVES.defaultBlockState()), new SimpleStateProvider(ChestWorld.CHEST_BLOCK.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).dirt(new SimpleStateProvider(ChestWorld.CHEST_BLOCK.defaultBlockState()))).ignoreVines().build();
    public static final BlockPileConfiguration PILE_HAY = new BlockPileConfiguration(new SimpleStateProvider(ChestWorld.CHEST_BLOCK.defaultBlockState()));

    private static int calculateSkyColor(float p_127333_) {
        float f = p_127333_ / 3.0F;
        f = Mth.clamp(f, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static Biome chestBiome() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(mobspawnsettings$builder);
        mobspawnsettings$builder.setPlayerCanSpawn();

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(ChestWorld.CHEST_BLOCK.defaultBlockState(), ChestWorld.CHEST_BLOCK.defaultBlockState(), ChestWorld.CHEST_BLOCK.defaultBlockState())));
        ChestVillagePools.init();
        biomegenerationsettings$builder.addStructureStart(StructureFeature.VILLAGE.configured(new JigsawConfiguration(() -> {
            return ChestVillagePools.START;
        }, 6)));

        // BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
        // biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        biomegenerationsettings$builder.addCarver(GenerationStep.Carving.AIR, ChestWorld.CHEST_CAVE.configured(new CaveCarverConfiguration(0.14285715F, BiasedToBottomHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(127), 8), ConstantFloat.of(0.5F), VerticalAnchor.aboveBottom(10), false, CarverDebugSettings.of(false, Blocks.CRIMSON_BUTTON.defaultBlockState()), ConstantFloat.of(1.0F), ConstantFloat.of(1.0F), ConstantFloat.of(-0.7F))));
        biomegenerationsettings$builder.addCarver(GenerationStep.Carving.AIR, ChestWorld.CHEST_CANYON.configured(new CanyonCarverConfiguration(0.02F, BiasedToBottomHeight.of(VerticalAnchor.absolute(20), VerticalAnchor.absolute(67), 8), ConstantFloat.of(3.0F), VerticalAnchor.aboveBottom(10), false, CarverDebugSettings.of(false, Blocks.WARPED_BUTTON.defaultBlockState()), UniformFloat.of(-0.125F, 0.125F), new CanyonCarverConfiguration.CanyonShapeConfiguration(UniformFloat.of(0.75F, 1.0F), TrapezoidFloat.of(0.0F, 6.0F, 2.0F), 3, UniformFloat.of(0.75F, 1.0F), 1.0F, 0.0F))));
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.LAKES, ChestWorld.CHEST_LAKE.configured(new BlockStateConfiguration(Blocks.WATER.defaultBlockState())).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().rarity(4));
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.LAKES, ChestWorld.CHEST_LAKE.configured(new BlockStateConfiguration(Blocks.LAVA.defaultBlockState())).decorated(FeatureDecorator.LAVA_LAKE.configured(new ChanceDecoratorConfiguration(80))).range(new RangeDecoratorConfiguration(BiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top(), 8))).squared().rarity(8));
        // DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);

        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Feature.TREE.configured(CHEST_TREE).decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(0, 0.05F, 1))));

        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Feature.SPRING.configured(new SpringConfiguration(Fluids.WATER.defaultFluidState(), true, 4, 1, ImmutableSet.of(ChestWorld.CHEST_BLOCK))).range(new RangeDecoratorConfiguration(BiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8))).squared().count(50));
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Feature.SPRING.configured(new SpringConfiguration(Fluids.LAVA.defaultFluidState(), true, 4, 1, ImmutableSet.of(ChestWorld.CHEST_BLOCK))).range(new RangeDecoratorConfiguration(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8))).squared().count(20));
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(calculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }
}
