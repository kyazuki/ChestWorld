package com.github.kyazuki.chestworld.loot;

import com.github.kyazuki.chestworld.ChestWorld;
import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class ModLootTables {
  public static final Pair<String, ResourceLocation> EMPTY;
  public static final Pair<String, ResourceLocation> SPAWN_BONUS_CHEST;
  public static final Pair<String, ResourceLocation> END_CITY_TREASURE;
  public static final Pair<String, ResourceLocation> SIMPLE_DUNGEON;
  public static final Pair<String, ResourceLocation> VILLAGE_WEAPONSMITH;
  public static final Pair<String, ResourceLocation> VILLAGE_TOOLSMITH;
  public static final Pair<String, ResourceLocation> VILLAGE_ARMORER;
  public static final Pair<String, ResourceLocation> VILLAGE_CARTOGRAPHER;
  public static final Pair<String, ResourceLocation> VILLAGE_MASON;
  public static final Pair<String, ResourceLocation> VILLAGE_SHEPHERD;
  public static final Pair<String, ResourceLocation> VILLAGE_BUTCHER;
  public static final Pair<String, ResourceLocation> VILLAGE_FLETCHER;
  public static final Pair<String, ResourceLocation> VILLAGE_FISHER;
  public static final Pair<String, ResourceLocation> VILLAGE_TANNERY;
  public static final Pair<String, ResourceLocation> VILLAGE_TEMPLE;
  public static final Pair<String, ResourceLocation> VILLAGE_DESERT_HOUSE;
  public static final Pair<String, ResourceLocation> VILLAGE_PLAINS_HOUSE;
  public static final Pair<String, ResourceLocation> VILLAGE_TAIGA_HOUSE;
  public static final Pair<String, ResourceLocation> VILLAGE_SNOWY_HOUSE;
  public static final Pair<String, ResourceLocation> VILLAGE_SAVANNA_HOUSE;
  public static final Pair<String, ResourceLocation> ABANDONED_MINESHAFT;
  public static final Pair<String, ResourceLocation> NETHER_BRIDGE;
  public static final Pair<String, ResourceLocation> STRONGHOLD_LIBRARY;
  public static final Pair<String, ResourceLocation> STRONGHOLD_CROSSING;
  public static final Pair<String, ResourceLocation> STRONGHOLD_CORRIDOR;
  public static final Pair<String, ResourceLocation> DESERT_PYRAMID;
  public static final Pair<String, ResourceLocation> JUNGLE_TEMPLE;
  public static final Pair<String, ResourceLocation> IGLOO_CHEST;
  public static final Pair<String, ResourceLocation> WOODLAND_MANSION;
  public static final Pair<String, ResourceLocation> UNDERWATER_RUIN_SMALL;
  public static final Pair<String, ResourceLocation> UNDERWATER_RUIN_BIG;
  public static final Pair<String, ResourceLocation> BURIED_TREASURE;
  public static final Pair<String, ResourceLocation> SHIPWRECK_MAP;
  public static final Pair<String, ResourceLocation> SHIPWRECK_SUPPLY;
  public static final Pair<String, ResourceLocation> SHIPWRECK_TREASURE;
  public static final Pair<String, ResourceLocation> PILLAGER_OUTPOST;
  public static final Pair<String, ResourceLocation> BASTION_TREASURE;
  public static final Pair<String, ResourceLocation> BASTION_OTHER;
  public static final Pair<String, ResourceLocation> BASTION_BRIDGE;
  public static final Pair<String, ResourceLocation> BASTION_HOGLIN_STABLE;
  public static final Pair<String, ResourceLocation> RUINED_PORTAL;
  public static final Pair<String, ResourceLocation> INGOT;
  public static final Pair<String, ResourceLocation> AMETHYST;
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
    EMPTY = Pair.of("chestname.chestworld.empty", BuiltInLootTables.EMPTY);
    SPAWN_BONUS_CHEST = Pair.of("chestname.chestworld.bonus", BuiltInLootTables.SPAWN_BONUS_CHEST);
    END_CITY_TREASURE = Pair.of("chestname.chestworld.endcity", BuiltInLootTables.END_CITY_TREASURE);
    SIMPLE_DUNGEON = Pair.of("chestname.chestworld.dungeon", BuiltInLootTables.SIMPLE_DUNGEON);
    VILLAGE_WEAPONSMITH = Pair.of("chestname.chestworld.village.weaponsmith", BuiltInLootTables.VILLAGE_WEAPONSMITH);
    VILLAGE_TOOLSMITH = Pair.of("chestname.chestworld.village.toolsmith", BuiltInLootTables.VILLAGE_TOOLSMITH);
    VILLAGE_ARMORER = Pair.of("chestname.chestworld.village.armorer", BuiltInLootTables.VILLAGE_ARMORER);
    VILLAGE_CARTOGRAPHER = Pair.of("chestname.chestworld.village.cartographer", BuiltInLootTables.VILLAGE_CARTOGRAPHER);
    VILLAGE_MASON = Pair.of("chestname.chestworld.village.mason", BuiltInLootTables.VILLAGE_MASON);
    VILLAGE_SHEPHERD = Pair.of("chestname.chestworld.village.shepherd", BuiltInLootTables.VILLAGE_SHEPHERD);
    VILLAGE_BUTCHER = Pair.of("chestname.chestworld.village.butcher", BuiltInLootTables.VILLAGE_BUTCHER);
    VILLAGE_FLETCHER = Pair.of("chestname.chestworld.village.fletcher", BuiltInLootTables.VILLAGE_FLETCHER);
    VILLAGE_FISHER = Pair.of("chestname.chestworld.village.fisher", BuiltInLootTables.VILLAGE_FISHER);
    VILLAGE_TANNERY = Pair.of("chestname.chestworld.village.tannery", BuiltInLootTables.VILLAGE_TANNERY);
    VILLAGE_TEMPLE = Pair.of("chestname.chestworld.village.temple", BuiltInLootTables.VILLAGE_TEMPLE);
    VILLAGE_DESERT_HOUSE = Pair.of("chestname.chestworld.village.desert", BuiltInLootTables.VILLAGE_DESERT_HOUSE);
    VILLAGE_PLAINS_HOUSE = Pair.of("chestname.chestworld.village.plains", BuiltInLootTables.VILLAGE_PLAINS_HOUSE);
    VILLAGE_TAIGA_HOUSE = Pair.of("chestname.chestworld.village.taiga", BuiltInLootTables.VILLAGE_TAIGA_HOUSE);
    VILLAGE_SNOWY_HOUSE = Pair.of("chestname.chestworld.village.snowy", BuiltInLootTables.VILLAGE_SNOWY_HOUSE);
    VILLAGE_SAVANNA_HOUSE = Pair.of("chestname.chestworld.village.savanna", BuiltInLootTables.VILLAGE_SAVANNA_HOUSE);
    ABANDONED_MINESHAFT = Pair.of("chestname.chestworld.mineshaft", BuiltInLootTables.ABANDONED_MINESHAFT);
    //NETHER_BRIDGE = Pair.of("chestname.chestworld.nether_fortress", BuiltInLootTables.NETHER_BRIDGE);
    STRONGHOLD_LIBRARY = Pair.of("chestname.chestworld.stronghold.library", BuiltInLootTables.STRONGHOLD_LIBRARY);
    STRONGHOLD_CROSSING = Pair.of("chestname.chestworld.stronghold.crossing", BuiltInLootTables.STRONGHOLD_CROSSING);
    STRONGHOLD_CORRIDOR = Pair.of("chestname.chestworld.stronghold.corridor", BuiltInLootTables.STRONGHOLD_CORRIDOR);
    DESERT_PYRAMID = Pair.of("chestname.chestworld.pyramid", BuiltInLootTables.DESERT_PYRAMID);
    JUNGLE_TEMPLE = Pair.of("chestname.chestworld.temple", BuiltInLootTables.JUNGLE_TEMPLE);
    IGLOO_CHEST = Pair.of("chestname.chestworld.igloo", BuiltInLootTables.IGLOO_CHEST);
    WOODLAND_MANSION = Pair.of("chestname.chestworld.mansion", BuiltInLootTables.WOODLAND_MANSION);
    UNDERWATER_RUIN_SMALL = Pair.of("chestname.chestworld.underwater.small", BuiltInLootTables.UNDERWATER_RUIN_SMALL);
    UNDERWATER_RUIN_BIG = Pair.of("chestname.chestworld.underwater.big", BuiltInLootTables.UNDERWATER_RUIN_BIG);
    BURIED_TREASURE = Pair.of("chestname.chestworld.buried", BuiltInLootTables.BURIED_TREASURE);
    SHIPWRECK_MAP = Pair.of("chestname.chestworld.shipwreck.map", BuiltInLootTables.SHIPWRECK_MAP);
    SHIPWRECK_SUPPLY = Pair.of("chestname.chestworld.shipwreck.supply", BuiltInLootTables.SHIPWRECK_SUPPLY);
    SHIPWRECK_TREASURE = Pair.of("chestname.chestworld.shipwreck.treasure", BuiltInLootTables.SHIPWRECK_TREASURE);
    PILLAGER_OUTPOST = Pair.of("chestname.chestworld.outpost", BuiltInLootTables.PILLAGER_OUTPOST);
    BASTION_TREASURE = Pair.of("chestname.chestworld.bastion.treasure", BuiltInLootTables.BASTION_TREASURE);
    BASTION_OTHER = Pair.of("chestname.chestworld.bastion.treasure", BuiltInLootTables.BASTION_OTHER);
    BASTION_BRIDGE = Pair.of("chestname.chestworld.bastion.treasure", BuiltInLootTables.BASTION_BRIDGE);
    BASTION_HOGLIN_STABLE = Pair.of("chestname.chestworld.bastion.treasure", BuiltInLootTables.BASTION_HOGLIN_STABLE);
    RUINED_PORTAL = Pair.of("chestname.chestworld.bastion.treasure", BuiltInLootTables.RUINED_PORTAL);

    NETHER_BRIDGE = Pair.of("chestname.chestworld.nether_fortress", new ResourceLocation(ChestWorld.MODID, "chests/nether_bridge"));

    INGOT = Pair.of("chestname.chestworld.ingot", new ResourceLocation(ChestWorld.MODID, "chests/ingot"));
    AMETHYST = Pair.of("chestname.chestworld.amethyst", new ResourceLocation(ChestWorld.MODID, "chests/amethyst"));
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
        SPAWN_BONUS_CHEST,
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
        VILLAGE_WEAPONSMITH,
        VILLAGE_TOOLSMITH,
        VILLAGE_ARMORER,
        VILLAGE_CARTOGRAPHER,
        VILLAGE_MASON,
        VILLAGE_SHEPHERD,
        VILLAGE_BUTCHER,
        VILLAGE_FLETCHER,
        VILLAGE_FISHER,
        VILLAGE_TANNERY,
        VILLAGE_TEMPLE,
        VILLAGE_DESERT_HOUSE,
        VILLAGE_PLAINS_HOUSE,
        VILLAGE_TAIGA_HOUSE,
        VILLAGE_SNOWY_HOUSE,
        VILLAGE_SAVANNA_HOUSE,
        PILLAGER_OUTPOST,
        CHEST,
        OCEAN_MONUMENT,
        ANIMAL_DROP
    );
    RARE_LOOT = ImmutableList.of(
        SIMPLE_DUNGEON,
        ABANDONED_MINESHAFT,
        STRONGHOLD_LIBRARY,
        STRONGHOLD_CROSSING,
        STRONGHOLD_CORRIDOR,
        IGLOO_CHEST,
        UNDERWATER_RUIN_SMALL,
        UNDERWATER_RUIN_BIG,
        SHIPWRECK_MAP,
        SHIPWRECK_SUPPLY,
        SHIPWRECK_TREASURE,
        INGOT,
        AMETHYST,
        ORE,
        MONSTER_DROP
    );
    VERY_RARE_LOOT = ImmutableList.of(
        EMPTY,
        NETHER_BRIDGE,
        DESERT_PYRAMID,
        JUNGLE_TEMPLE,
        WOODLAND_MANSION,
        BASTION_OTHER,
        BASTION_BRIDGE,
        BASTION_HOGLIN_STABLE,
        RUINED_PORTAL
    );
    ULTRA_RARE_LOOT = ImmutableList.of(
        END_CITY_TREASURE,
        BURIED_TREASURE,
        BASTION_TREASURE
    );
    LEGENDARY_LOOT = ImmutableList.of(
        DIAMOND_EQUIPMENTS,
        BEACON,
        WITHER,
        END_PORTAL
    );
  }
}