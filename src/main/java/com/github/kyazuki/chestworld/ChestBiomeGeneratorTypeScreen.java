package com.github.kyazuki.chestworld;

import net.minecraft.client.gui.screen.BiomeGeneratorTypeScreens;
import net.minecraft.server.IDynamicRegistries;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChestBiomeGeneratorTypeScreen extends BiomeGeneratorTypeScreens {
  public ChestBiomeGeneratorTypeScreen() {
    super("chestworld");
  }

  @Override
  protected ChunkGenerator func_230484_a_(long seed) {
    return new NoiseChunkGenerator(new SingleBiomeProvider(ChestWorld.CHEST_BIOME), seed, DimensionSettings.Preset.OVERWORLD.getSettings());
  }

  @Override
  public DimensionGeneratorSettings func_241220_a_(IDynamicRegistries.Impl registries, long seed, boolean generateFeatures, boolean generateBonusChest) {
    return ChestWorld.createDimensionGeneratorSettings(seed, generateFeatures, generateBonusChest);
  }
}
