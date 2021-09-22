package com.github.kyazuki.chestworld.world;

import com.github.kyazuki.chestworld.ChestWorld;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.NoiseSettings;
import net.minecraft.world.gen.settings.ScalingSettings;
import net.minecraft.world.gen.settings.SlideSettings;
import net.minecraftforge.common.world.ForgeWorldType;

public class ChestWorldType extends ForgeWorldType {

    public ChestWorldType() {
        super((biomeRegistry, dimensionSettingsRegistry, seed) ->
            new NoiseChunkGenerator(new SingleBiomeProvider(biomeRegistry.get(ChestWorld.CHEST_BIOME.getRegistryName())), seed,
                () -> new DimensionSettings(new DimensionStructuresSettings(true), new NoiseSettings(256, new ScalingSettings(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D), new SlideSettings(-10, 3, 0), new SlideSettings(-30, 0, 0), 1, 2, 1.0D, -0.46875D, true, true, false, false), ChestWorld.CHEST_BLOCK.defaultBlockState(), Blocks.WATER.defaultBlockState(), -10, 0, 63, false)));
    }
}
