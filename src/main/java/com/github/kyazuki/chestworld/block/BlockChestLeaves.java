package com.github.kyazuki.chestworld.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class BlockChestLeaves extends BlockChest {
  public BlockChestLeaves(Properties properties) {
    super(properties);
  }

  @Override
  public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
    return false;
  }
}
