package com.github.kyazuki.chestworld;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.IPlantable;

public class ChestBiome extends Biome {
  private static final BlockState WATER = Blocks.WATER.getDefaultState();
  private static final BlockState LAVA = Blocks.LAVA.getDefaultState();
  public static final BlockState CHEST_BLOCK_STATE = ChestWorld.CHEST_BLOCK.getDefaultState();
  public static final BlockState CHEST_BLOCK_LEAVES_STATE = ChestWorld.CHEST_BLOCK_LEAVES.getDefaultState();
  public static final TreeFeatureConfig CHEST_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CHEST_BLOCK_STATE), new SimpleBlockStateProvider(CHEST_BLOCK_LEAVES_STATE), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((IPlantable) ChestWorld.CHEST_BLOCK).build();
  public static final BlockStateProvidingFeatureConfig HAY_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(ChestWorld.CHEST_BLOCK.getDefaultState()));

  public ChestBiome() {
    super((new Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(CHEST_BLOCK_STATE, CHEST_BLOCK_STATE, CHEST_BLOCK_STATE)).precipitation(RainType.RAIN).category(Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).waterColor(4159204).waterFogColor(329011).parent((String) null));

    ChestVillagePools.init();
    this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/chest/town_centers", 6)));

    this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(new ChestCaveWorldCarver(ProbabilityConfig::deserialize, 256), new ProbabilityConfig(0.14285715F)));
    this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(new ChestCanyonWorldCarver(ProbabilityConfig::deserialize), new ProbabilityConfig(0.02F)));
    this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, new ChestLakesFeature(BlockStateFeatureConfig::func_227271_a_).withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
    this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, new ChestLakesFeature(BlockStateFeatureConfig::func_227271_a_).withConfiguration(new BlockStateFeatureConfig(LAVA)).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(CHEST_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
    this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.VILLAGE.withConfiguration(new VillageConfig("village/plains/town_centers", 6)).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

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