package com.github.kyazuki.chestworld.block;

import com.github.kyazuki.chestworld.ChestWorld;
import com.github.kyazuki.chestworld.util.Randomizer;
import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.IPlantable;

public class BlockChest extends Block implements IPlantable {
  public BlockChest(Block.Properties properties) {
    super(properties);
  }

  @Override
  public BlockState getPlant(BlockGetter world, BlockPos pos) {
    BlockState state = world.getBlockState(pos);
    if (state.getBlock() != this) return defaultBlockState();
    return state;
  }

  @Override
  public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
    BlockState plant = plantable.getPlant(world, pos.relative(facing));
    return plant.getBlock() == this.asBlock();
  }

  @Override
  public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
    if (!level.isClientSide()) {
      if (level.getBlockState(pos.above()).getBlock() == ChestWorld.CHEST_BLOCK)
        level.setBlock(pos.above(), ChestWorld.CHEST_BLOCK_LEAVES.defaultBlockState(), 2);
      level.setBlock(pos, Blocks.CHEST.defaultBlockState(), 2);
      BlockEntity chestEntity = level.getBlockEntity(pos);
      float r = 0.0f, g = 0.0f, b = 0.0f;
      if (chestEntity instanceof ChestBlockEntity) {
        Randomizer.Rarity rarity = Randomizer.setRandomLootTable((ChestBlockEntity) chestEntity, ChestWorld.rand);
        if (rarity == Randomizer.Rarity.COMMON) {
          r = 0.6118f;
          g = 0.4431f;
          b = 0.3255f;
        } else if (rarity == Randomizer.Rarity.UNCOMMON) {
          r = 0.9176f;
          g = 0.9176f;
          b = 0.3020f;
        } else if (rarity == Randomizer.Rarity.RARE) {
          r = 0.3922f;
          g = 0.5059f;
          b = 0.2196f;
        } else if (rarity == Randomizer.Rarity.VERY_RARE) {
          r = 0.7412f;
          g = 0.4863f;
          b = 0.8667f;
        } else if (rarity == Randomizer.Rarity.ULTRA_RARE) {
          r = 0.9412f;
          g = 0.7098f;
          b = 0.8275f;
        } else if (rarity == Randomizer.Rarity.LEGENDARY) {
          r = 1.0f;
          g = 1.0f;
          b = 1.0f;
        }
        if (rarity != Randomizer.Rarity.MISS) {
          ((ServerLevel) level).sendParticles(new DustParticleOptions(new Vector3f(r, g, b), 1.0f), (double) pos.getX() + 0.5d, (double) pos.getY() + 0.5d, (double) pos.getZ() + 0.5d, 100, 0.5, 0.5, 0.5, 1);
          level.playSound(null, pos, SoundEvents.ANVIL_LAND, SoundSource.BLOCKS, 1, 2);
        } else {
          Randomizer.happenSomething((ServerLevel) level, pos, ChestWorld.rand);
          level.playSound(null, pos, SoundEvents.CONDUIT_DEACTIVATE, SoundSource.BLOCKS, 1, 1);
        }
      }
      return InteractionResult.SUCCESS;
    }
    return InteractionResult.PASS;
  }
}

