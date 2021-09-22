package com.github.kyazuki.chestworld.world.gen.carver;

import com.github.kyazuki.chestworld.ChestWorld;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ChestCanyonWorldCarver extends CanyonWorldCarver {

  public ChestCanyonWorldCarver(Codec<ProbabilityConfig> codec) {
    super(codec);
    this.replaceableBlocks = ImmutableSet.of(ChestWorld.CHEST_BLOCK);
  }
}
