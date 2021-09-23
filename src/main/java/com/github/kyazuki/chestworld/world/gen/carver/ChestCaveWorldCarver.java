package com.github.kyazuki.chestworld.world.gen.carver;

import com.github.kyazuki.chestworld.ChestWorld;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;

public class ChestCaveWorldCarver extends CaveWorldCarver {

  public ChestCaveWorldCarver(Codec<CaveCarverConfiguration> codec) {
    super(codec);
    this.replaceableBlocks = ImmutableSet.of(ChestWorld.CHEST_BLOCK);
  }
}
