package com.github.kyazuki.chestworld;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.Dynamic;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.function.Function;

public class ChestCaveWorldCarver extends CaveWorldCarver {

  public ChestCaveWorldCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> p_i49929_1_, int p_i49929_2_) {
    super(p_i49929_1_, p_i49929_2_);
    this.carvableBlocks = ImmutableSet.of(ChestWorld.CHEST_BLOCK);
  }
}
