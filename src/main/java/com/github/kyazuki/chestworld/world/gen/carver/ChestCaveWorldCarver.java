package com.github.kyazuki.chestworld.world.gen.carver;

import com.github.kyazuki.chestworld.ChestWorld;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ChestCaveWorldCarver extends CaveWorldCarver {

  public ChestCaveWorldCarver(Codec<ProbabilityConfig> codec, int p_i231917_2_) {
    super(codec, p_i231917_2_);
    this.carvableBlocks = ImmutableSet.of(ChestWorld.CHEST_BLOCK);
  }
}
