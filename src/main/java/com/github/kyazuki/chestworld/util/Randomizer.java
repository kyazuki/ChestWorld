package com.github.kyazuki.chestworld.util;

import com.github.kyazuki.chestworld.ChestWorld;
import com.github.kyazuki.chestworld.ChestWorldConfig;
import com.github.kyazuki.chestworld.loot.ModLootTables;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Random;

public class Randomizer {
  private static final List<EntityType> MONSTERS;
  private static final List<EntityType> SPAWNER_MONSTERS;

  public enum Rarity {
    MISS,
    COMMON,
    UNCOMMON,
    RARE,
    VERY_RARE,
    ULTRA_RARE,
    LEGENDARY
  }

  private static Rarity throwRarity(Random rand) {
    int missWeight = ChestWorldConfig.COMMON.missWeight.get();
    int commonWeight = ChestWorldConfig.COMMON.commonWeight.get();
    int uncommonWeight = ChestWorldConfig.COMMON.uncommonWeight.get();
    int rareWeight = ChestWorldConfig.COMMON.rareWeight.get();
    int veryRareWeight = ChestWorldConfig.COMMON.veryRareWeight.get();
    int ultraRareWeight = ChestWorldConfig.COMMON.ultraRareWeight.get();
    int legendaryWeight = ChestWorldConfig.COMMON.legendaryWeight.get();
    int rarity = rand.nextInt(missWeight + commonWeight + uncommonWeight + rareWeight + veryRareWeight + ultraRareWeight + legendaryWeight);
    if (rarity < legendaryWeight)
      return Rarity.LEGENDARY;
    else if (rarity < ultraRareWeight + legendaryWeight)
      return Rarity.ULTRA_RARE;
    else if (rarity < veryRareWeight + ultraRareWeight + legendaryWeight)
      return Rarity.VERY_RARE;
    else if (rarity < rareWeight + veryRareWeight + ultraRareWeight + legendaryWeight)
      return Rarity.RARE;
    else if (rarity < uncommonWeight + rareWeight + veryRareWeight + ultraRareWeight + legendaryWeight)
      return Rarity.UNCOMMON;
    else if (rarity < commonWeight + uncommonWeight + rareWeight + veryRareWeight + ultraRareWeight + legendaryWeight)
      return Rarity.COMMON;
    else
      return Rarity.MISS;
  }

