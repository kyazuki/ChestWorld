package com.github.kyazuki.chestworld;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ChestCaveWorldCarver extends CaveWorldCarver {

  public ChestCaveWorldCarver(Codec<ProbabilityConfig> p_i231917_1_, int p_i231917_2_) {
    super(p_i231917_1_, p_i231917_2_);
    this.carvableBlocks = ImmutableSet.of(ChestWorld.CHEST_BLOCK);
  }
}
