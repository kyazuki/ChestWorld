package com.github.kyazuki.chestworld;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class ChestWorldType extends WorldType {
  public ChestWorldType() {
    super("chestworld");
  }

  @Override
  public ChunkGenerator<?> createChunkGenerator(World world) {
    if (world.getDimension().getType() == DimensionType.OVERWORLD) {
      OverworldGenSettings overworldGenSettings = new OverworldGenSettings();
      SingleBiomeProviderSettings biomeProviderSettings = new SingleBiomeProviderSettings(world.getWorldInfo());
      biomeProviderSettings.setBiome(ChestWorld.CHEST_BIOME);
      overworldGenSettings.setDefaultBlock(ChestWorld.CHEST_BLOCK.getDefaultState());
      return new OverworldChunkGenerator(world, new SingleBiomeProvider(biomeProviderSettings), overworldGenSettings);
    } else
      return super.createChunkGenerator(world);
  }
}
