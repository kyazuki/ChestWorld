package com.github.kyazuki.chestworld.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class ChestLakeFeature extends LakeFeature {
  private static final BlockState AIR = Blocks.CAVE_AIR.defaultBlockState();

  public ChestLakeFeature(Codec<BlockStateConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<BlockStateConfiguration> p_159958_) {
    BlockPos blockpos = p_159958_.origin();
    WorldGenLevel worldgenlevel = p_159958_.level();
    Random random = p_159958_.random();

    BlockStateConfiguration blockstateconfiguration;
    for(blockstateconfiguration = p_159958_.config(); blockpos.getY() > worldgenlevel.getMinBuildHeight() + 5 && worldgenlevel.isEmptyBlock(blockpos); blockpos = blockpos.below()) {
    }

    if (blockpos.getY() <= worldgenlevel.getMinBuildHeight() + 4) {
      return false;
    } else {
      blockpos = blockpos.below(4);
      if (worldgenlevel.startsForFeature(SectionPos.of(blockpos), StructureFeature.VILLAGE).findAny().isPresent()) {
        return false;
      } else {
        boolean[] aboolean = new boolean[2048];
        int i = random.nextInt(4) + 4;

        for(int j = 0; j < i; ++j) {
          double d0 = random.nextDouble() * 6.0D + 3.0D;
          double d1 = random.nextDouble() * 4.0D + 2.0D;
          double d2 = random.nextDouble() * 6.0D + 3.0D;
          double d3 = random.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
          double d4 = random.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
          double d5 = random.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

          for(int l = 1; l < 15; ++l) {
            for(int i1 = 1; i1 < 15; ++i1) {
              for(int j1 = 1; j1 < 7; ++j1) {
                double d6 = ((double)l - d3) / (d0 / 2.0D);
                double d7 = ((double)j1 - d4) / (d1 / 2.0D);
                double d8 = ((double)i1 - d5) / (d2 / 2.0D);
                double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                if (d9 < 1.0D) {
                  aboolean[(l * 16 + i1) * 8 + j1] = true;
                }
              }
            }
          }
        }

        for(int k1 = 0; k1 < 16; ++k1) {
          for(int k2 = 0; k2 < 16; ++k2) {
            for(int k = 0; k < 8; ++k) {
              boolean flag = !aboolean[(k1 * 16 + k2) * 8 + k] && (k1 < 15 && aboolean[((k1 + 1) * 16 + k2) * 8 + k] || k1 > 0 && aboolean[((k1 - 1) * 16 + k2) * 8 + k] || k2 < 15 && aboolean[(k1 * 16 + k2 + 1) * 8 + k] || k2 > 0 && aboolean[(k1 * 16 + (k2 - 1)) * 8 + k] || k < 7 && aboolean[(k1 * 16 + k2) * 8 + k + 1] || k > 0 && aboolean[(k1 * 16 + k2) * 8 + (k - 1)]);
              if (flag) {
                Material material = worldgenlevel.getBlockState(blockpos.offset(k1, k, k2)).getMaterial();
                if (k >= 4 && material.isLiquid()) {
                  return false;
                }

                if (k < 4 && !material.isSolid() && worldgenlevel.getBlockState(blockpos.offset(k1, k, k2)) != blockstateconfiguration.state) {
                  return false;
                }
              }
            }
          }
        }

        for(int l1 = 0; l1 < 16; ++l1) {
          for(int l2 = 0; l2 < 16; ++l2) {
            for(int l3 = 0; l3 < 8; ++l3) {
              if (aboolean[(l1 * 16 + l2) * 8 + l3]) {
                BlockPos blockpos2 = blockpos.offset(l1, l3, l2);
                boolean flag1 = l3 >= 4;
                worldgenlevel.setBlock(blockpos2, flag1 ? AIR : blockstateconfiguration.state, 2);
                if (flag1) {
                  worldgenlevel.getBlockTicks().scheduleTick(blockpos2, AIR.getBlock(), 0);
                  this.markAboveForPostProcessing(worldgenlevel, blockpos2);
                }
              }
            }
          }
        }

        return true;
      }
    }
  }
}
