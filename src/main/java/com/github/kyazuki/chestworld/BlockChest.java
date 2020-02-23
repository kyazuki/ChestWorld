package com.github.kyazuki.chestworld;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;

public class BlockChest extends Block implements IPlantable {

  public BlockChest(Block.Properties properties) {
    super(properties);
  }

  @Override
  public BlockState getPlant(IBlockReader world, BlockPos pos) {
    BlockState state = world.getBlockState(pos);
    if (state.getBlock() != this) return getDefaultState();
    return state;
  }

  @Override
  public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
    BlockState plant = plantable.getPlant(world, pos.offset(facing));
    return plant.getBlock() == this.getBlock();
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) {
    if (!worldIn.isRemote()) {
      if (worldIn.getBlockState(pos.up()).getBlock() == ChestWorld.CHEST_BLOCK)
        worldIn.setBlockState(pos.up(), ChestWorld.CHEST_BLOCK_LEAVES.getDefaultState(), 2);
      worldIn.setBlockState(pos, Blocks.CHEST.getDefaultState(), 2);
      TileEntity chestEntity = worldIn.getTileEntity(pos);
      float r = 0.0f, g = 0.0f, b = 0.0f;
      if (chestEntity instanceof ChestTileEntity) {
        Randomizer.Rarity rarity = Randomizer.setRandomLootTable((ChestTileEntity) chestEntity, ChestWorld.rand);
        if (rarity == Randomizer.Rarity.Common) {
          r = 0.6118f;
          g = 0.4431f;
          b = 0.3255f;
        } else if (rarity == Randomizer.Rarity.Uncommon) {
          r = 0.9176f;
          g = 0.9176f;
          b = 0.3020f;
        } else if (rarity == Randomizer.Rarity.Rare) {
          r = 0.3922f;
          g = 0.5059f;
          b = 0.2196f;
        } else if (rarity == Randomizer.Rarity.Very_Rare) {
          r = 0.7412f;
          g = 0.4863f;
          b = 0.8667f;
        } else if (rarity == Randomizer.Rarity.Ultra_Rare) {
          r = 0.9412f;
          g = 0.7098f;
          b = 0.8275f;
        } else if (rarity == Randomizer.Rarity.Legendary) {
          r = 1.0f;
          g = 1.0f;
          b = 1.0f;
        }
        if (rarity != Randomizer.Rarity.Miss) {
          ((ServerWorld) worldIn).spawnParticle(new RedstoneParticleData(r, g, b, 1.0f), (double) pos.getX() + 0.5d, (double) pos.getY() + 0.5d, (double) pos.getZ() + 0.5d, 100, 0.5, 0.5, 0.5, 1);
          worldIn.playSound(null, pos, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 1, 2);
        } else {
          Randomizer.happenSomething(worldIn, pos, ChestWorld.rand);
          worldIn.playSound(null, pos, SoundEvents.BLOCK_CONDUIT_DEACTIVATE, SoundCategory.BLOCKS, 1, 1);
        }
      }
      return ActionResultType.SUCCESS;
    }
    return ActionResultType.PASS;
  }
}

