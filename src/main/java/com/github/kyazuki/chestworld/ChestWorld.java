package com.github.kyazuki.chestworld;

import com.github.kyazuki.chestworld.block.BlockChest;
import com.github.kyazuki.chestworld.block.BlockChestLeaves;
import com.github.kyazuki.chestworld.world.ChestWorldType;
import com.github.kyazuki.chestworld.world.biome.ChestWorldBiomes;
import com.github.kyazuki.chestworld.world.gen.carver.ChestCanyonWorldCarver;
import com.github.kyazuki.chestworld.world.gen.carver.ChestCaveWorldCarver;
import com.github.kyazuki.chestworld.world.gen.feature.ChestLakeFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(ChestWorld.MODID)
@Mod.EventBusSubscriber(modid = ChestWorld.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChestWorld {
  public static final String MODID = "chestworld";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  public static final Block CHEST_BLOCK = new BlockChest(Block.Properties.of((new Material.Builder(MaterialColor.WOOD)).build()).strength(2.5F).sound(SoundType.WOOD));
  public static final Block CHEST_BLOCK_LEAVES = new BlockChestLeaves(Block.Properties.of(new Material(MaterialColor.WOOD, false, true, true, false, false, false, PushReaction.NORMAL)).strength(2.5F).sound(SoundType.WOOD));
  public static final WorldCarver<CaveCarverConfiguration> CHEST_CAVE = new ChestCaveWorldCarver(CaveCarverConfiguration.CODEC);
  public static final WorldCarver<CanyonCarverConfiguration> CHEST_CANYON = new ChestCanyonWorldCarver(CanyonCarverConfiguration.CODEC);
  public static final Feature<BlockStateConfiguration> CHEST_LAKE = new ChestLakeFeature(BlockStateConfiguration.CODEC);
  public static final Biome CHEST_BIOME = ChestWorldBiomes.chestBiome();
  public static final ForgeWorldType CHEST_WORLD = new ChestWorldType();
  public static final Random rand = new Random();

  public ChestWorld() {
    LOGGER.debug("ChestWorld Loaded!");
//    MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ChestWorldConfig.COMMON_SPEC);
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
    return setup(entry, new ResourceLocation(MODID, name));
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
    entry.setRegistryName(registryName);
    return entry;
  }

  @SubscribeEvent
  public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
    event.getRegistry().registerAll(
            setup(CHEST_BLOCK, "block_chest"),
            setup(CHEST_BLOCK_LEAVES, "block_chest_leaves")
    );
  }

  @SubscribeEvent
  public static void onRegisterItem(RegistryEvent.Register<Item> event) {
    event.getRegistry().registerAll(
            setup(new BlockItem(CHEST_BLOCK, new Item.Properties().tab(CreativeModeTab.TAB_MISC)), "block_chest"),
            setup(new BlockItem(CHEST_BLOCK_LEAVES, new Item.Properties().tab(CreativeModeTab.TAB_MISC)), "block_chest_leaves")
    );
  }

  @SubscribeEvent
  public static void onRegisterCarvers(RegistryEvent.Register<WorldCarver<?>> event) {
    event.getRegistry().registerAll(
        setup(CHEST_CAVE, "chest_cave"),
        setup(CHEST_CANYON, "chest_canyon")
    );
  }

  @SubscribeEvent
  public static void onRegisterFeatures(RegistryEvent.Register<Feature<?>> event) {
    event.getRegistry().register(
        setup(CHEST_LAKE, "chest_lake")
    );
  }

  @SubscribeEvent
  public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
    event.getRegistry().register(
        setup(ChestWorld.CHEST_BIOME, "chest_biome")
    );
  }

  @SubscribeEvent
  public static void onRegisterWorldType(RegistryEvent.Register<ForgeWorldType> event) {
    event.getRegistry().register(
        setup(CHEST_WORLD, "chest_world")
    );
  }

//  public static DimensionGeneratorSettings createDimensionGeneratorSettings(long seed, boolean generateFeatures, boolean generateBonusChest) {
//    return new DimensionGeneratorSettings(seed, generateFeatures, generateBonusChest, DimensionGeneratorSettings.func_236216_a_(DimensionType.func_236022_a_(seed), new NoiseChunkGenerator(new SingleBiomeProvider(CHEST_BIOME), seed, new DimensionSettings.Preset("chestworld", (preset) -> new DimensionSettings(new DimensionStructuresSettings(true), new NoiseSettings(256, new ScalingSettings(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D), new SlideSettings(-10, 3, 0), new SlideSettings(-30, 0, 0), 1, 2, 1.0D, -0.46875D, true, true, false, false), CHEST_BLOCK.getDefaultState(), Blocks.WATER.getDefaultState(), -10, 0, 63, false, Optional.of(preset))).getSettings())));
//  }
//
//  @SubscribeEvent
//  public void serverStarting(final FMLServerAboutToStartEvent event) {
//    if (!(event.getServer() instanceof DedicatedServer)) return;
//
//    DedicatedServer server = (DedicatedServer) event.getServer();
//    ServerProperties properties = server.getServerProperties();
//
//    if (server.func_240793_aU_().func_230407_G_() instanceof ServerWorldInfo) {
//      ServerWorldInfo worldInfo = (ServerWorldInfo) server.func_240793_aU_().func_230407_G_();
//      long seed = worldInfo.getDimensionGeneratorSettings().getSeed();
//      worldInfo.generatorSettings = createDimensionGeneratorSettings(seed, worldInfo.getDimensionGeneratorSettings().doesGenerateFeatures(), worldInfo.getDimensionGeneratorSettings().hasBonusChest());
//    }
//
//    long seed = properties.field_241082_U_.getSeed();
//    properties.field_241082_U_ = createDimensionGeneratorSettings(seed, properties.field_241082_U_.doesGenerateFeatures(), properties.field_241082_U_.hasBonusChest());
//  }
}