  public static Rarity setRandomLootTable(ChestBlockEntity chestEntity, Random rand) {
    Rarity rare = throwRarity(rand);
    Pair<String, ResourceLocation> loot_table;
    if (rare == Rarity.COMMON) {
      loot_table = ModLootTables.COMMON_LOOT.get(rand.nextInt(ModLootTables.COMMON_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslatableComponent(loot_table.getKey()).append(" (").append(new TranslatableComponent("chestname.chestworld.rarity.common")).append(")"));
    } else if (rare == Rarity.UNCOMMON) {
      loot_table = ModLootTables.UNCOMMON_LOOT.get(rand.nextInt(ModLootTables.UNCOMMON_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslatableComponent(loot_table.getKey()).append(" (").append(new TranslatableComponent("chestname.chestworld.rarity.uncommon")).append(")"));
    } else if (rare == Rarity.RARE) {
      loot_table = ModLootTables.RARE_LOOT.get(rand.nextInt(ModLootTables.RARE_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslatableComponent(loot_table.getKey()).append(" (").append(new TranslatableComponent("chestname.chestworld.rarity.rare")).append(")"));
    } else if (rare == Rarity.VERY_RARE) {
      loot_table = ModLootTables.VERY_RARE_LOOT.get(rand.nextInt(ModLootTables.VERY_RARE_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslatableComponent(loot_table.getKey()).append(" (").append(new TranslatableComponent("chestname.chestworld.rarity.very_rare")).append(")"));
    } else if (rare == Rarity.ULTRA_RARE) {
      loot_table = ModLootTables.ULTRA_RARE_LOOT.get(rand.nextInt(ModLootTables.ULTRA_RARE_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslatableComponent(loot_table.getKey()).append(" (").append(new TranslatableComponent("chestname.chestworld.rarity.ultra_rare")).append(")"));
    } else if (rare == Rarity.LEGENDARY) {
      loot_table = ModLootTables.LEGENDARY_LOOT.get(rand.nextInt(ModLootTables.LEGENDARY_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslatableComponent(loot_table.getKey()).append(" (").append(new TranslatableComponent("chestname.chestworld.rarity.legendary")).append(")"));
    }
    return rare;
  }

  public static void happenSomething(ServerLevel level, BlockPos pos, Random rand) {
    int spawnMobsWeight = ChestWorldConfig.COMMON.spawnMobsWeight.get();
    int explosionWeight = ChestWorldConfig.COMMON.explosionWeight.get();
    int spawnerWeight = ChestWorldConfig.COMMON.spawnerWeight.get();
    int rand_num = rand.nextInt(spawnMobsWeight + explosionWeight + spawnerWeight);
    if (rand_num < spawnMobsWeight) {
      level.destroyBlock(pos, false);
      MONSTERS.get(rand.nextInt(MONSTERS.size())).spawn(level, null, null, null, pos, MobSpawnType.NATURAL, false, false);
    } else if (rand_num < explosionWeight + spawnMobsWeight) {
      level.destroyBlock(pos, false);
      level.explode(null, (double) pos.getX() + 0.5d, (double) pos.getY() + 0.5d, (double) pos.getZ() + 0.5d, 3.0f, Explosion.BlockInteraction.DESTROY);
    } else {
      level.setBlock(pos, Blocks.SPAWNER.defaultBlockState(), 2);
      BlockEntity blockEntity = level.getBlockEntity(pos);
      if (blockEntity instanceof SpawnerBlockEntity) {
        ((SpawnerBlockEntity) blockEntity).getSpawner().setEntityId(SPAWNER_MONSTERS.get(rand.nextInt(SPAWNER_MONSTERS.size())));
      }
    }
  }

  static {
    MONSTERS = ImmutableList.of(
            EntityType.BLAZE,
            EntityType.CAVE_SPIDER,
            EntityType.CREEPER,
            EntityType.DROWNED,
            EntityType.ELDER_GUARDIAN,
            EntityType.ENDERMAN,
            EntityType.ENDERMITE,
            EntityType.EVOKER,
            EntityType.GHAST,
            EntityType.GUARDIAN,
            EntityType.HOGLIN,
            EntityType.HUSK,
            EntityType.MAGMA_CUBE,
            EntityType.PHANTOM,
            EntityType.PIGLIN,
            EntityType.PILLAGER,
            EntityType.RAVAGER,
            EntityType.SHULKER,
            EntityType.SKELETON,
            EntityType.SLIME,
            EntityType.SPIDER,
            EntityType.STRAY,
            EntityType.VINDICATOR,
            EntityType.WITCH,
            EntityType.WITHER_SKELETON,
            EntityType.ZOGLIN,
            EntityType.ZOMBIE,
            EntityType.ZOMBIE_VILLAGER,
            EntityType.ZOMBIFIED_PIGLIN
    );
    SPAWNER_MONSTERS = ImmutableList.of(
            EntityType.BLAZE,
            EntityType.CAVE_SPIDER,
            EntityType.CREEPER,
            EntityType.DROWNED,
            EntityType.ENDERMAN,
            EntityType.GHAST,
            EntityType.GUARDIAN,
            EntityType.HUSK,
            EntityType.MAGMA_CUBE,
            EntityType.SKELETON,
            EntityType.SLIME,
            EntityType.SPIDER,
            EntityType.STRAY,
            EntityType.VINDICATOR,
            EntityType.PIGLIN,
            EntityType.PILLAGER,
            EntityType.WITCH,
            EntityType.WITHER_SKELETON,
            EntityType.ZOMBIE,
            EntityType.ZOMBIE_VILLAGER
    );
  }
}
