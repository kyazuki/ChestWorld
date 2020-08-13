package com.github.kyazuki.chestworld;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.gui.screen.BiomeGeneratorTypeScreens;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.ServerProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.*;
import net.minecraft.world.storage.ServerWorldInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.Random;

@Mod(ChestWorld.MODID)
@Mod.EventBusSubscriber(modid = ChestWorld.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChestWorld {
  public static final String MODID = "chestworld";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  public static final Block CHEST_BLOCK = new BlockChest(Block.Properties.create((new Material.Builder(MaterialColor.WOOD)).build()).hardnessAndResistance(2.5F).sound(SoundType.WOOD));
  public static final Block CHEST_BLOCK_LEAVES = new BlockChestLeaves(Block.Properties.create(new Material(MaterialColor.WOOD, false, true, true, false, false, false, PushReaction.NORMAL)).hardnessAndResistance(2.5F).sound(SoundType.WOOD));
  public static final Biome CHEST_BIOME = new ChestBiome();
  public static final Random rand = new Random();

  public ChestWorld() {
    LOGGER.debug("ChestWorld Loaded!");
    MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ChestWorldConfig.COMMON_SPEC);

    if (FMLEnvironment.dist == Dist.CLIENT)
      BiomeGeneratorTypeScreens.field_239068_c_.add(new ChestBiomeGeneratorTypeScreen());
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
    return setup(entry, new ResourceLocation(ChestWorld.MODID, name));
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
            setup(new BlockItem(CHEST_BLOCK, new Item.Properties().group(ItemGroup.MISC)), "block_chest"),
            setup(new BlockItem(CHEST_BLOCK_LEAVES, new Item.Properties().group(ItemGroup.MISC)), "block_chest_leaves")
    );
  }

  @SubscribeEvent
  public static void onRegisterBiome(RegistryEvent.Register<Biome> event) {
    CHEST_BIOME.setRegistryName(ChestWorld.MODID, "chest_biome");
    ForgeRegistries.BIOMES.register(CHEST_BIOME);
    BiomeDictionary.addTypes(CHEST_BIOME, BiomeDictionary.Type.PLAINS);
    BiomeManager.addSpawnBiome(CHEST_BIOME);
  }

  public static DimensionGeneratorSettings createDimensionGeneratorSettings(long seed, boolean generateFeatures, boolean generateBonusChest) {
    return new DimensionGeneratorSettings(seed, generateFeatures, generateBonusChest, DimensionGeneratorSettings.func_236216_a_(DimensionType.func_236022_a_(seed), new NoiseChunkGenerator(new SingleBiomeProvider(CHEST_BIOME), seed, new DimensionSettings.Preset("chestworld", (preset) -> new DimensionSettings(new DimensionStructuresSettings(true), new NoiseSettings(256, new ScalingSettings(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D), new SlideSettings(-10, 3, 0), new SlideSettings(-30, 0, 0), 1, 2, 1.0D, -0.46875D, true, true, false, false), CHEST_BLOCK.getDefaultState(), Blocks.WATER.getDefaultState(), -10, 0, 63, false, Optional.of(preset))).getSettings())));
  }

  @SubscribeEvent
  public void serverStarting(final FMLServerAboutToStartEvent event) {
    if (!(event.getServer() instanceof DedicatedServer)) return;

    DedicatedServer server = (DedicatedServer) event.getServer();
    ServerProperties properties = server.getServerProperties();

    if (server.func_240793_aU_().func_230407_G_() instanceof ServerWorldInfo) {
      ServerWorldInfo worldInfo = (ServerWorldInfo) server.func_240793_aU_().func_230407_G_();
      long seed = worldInfo.getDimensionGeneratorSettings().getSeed();
      worldInfo.generatorSettings = createDimensionGeneratorSettings(seed, worldInfo.getDimensionGeneratorSettings().doesGenerateFeatures(), worldInfo.getDimensionGeneratorSettings().hasBonusChest());
    }

    long seed = properties.field_241082_U_.getSeed();
    properties.field_241082_U_ = createDimensionGeneratorSettings(seed, properties.field_241082_U_.doesGenerateFeatures(), properties.field_241082_U_.hasBonusChest());
  }
}
