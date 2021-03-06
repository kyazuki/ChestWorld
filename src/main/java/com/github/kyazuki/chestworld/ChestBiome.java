package com.github.kyazuki.chestworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ChestBiome extends Biome {
  private static final BlockState WATER = Blocks.WATER.getDefaultState();
  private static final BlockState LAVA = Blocks.LAVA.getDefaultState();
  public static final BlockState CHEST_BLOCK_STATE = ChestWorld.CHEST_BLOCK.getDefaultState();
  public static final BlockState CHEST_BLOCK_LEAVES_STATE = ChestWorld.CHEST_BLOCK_LEAVES.getDefaultState();
  public static final BaseTreeFeatureConfig CHEST_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHEST_BLOCK_STATE), new SimpleBlockStateProvider(CHEST_BLOCK_LEAVES_STATE), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
  public static final BlockStateProvidingFeatureConfig HAY_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(ChestWorld.CHEST_BLOCK.getDefaultState()));

  public ChestBiome() {
    super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(CHEST_BLOCK_STATE, CHEST_BLOCK_STATE, CHEST_BLOCK_STATE)).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).setMoodSound(MoodSoundAmbience.field_235027_b_).build()).parent((String) null).func_235098_a_(ImmutableList.of(new Biome.Attributes(0.0F, 0.0F, 0.0F, 0.0F, 1.0F))));

    ChestVillagePools.init();
    this.func_235063_a_(Structure.field_236381_q_.func_236391_a_(new VillageConfig(new ResourceLocation("village/chest/town_centers"), 6)));

    this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(new ChestCaveWorldCarver(ProbabilityConfig.field_236576_b_, 256), new ProbabilityConfig(0.14285715F)));
    this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(new ChestCanyonWorldCarver(ProbabilityConfig.field_236576_b_), new ProbabilityConfig(0.02F)));
    this.addFeature(GenerationStage.Decoration.LAKES, new ChestLakesFeature(BlockStateFeatureConfig.field_236455_a_).withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
    this.addFeature(GenerationStage.Decoration.LAKES, new ChestLakesFeature(BlockStateFeatureConfig.field_236455_a_).withConfiguration(new BlockStateFeatureConfig(LAVA)).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(CHEST_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));

    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 5, 2, 6));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.DONKEY, 1, 1, 3));
    this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
  }
}