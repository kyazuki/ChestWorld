package com.github.kyazuki.chestworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Random;

public class Randomizer {
  private static final List<EntityType> MONSTERS;
  private static final List<EntityType> SPAWNER_MONSTERS;

  public enum Rarity {
    Miss,
    Common,
    Uncommon,
    Rare,
    Very_Rare,
    Ultra_Rare,
    Legendary
  }

  private static Rarity throwRarity(Random rand) {
    int rarity = rand.nextInt(ChestWorldConfig.miss_weight + ChestWorldConfig.common_weight + ChestWorldConfig.uncommon_weight + ChestWorldConfig.rare_weight + ChestWorldConfig.very_rare_weight + ChestWorldConfig.ultra_rare_weight + ChestWorldConfig.legendary_weight);
    if (rarity < ChestWorldConfig.legendary_weight)
      return Rarity.Legendary;
    else if (rarity < ChestWorldConfig.ultra_rare_weight + ChestWorldConfig.legendary_weight)
      return Rarity.Ultra_Rare;
    else if (rarity < ChestWorldConfig.very_rare_weight + ChestWorldConfig.ultra_rare_weight + ChestWorldConfig.legendary_weight)
      return Rarity.Very_Rare;
    else if (rarity < ChestWorldConfig.rare_weight + ChestWorldConfig.very_rare_weight + ChestWorldConfig.ultra_rare_weight + ChestWorldConfig.legendary_weight)
      return Rarity.Rare;
    else if (rarity < ChestWorldConfig.uncommon_weight + ChestWorldConfig.rare_weight + ChestWorldConfig.very_rare_weight + ChestWorldConfig.ultra_rare_weight + ChestWorldConfig.legendary_weight)
      return Rarity.Uncommon;
    else if (rarity < ChestWorldConfig.common_weight + ChestWorldConfig.uncommon_weight + ChestWorldConfig.rare_weight + ChestWorldConfig.very_rare_weight + ChestWorldConfig.ultra_rare_weight + ChestWorldConfig.legendary_weight)
      return Rarity.Common;
    else
      return Rarity.Miss;
  }

  public static Rarity setRandomLootTable(ChestTileEntity chestEntity, Random rand) {
    Rarity rare = throwRarity(rand);
    Pair<String, ResourceLocation> loot_table;
    if (rare == Rarity.Common) {
      loot_table = ModLootTables.COMMON_LOOT.get(rand.nextInt(ModLootTables.COMMON_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslationTextComponent(loot_table.getKey()).appendString(" (").append(new TranslationTextComponent("chestname.chestworld.rarity.common")).appendString(")"));
    } else if (rare == Rarity.Uncommon) {
      loot_table = ModLootTables.UNCOMMON_LOOT.get(rand.nextInt(ModLootTables.UNCOMMON_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslationTextComponent(loot_table.getKey()).appendString(" (").append(new TranslationTextComponent("chestname.chestworld.rarity.uncommon")).appendString(")"));
    } else if (rare == Rarity.Rare) {
      loot_table = ModLootTables.RARE_LOOT.get(rand.nextInt(ModLootTables.RARE_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslationTextComponent(loot_table.getKey()).appendString(" (").append(new TranslationTextComponent("chestname.chestworld.rarity.rare")).appendString(")"));
    } else if (rare == Rarity.Very_Rare) {
      loot_table = ModLootTables.VERY_RARE_LOOT.get(rand.nextInt(ModLootTables.VERY_RARE_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslationTextComponent(loot_table.getKey()).appendString(" (").append(new TranslationTextComponent("chestname.chestworld.rarity.very_rare")).appendString(")"));
    } else if (rare == Rarity.Ultra_Rare) {
      loot_table = ModLootTables.ULTRA_RARE_LOOT.get(rand.nextInt(ModLootTables.ULTRA_RARE_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslationTextComponent(loot_table.getKey()).appendString(" (").append(new TranslationTextComponent("chestname.chestworld.rarity.ultra_rare")).appendString(")"));
    } else if (rare == Rarity.Legendary) {
      loot_table = ModLootTables.LEGENDARY_LOOT.get(rand.nextInt(ModLootTables.LEGENDARY_LOOT.size()));
      chestEntity.setLootTable(loot_table.getValue(), ChestWorld.rand.nextLong());
      chestEntity.setCustomName(new TranslationTextComponent(loot_table.getKey()).appendString(" (").append(new TranslationTextComponent("chestname.chestworld.rarity.legendary")).appendString(")"));
    }
    return rare;
  }

  public static void happenSomething(World world, BlockPos pos, Random rand) {
    int rand_num = rand.nextInt(ChestWorldConfig.spawn_mobs_weight + ChestWorldConfig.explosion_weight + ChestWorldConfig.spawner_weight);
    if (rand_num < ChestWorldConfig.spawn_mobs_weight) {
      world.destroyBlock(pos, false);
      MONSTERS.get(rand.nextInt(MONSTERS.size())).spawn(world, null, null, null, pos, SpawnReason.NATURAL, false, false);
    } else if (rand_num < ChestWorldConfig.explosion_weight + ChestWorldConfig.spawn_mobs_weight) {
      world.destroyBlock(pos, false);
      world.createExplosion(null, (double) pos.getX() + 0.5d, (double) pos.getY() + 0.5d, (double) pos.getZ() + 0.5d, 3.0f, Explosion.Mode.DESTROY);
    } else {
      world.setBlockState(pos, Blocks.SPAWNER.getDefaultState(), 2);
      TileEntity tileentity = world.getTileEntity(pos);
      if (tileentity instanceof MobSpawnerTileEntity) {
        ((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic().setEntityType(SPAWNER_MONSTERS.get(rand.nextInt(SPAWNER_MONSTERS.size())));
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
