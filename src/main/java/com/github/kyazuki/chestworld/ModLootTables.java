package com.github.kyazuki.chestworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTables;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class ModLootTables {
  public static final Pair<String, ResourceLocation> EMPTY;
  public static final Pair<String, ResourceLocation> CHESTS_SPAWN_BONUS_CHEST;
  public static final Pair<String, ResourceLocation> CHESTS_END_CITY_TREASURE;
  public static final Pair<String, ResourceLocation> CHESTS_SIMPLE_DUNGEON;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_WEAPONSMITH;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_TOOLSMITH;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_ARMORER;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_CARTOGRAPHER;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_MASON;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_SHEPHERD;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_BUTCHER;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_FLETCHER;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_FISHER;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_TANNERY;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_TEMPLE;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_DESERT_HOUSE;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_PLAINS_HOUSE;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_TAIGA_HOUSE;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE;
  public static final Pair<String, ResourceLocation> CHESTS_VILLAGE_VILLAGE_SAVANNA_HOUSE;
  public static final Pair<String, ResourceLocation> CHESTS_ABANDONED_MINESHAFT;
  public static final Pair<String, ResourceLocation> CHESTS_NETHER_BRIDGE;
  public static final Pair<String, ResourceLocation> CHESTS_STRONGHOLD_LIBRARY;
  public static final Pair<String, ResourceLocation> CHESTS_STRONGHOLD_CROSSING;
  public static final Pair<String, ResourceLocation> CHESTS_STRONGHOLD_CORRIDOR;
  public static final Pair<String, ResourceLocation> CHESTS_DESERT_PYRAMID;
  public static final Pair<String, ResourceLocation> CHESTS_JUNGLE_TEMPLE;
  public static final Pair<String, ResourceLocation> CHESTS_IGLOO_CHEST;
  public static final Pair<String, ResourceLocation> CHESTS_WOODLAND_MANSION;
  public static final Pair<String, ResourceLocation> CHESTS_UNDERWATER_RUIN_SMALL;
  public static final Pair<String, ResourceLocation> CHESTS_UNDERWATER_RUIN_BIG;
  public static final Pair<String, ResourceLocation> CHESTS_BURIED_TREASURE;
  public static final Pair<String, ResourceLocation> CHESTS_SHIPWRECK_MAP;
  public static final Pair<String, ResourceLocation> CHESTS_SHIPWRECK_SUPPLY;
  public static final Pair<String, ResourceLocation> CHESTS_SHIPWRECK_TREASURE;
  public static final Pair<String, ResourceLocation> CHESTS_PILLAGER_OUTPOST;
  public static final Pair<String, ResourceLocation> INGOT;
  public static final Pair<String, ResourceLocation> DIAMOND_EQUIPMENTS;
  public static final Pair<String, ResourceLocation> SAND;
  public static final Pair<String, ResourceLocation> CHEST;
  public static final Pair<String, ResourceLocation> BEACON;
  public static final Pair<String, ResourceLocation> STONE;
  public static final Pair<String, ResourceLocation> PLAINS;
  public static final Pair<String, ResourceLocation> DESERT;
  public static final Pair<String, ResourceLocation> SWAMP;
  public static final Pair<String, ResourceLocation> TAIGA;
  public static final Pair<String, ResourceLocation> SAVANNA;
  public static final Pair<String, ResourceLocation> JUNGLE;
  public static final Pair<String, ResourceLocation> BADLANDS;
  public static final Pair<String, ResourceLocation> NETHER;
  public static final Pair<String, ResourceLocation> THE_END;
  public static final Pair<String, ResourceLocation> FLOWER;
  public static final Pair<String, ResourceLocation> ORE;
  public static final Pair<String, ResourceLocation> WOOL;
  public static final Pair<String, ResourceLocation> DIRT;
  public static final Pair<String, ResourceLocation> OCEAN_MONUMENT;
  public static final Pair<String, ResourceLocation> WITHER;
  public static final Pair<String, ResourceLocation> END_PORTAL;
  public static final Pair<String, ResourceLocation> MONSTER_DROP;
  public static final Pair<String, ResourceLocation> ANIMAL_DROP;
  public static final List<Pair<String, ResourceLocation>> COMMON_LOOT;
  public static final List<Pair<String, ResourceLocation>> UNCOMMON_LOOT;
  public static final List<Pair<String, ResourceLocation>> RARE_LOOT;
  public static final List<Pair<String, ResourceLocation>> VERY_RARE_LOOT;
  public static final List<Pair<String, ResourceLocation>> ULTRA_RARE_LOOT;
  public static final List<Pair<String, ResourceLocation>> LEGENDARY_LOOT;

  static {
    EMPTY = Pair.of("chestname.chestworld.empty", LootTables.EMPTY);
    CHESTS_SPAWN_BONUS_CHEST = Pair.of("chestname.chestworld.bonus", LootTables.CHESTS_SPAWN_BONUS_CHEST);
    CHESTS_END_CITY_TREASURE = Pair.of("chestname.chestworld.endcity", LootTables.CHESTS_END_CITY_TREASURE);
    CHESTS_SIMPLE_DUNGEON = Pair.of("chestname.chestworld.dungeon", LootTables.CHESTS_SIMPLE_DUNGEON);
    CHESTS_VILLAGE_VILLAGE_WEAPONSMITH = Pair.of("chestname.chestworld.village.weaponsmith", LootTables.CHESTS_VILLAGE_VILLAGE_WEAPONSMITH);
    CHESTS_VILLAGE_VILLAGE_TOOLSMITH = Pair.of("chestname.chestworld.village.toolsmith", LootTables.CHESTS_VILLAGE_VILLAGE_TOOLSMITH);
    CHESTS_VILLAGE_VILLAGE_ARMORER = Pair.of("chestname.chestworld.village.armorer", LootTables.CHESTS_VILLAGE_VILLAGE_ARMORER);
    CHESTS_VILLAGE_VILLAGE_CARTOGRAPHER = Pair.of("chestname.chestworld.village.cartographer", LootTables.CHESTS_VILLAGE_VILLAGE_CARTOGRAPHER);
    CHESTS_VILLAGE_VILLAGE_MASON = Pair.of("chestname.chestworld.village.mason", LootTables.CHESTS_VILLAGE_VILLAGE_MASON);
    CHESTS_VILLAGE_VILLAGE_SHEPHERD = Pair.of("chestname.chestworld.village.shepherd", LootTables.CHESTS_VILLAGE_VILLAGE_SHEPHERD);
    CHESTS_VILLAGE_VILLAGE_BUTCHER = Pair.of("chestname.chestworld.village.butcher", LootTables.CHESTS_VILLAGE_VILLAGE_BUTCHER);
    CHESTS_VILLAGE_VILLAGE_FLETCHER = Pair.of("chestname.chestworld.village.fletcher", LootTables.CHESTS_VILLAGE_VILLAGE_FLETCHER);
    CHESTS_VILLAGE_VILLAGE_FISHER = Pair.of("chestname.chestworld.village.fisher", LootTables.CHESTS_VILLAGE_VILLAGE_FISHER);
    CHESTS_VILLAGE_VILLAGE_TANNERY = Pair.of("chestname.chestworld.village.tannery", LootTables.CHESTS_VILLAGE_VILLAGE_TANNERY);
    CHESTS_VILLAGE_VILLAGE_TEMPLE = Pair.of("chestname.chestworld.village.temple", LootTables.CHESTS_VILLAGE_VILLAGE_TEMPLE);
    CHESTS_VILLAGE_VILLAGE_DESERT_HOUSE = Pair.of("chestname.chestworld.village.desert", LootTables.CHESTS_VILLAGE_VILLAGE_DESERT_HOUSE);
    CHESTS_VILLAGE_VILLAGE_PLAINS_HOUSE = Pair.of("chestname.chestworld.village.plains", LootTables.CHESTS_VILLAGE_VILLAGE_PLAINS_HOUSE);
    CHESTS_VILLAGE_VILLAGE_TAIGA_HOUSE = Pair.of("chestname.chestworld.village.taiga", LootTables.CHESTS_VILLAGE_VILLAGE_TAIGA_HOUSE);
    CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE = Pair.of("chestname.chestworld.village.snowy", LootTables.CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE);
    CHESTS_VILLAGE_VILLAGE_SAVANNA_HOUSE = Pair.of("chestname.chestworld.village.savanna", LootTables.CHESTS_VILLAGE_VILLAGE_SAVANNA_HOUSE);
    CHESTS_ABANDONED_MINESHAFT = Pair.of("chestname.chestworld.mineshaft", LootTables.CHESTS_ABANDONED_MINESHAFT);
    //CHESTS_NETHER_BRIDGE = Pair.of("chestname.chestworld.nether_fortress", LootTables.CHESTS_NETHER_BRIDGE);
    CHESTS_STRONGHOLD_LIBRARY = Pair.of("chestname.chestworld.stronghold.library", LootTables.CHESTS_STRONGHOLD_LIBRARY);
    CHESTS_STRONGHOLD_CROSSING = Pair.of("chestname.chestworld.stronghold.crossing", LootTables.CHESTS_STRONGHOLD_CROSSING);
    CHESTS_STRONGHOLD_CORRIDOR = Pair.of("chestname.chestworld.stronghold.corridor", LootTables.CHESTS_STRONGHOLD_CORRIDOR);
    CHESTS_DESERT_PYRAMID = Pair.of("chestname.chestworld.pyramid", LootTables.CHESTS_DESERT_PYRAMID);
    CHESTS_JUNGLE_TEMPLE = Pair.of("chestname.chestworld.temple", LootTables.CHESTS_JUNGLE_TEMPLE);
    CHESTS_IGLOO_CHEST = Pair.of("chestname.chestworld.igloo", LootTables.CHESTS_IGLOO_CHEST);
    CHESTS_WOODLAND_MANSION = Pair.of("chestname.chestworld.mansion", LootTables.CHESTS_WOODLAND_MANSION);
    CHESTS_UNDERWATER_RUIN_SMALL = Pair.of("chestname.chestworld.underwater.small", LootTables.CHESTS_UNDERWATER_RUIN_SMALL);
    CHESTS_UNDERWATER_RUIN_BIG = Pair.of("chestname.chestworld.underwater.big", LootTables.CHESTS_UNDERWATER_RUIN_BIG);
    CHESTS_BURIED_TREASURE = Pair.of("chestname.chestworld.buried", LootTables.CHESTS_BURIED_TREASURE);
    CHESTS_SHIPWRECK_MAP = Pair.of("chestname.chestworld.shipwreck.map", LootTables.CHESTS_SHIPWRECK_MAP);
    CHESTS_SHIPWRECK_SUPPLY = Pair.of("chestname.chestworld.shipwreck.supply", LootTables.CHESTS_SHIPWRECK_SUPPLY);
    CHESTS_SHIPWRECK_TREASURE = Pair.of("chestname.chestworld.shipwreck.treasure", LootTables.CHESTS_SHIPWRECK_TREASURE);
    CHESTS_PILLAGER_OUTPOST = Pair.of("chestname.chestworld.outpost", LootTables.CHESTS_PILLAGER_OUTPOST);

    CHESTS_NETHER_BRIDGE = Pair.of("chestname.chestworld.nether_fortress", new ResourceLocation(ChestWorld.MODID, "chests/nether_bridge"));

    INGOT = Pair.of("chestname.chestworld.ingot", new ResourceLocation(ChestWorld.MODID, "chests/ingot"));
    DIAMOND_EQUIPMENTS = Pair.of("chestname.chestworld.diamond_equipments", new ResourceLocation(ChestWorld.MODID, "chests/diamond_equipments"));
    SAND = Pair.of("chestname.chestworld.sand", new ResourceLocation(ChestWorld.MODID, "chests/sand"));
    CHEST = Pair.of("chestname.chestworld.chest", new ResourceLocation(ChestWorld.MODID, "chests/chest"));
    BEACON = Pair.of("chestname.chestworld.beacon", new ResourceLocation(ChestWorld.MODID, "chests/beacon"));
    STONE = Pair.of("chestname.chestworld.stone", new ResourceLocation(ChestWorld.MODID, "chests/stone"));
    PLAINS = Pair.of("chestname.chestworld.plains", new ResourceLocation(ChestWorld.MODID, "chests/plains"));
    DESERT = Pair.of("chestname.chestworld.desert", new ResourceLocation(ChestWorld.MODID, "chests/desert"));
    SWAMP = Pair.of("chestname.chestworld.swamp", new ResourceLocation(ChestWorld.MODID, "chests/swamp"));
    TAIGA = Pair.of("chestname.chestworld.taiga", new ResourceLocation(ChestWorld.MODID, "chests/taiga"));
    SAVANNA = Pair.of("chestname.chestworld.savanna", new ResourceLocation(ChestWorld.MODID, "chests/savanna"));
    JUNGLE = Pair.of("chestname.chestworld.jungle", new ResourceLocation(ChestWorld.MODID, "chests/jungle"));
    BADLANDS = Pair.of("chestname.chestworld.badlands", new ResourceLocation(ChestWorld.MODID, "chests/badlands"));
    NETHER = Pair.of("chestname.chestworld.nether", new ResourceLocation(ChestWorld.MODID, "chests/nether"));
    THE_END = Pair.of("chestname.chestworld.the_end", new ResourceLocation(ChestWorld.MODID, "chests/the_end"));
    FLOWER = Pair.of("chestname.chestworld.flower", new ResourceLocation(ChestWorld.MODID, "chests/flower"));
    ORE = Pair.of("chestname.chestworld.ore", new ResourceLocation(ChestWorld.MODID, "chests/ore"));
    WOOL = Pair.of("chestname.chestworld.wool", new ResourceLocation(ChestWorld.MODID, "chests/wool"));
    DIRT = Pair.of("chestname.chestworld.dirt", new ResourceLocation(ChestWorld.MODID, "chests/dirt"));
    OCEAN_MONUMENT = Pair.of("chestname.chestworld.ocean_monument", new ResourceLocation(ChestWorld.MODID, "chests/ocean_monument"));
    WITHER = Pair.of("chestname.chestworld.wither", new ResourceLocation(ChestWorld.MODID, "chests/wither"));
    END_PORTAL = Pair.of("chestname.chestworld.end_portal", new ResourceLocation(ChestWorld.MODID, "chests/end_portal"));
    MONSTER_DROP = Pair.of("chestname.chestworld.monster_drop", new ResourceLocation(ChestWorld.MODID, "chests/monster_drop"));
    ANIMAL_DROP = Pair.of("chestname.chestworld.animal_drop", new ResourceLocation(ChestWorld.MODID, "chests/animal_drop"));

    COMMON_LOOT = ImmutableList.of(
            CHESTS_SPAWN_BONUS_CHEST,
            SAND,
            STONE,
            PLAINS,
            DESERT,
            SWAMP,
            TAIGA,
            SAVANNA,
            JUNGLE,
            BADLANDS,
            NETHER,
            THE_END,
            FLOWER,
            WOOL,
            DIRT
    );
    UNCOMMON_LOOT = ImmutableList.of(
            CHESTS_VILLAGE_VILLAGE_WEAPONSMITH,
            CHESTS_VILLAGE_VILLAGE_TOOLSMITH,
            CHESTS_VILLAGE_VILLAGE_ARMORER,
            CHESTS_VILLAGE_VILLAGE_CARTOGRAPHER,
            CHESTS_VILLAGE_VILLAGE_MASON,
            CHESTS_VILLAGE_VILLAGE_SHEPHERD,
            CHESTS_VILLAGE_VILLAGE_BUTCHER,
            CHESTS_VILLAGE_VILLAGE_FLETCHER,
            CHESTS_VILLAGE_VILLAGE_FISHER,
            CHESTS_VILLAGE_VILLAGE_TANNERY,
            CHESTS_VILLAGE_VILLAGE_TEMPLE,
            CHESTS_VILLAGE_VILLAGE_DESERT_HOUSE,
            CHESTS_VILLAGE_VILLAGE_PLAINS_HOUSE,
            CHESTS_VILLAGE_VILLAGE_TAIGA_HOUSE,
            CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE,
            CHESTS_VILLAGE_VILLAGE_SAVANNA_HOUSE,
            CHESTS_PILLAGER_OUTPOST,
            CHEST,
            OCEAN_MONUMENT,
            ANIMAL_DROP
    );
    RARE_LOOT = ImmutableList.of(
            CHESTS_SIMPLE_DUNGEON,
            CHESTS_ABANDONED_MINESHAFT,
            CHESTS_STRONGHOLD_LIBRARY,
            CHESTS_STRONGHOLD_CROSSING,
            CHESTS_STRONGHOLD_CORRIDOR,
            CHESTS_IGLOO_CHEST,
            CHESTS_UNDERWATER_RUIN_SMALL,
            CHESTS_UNDERWATER_RUIN_BIG,
            CHESTS_SHIPWRECK_MAP,
            CHESTS_SHIPWRECK_SUPPLY,
            CHESTS_SHIPWRECK_TREASURE,
            INGOT,
            ORE,
            MONSTER_DROP
    );
    VERY_RARE_LOOT = ImmutableList.of(
            EMPTY,
            CHESTS_NETHER_BRIDGE,
            CHESTS_DESERT_PYRAMID,
            CHESTS_JUNGLE_TEMPLE,
            CHESTS_WOODLAND_MANSION
    );
    ULTRA_RARE_LOOT = ImmutableList.of(
            CHESTS_END_CITY_TREASURE,
            CHESTS_BURIED_TREASURE
    );
    LEGENDARY_LOOT = ImmutableList.of(
            DIAMOND_EQUIPMENTS,
            BEACON,
            WITHER,
            END_PORTAL
    );
  }
}