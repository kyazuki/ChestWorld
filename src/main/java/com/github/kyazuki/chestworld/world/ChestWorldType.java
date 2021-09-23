package com.github.kyazuki.chestworld.world;

import com.github.kyazuki.chestworld.ChestWorld;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraftforge.common.world.ForgeWorldType;

public class ChestWorldType extends ForgeWorldType {

    public ChestWorldType() {
        super((biomeRegistry, dimensionSettingsRegistry, seed) ->
            new NoiseBasedChunkGenerator(new FixedBiomeSource(biomeRegistry.get(ChestWorld.CHEST_BIOME.getRegistryName())), seed,
                () -> new NoiseGeneratorSettings(new StructureSettings(true), NoiseSettings.create(0, 256, new NoiseSamplingSettings(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D), new NoiseSlideSettings(-10, 3, 0), new NoiseSlideSettings(15, 3, 0), 1, 2, 1.0D, -0.46875D, true, true, false, false), ChestWorld.CHEST_BLOCK.defaultBlockState(), Blocks.WATER.defaultBlockState(), Integer.MIN_VALUE, 0, 63, 0, false, false, false, false, false, false)));
    }
}
