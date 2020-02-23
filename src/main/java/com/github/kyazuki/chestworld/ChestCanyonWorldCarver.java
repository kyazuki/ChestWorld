package com.github.kyazuki.chestworld;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.Dynamic;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.function.Function;

public class ChestCanyonWorldCarver extends CanyonWorldCarver {

  public ChestCanyonWorldCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> p_i49930_1_) {
    super(p_i49930_1_);
    this.carvableBlocks = ImmutableSet.of(ChestWorld.CHEST_BLOCK);
  }
}
