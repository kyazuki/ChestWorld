package com.github.kyazuki.chestworld;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
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

  public static class CommonConfig {

    public final ForgeConfigSpec.IntValue missWeight;
    public final ForgeConfigSpec.IntValue commonWeight;
    public final ForgeConfigSpec.IntValue uncommonWeight;
    public final ForgeConfigSpec.IntValue rareWeight;
    public final ForgeConfigSpec.IntValue veryRareWeight;
    public final ForgeConfigSpec.IntValue ultraRareWeight;
    public final ForgeConfigSpec.IntValue legendaryWeight;
    public final ForgeConfigSpec.IntValue spawnMobsWeight;
    public final ForgeConfigSpec.IntValue explosionWeight;
    public final ForgeConfigSpec.IntValue spawnerWeight;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
      builder.comment("ChestWorld Config");
      builder.push("Base Weight");
      missWeight = builder
              .comment("A weight for miss.")
              .translation(ChestWorld.MODID + ".config." + "miss_weight")
              .defineInRange("miss_weight", 10, 0, 100000);
      commonWeight = builder
              .comment("A weight for common.")
              .translation(ChestWorld.MODID + ".config." + "common_weight")
              .defineInRange("common_weight", 30, 0, 100000);
      uncommonWeight = builder
              .comment("A weight for uncommon.")
              .translation(ChestWorld.MODID + ".config" + "uncommon_weight")
              .defineInRange("uncommon_weight", 25, 0, 100000);
      rareWeight = builder
              .comment("A weight for rare.")
              .translation(ChestWorld.MODID + ".config" + "rare_weight")
              .defineInRange("rare_weight", 20, 0, 100000);
      veryRareWeight = builder
              .comment("A weight for very rare.")
              .translation(ChestWorld.MODID + ".config" + "very_rare_weight")
              .defineInRange("very_rare_weight", 10, 0, 100000);
      ultraRareWeight = builder
              .comment("A weight for ultra rare.")
              .translation(ChestWorld.MODID + ".config" + "ultra_rare_weight")
              .defineInRange("ultra_rare_weight", 4, 0, 100000);
      legendaryWeight = builder
              .comment("A weight for legendary.")
              .translation(ChestWorld.MODID + ".config" + "legendary_weight")
              .defineInRange("legendary_weight", 1, 0, 100000);
      builder.pop();
      builder.push("Miss Weight");
      spawnMobsWeight = builder
              .comment("A weight for spawning mobs in miss.")
              .translation(ChestWorld.MODID + ".config" + "spawn_mobs_weight")
              .defineInRange("spawn_mobs_weight", 50, 0, 100000);
      explosionWeight = builder
              .comment("A weight for explosion in miss.")
              .translation(ChestWorld.MODID + ".config" + "explosion_weight")
              .defineInRange("explosion_weight", 30, 0, 100000);
      spawnerWeight = builder
              .comment("A weight for spawner in miss.")
              .translation(ChestWorld.MODID + ".config" + "spawner_weight")
              .defineInRange("spawner_weight", 20, 0, 100000);
      builder.pop();
    }
  }
}
