package com.github.kyazuki.chestworld;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ChestCanyonWorldCarver extends CanyonWorldCarver {

  public ChestCanyonWorldCarver(Codec<ProbabilityConfig> p_i231916_1_) {
    super(p_i231916_1_);
    this.carvableBlocks = ImmutableSet.of(ChestWorld.CHEST_BLOCK);
  }
}
