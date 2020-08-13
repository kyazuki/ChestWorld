package com.github.kyazuki.chestworld;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;

public class BlockChestLeaves extends BlockChest {
  public BlockChestLeaves(Properties properties) {
    super(properties);
  }

  @Override
  public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
    return false;
  }
}
