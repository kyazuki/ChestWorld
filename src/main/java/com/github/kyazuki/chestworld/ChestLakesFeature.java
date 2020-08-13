package com.github.kyazuki.chestworld;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.LakesFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class ChestLakesFeature extends LakesFeature {
  private static final BlockState AIR = Blocks.CAVE_AIR.getDefaultState();

  public ChestLakesFeature(Codec<BlockStateFeatureConfig> p_i231968_1_) {
    super(p_i231968_1_);
  }

  @Override
  public boolean func_230362_a_(ISeedReader p_230362_1_, StructureManager p_230362_2_, ChunkGenerator p_230362_3_, Random p_230362_4_, BlockPos p_230362_5_, BlockStateFeatureConfig p_230362_6_) {
    while (p_230362_5_.getY() > 5 && p_230362_1_.isAirBlock(p_230362_5_)) {
      p_230362_5_ = p_230362_5_.down();
    }

    if (p_230362_5_.getY() <= 4) {
      return false;
    } else {
      p_230362_5_ = p_230362_5_.down(4);
      if (p_230362_2_.func_235011_a_(SectionPos.from(p_230362_5_), Structure.field_236381_q_).findAny().isPresent()) {
        return false;
      } else {
        boolean[] aboolean = new boolean[2048];
        int i = p_230362_4_.nextInt(4) + 4;

        for (int j = 0; j < i; ++j) {
          double d0 = p_230362_4_.nextDouble() * 6.0D + 3.0D;
          double d1 = p_230362_4_.nextDouble() * 4.0D + 2.0D;
          double d2 = p_230362_4_.nextDouble() * 6.0D + 3.0D;
          double d3 = p_230362_4_.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
          double d4 = p_230362_4_.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
          double d5 = p_230362_4_.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

          for (int l = 1; l < 15; ++l) {
            for (int i1 = 1; i1 < 15; ++i1) {
              for (int j1 = 1; j1 < 7; ++j1) {
                double d6 = ((double) l - d3) / (d0 / 2.0D);
                double d7 = ((double) j1 - d4) / (d1 / 2.0D);
                double d8 = ((double) i1 - d5) / (d2 / 2.0D);
                double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                if (d9 < 1.0D) {
                  aboolean[(l * 16 + i1) * 8 + j1] = true;
                }
              }
            }
          }
        }

        for (int k1 = 0; k1 < 16; ++k1) {
          for (int l2 = 0; l2 < 16; ++l2) {
            for (int k = 0; k < 8; ++k) {
              boolean flag = !aboolean[(k1 * 16 + l2) * 8 + k] && (k1 < 15 && aboolean[((k1 + 1) * 16 + l2) * 8 + k] || k1 > 0 && aboolean[((k1 - 1) * 16 + l2) * 8 + k] || l2 < 15 && aboolean[(k1 * 16 + l2 + 1) * 8 + k] || l2 > 0 && aboolean[(k1 * 16 + (l2 - 1)) * 8 + k] || k < 7 && aboolean[(k1 * 16 + l2) * 8 + k + 1] || k > 0 && aboolean[(k1 * 16 + l2) * 8 + (k - 1)]);
              if (flag) {
                Material material = p_230362_1_.getBlockState(p_230362_5_.add(k1, k, l2)).getMaterial();
                if (k >= 4 && material.isLiquid()) {
                  return false;
                }

                if (k < 4 && !material.isSolid() && p_230362_1_.getBlockState(p_230362_5_.add(k1, k, l2)) != p_230362_6_.state) {
                  return false;
                }
              }
            }
          }
        }

        for (int l1 = 0; l1 < 16; ++l1) {
          for (int i3 = 0; i3 < 16; ++i3) {
            for (int i4 = 0; i4 < 8; ++i4) {
              if (aboolean[(l1 * 16 + i3) * 8 + i4]) {
                p_230362_1_.setBlockState(p_230362_5_.add(l1, i4, i3), i4 >= 4 ? AIR : p_230362_6_.state, 2);
              }
            }
          }
        }

        return true;
      }
    }
  }
}
