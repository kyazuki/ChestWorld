package com.github.kyazuki.chestworld;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = ChestWorld.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChestWorldConfig {
  public static final CommonConfig COMMON;
  public static final ForgeConfigSpec COMMON_SPEC;

  static {
    final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
    COMMON_SPEC = specPair.getRight();
    COMMON = specPair.getLeft();
  }

  public static int miss_weight;
  public static int common_weight;
  public static int uncommon_weight;
  public static int rare_weight;
  public static int very_rare_weight;
  public static int ultra_rare_weight;
  public static int legendary_weight;

  public static int spawn_mobs_weight;
  public static int explosion_weight;
  public static int spawner_weight;

  @SubscribeEvent
  public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
    if (configEvent.getConfig().getSpec() == ChestWorldConfig.COMMON_SPEC) {
      bakeConfig();
    }
  }

  public static void bakeConfig() {
    miss_weight = COMMON.miss_weight.get();
    common_weight = COMMON.common_weight.get();
    uncommon_weight = COMMON.uncommon_weight.get();
    rare_weight = COMMON.rare_weight.get();
    very_rare_weight = COMMON.very_rare_weight.get();
    ultra_rare_weight = COMMON.ultra_rare_weight.get();
    legendary_weight = COMMON.legendary_weight.get();
    explosion_weight = COMMON.explosion_weight.get();
    spawn_mobs_weight = COMMON.spawn_mobs_weight.get();
    spawner_weight = COMMON.spawner_weight.get();
  }

  public static class CommonConfig {

    public final ForgeConfigSpec.IntValue miss_weight;
    public final ForgeConfigSpec.IntValue common_weight;
    public final ForgeConfigSpec.IntValue uncommon_weight;
    public final ForgeConfigSpec.IntValue rare_weight;
    public final ForgeConfigSpec.IntValue very_rare_weight;
    public final ForgeConfigSpec.IntValue ultra_rare_weight;
    public final ForgeConfigSpec.IntValue legendary_weight;
    public final ForgeConfigSpec.IntValue spawn_mobs_weight;
    public final ForgeConfigSpec.IntValue explosion_weight;
    public final ForgeConfigSpec.IntValue spawner_weight;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
      builder.comment("ChestWorld Config");
      builder.push("Base Weight");
      miss_weight = builder
              .comment("A weight for miss.")
              .translation(ChestWorld.MODID + ".config." + "miss_weight")
              .defineInRange("miss_weight", 10, 0, 100000);
      common_weight = builder
              .comment("A weight for common.")
              .translation(ChestWorld.MODID + ".config." + "common_weight")
              .defineInRange("common_weight", 30, 0, 100000);
      uncommon_weight = builder
              .comment("A weight for uncommon.")
              .translation(ChestWorld.MODID + ".config" + "uncommon_weight")
              .defineInRange("uncommon_weight", 25, 0, 100000);
      rare_weight = builder
              .comment("A weight for rare.")
              .translation(ChestWorld.MODID + ".config" + "rare_weight")
              .defineInRange("rare_weight", 20, 0, 100000);
      very_rare_weight = builder
              .comment("A weight for very rare.")
              .translation(ChestWorld.MODID + ".config" + "very_rare_weight")
              .defineInRange("very_rare_weight", 10, 0, 100000);
      ultra_rare_weight = builder
              .comment("A weight for ultra rare.")
              .translation(ChestWorld.MODID + ".config" + "ultra_rare_weight")
              .defineInRange("ultra_rare_weight", 4, 0, 100000);
      legendary_weight = builder
              .comment("A weight for legendary.")
              .translation(ChestWorld.MODID + ".config" + "legendary_weight")
              .defineInRange("legendary_weight", 1, 0, 100000);
      builder.pop();
      builder.push("Miss Weight");
      spawn_mobs_weight = builder
              .comment("A weight for spawning mobs in miss.")
              .translation(ChestWorld.MODID + ".config" + "spawn_mobs_weight")
              .defineInRange("spawn_mobs_weight", 50, 0, 100000);
      explosion_weight = builder
              .comment("A weight for explosion in miss.")
              .translation(ChestWorld.MODID + ".config" + "explosion_weight")
              .defineInRange("explosion_weight", 30, 0, 100000);
      spawner_weight = builder
              .comment("A weight for spawner in miss.")
              .translation(ChestWorld.MODID + ".config" + "spawner_weight")
              .defineInRange("spawner_weight", 20, 0, 100000);
      builder.pop();
    }
  }
}
