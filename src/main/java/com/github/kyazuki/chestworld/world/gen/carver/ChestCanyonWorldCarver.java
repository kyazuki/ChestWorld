package com.github.kyazuki.chestworld.world.gen.carver;

import com.github.kyazuki.chestworld.ChestWorld;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CanyonWorldCarver;

public class ChestCanyonWorldCarver extends CanyonWorldCarver {

  public ChestCanyonWorldCarver(Codec<CanyonCarverConfiguration> codec) {
    super(codec);
    this.replaceableBlocks = ImmutableSet.of(ChestWorld.CHEST_BLOCK);
  }
}
