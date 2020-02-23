package com.github.kyazuki.chestworld;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(ChestWorld.MODID)
@Mod.EventBusSubscriber(modid = ChestWorld.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChestWorld {
  public static final String MODID = "chestworld";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  public static final Block CHEST_BLOCK = new BlockChest(Block.Properties.create((new Material.Builder(MaterialColor.WOOD)).build()).hardnessAndResistance(2.5F).sound(SoundType.WOOD));
  public static final Block CHEST_BLOCK_LEAVES = new BlockChestLeaves(Block.Properties.create((new Material.Builder(MaterialColor.WOOD)).build()).hardnessAndResistance(2.5F).sound(SoundType.WOOD));
  public static final Biome CHEST_BIOME = new ChestBiome();
  public static final WorldType CHEST_WORLD = new ChestWorldType();
  public static final Random rand = new Random();

  public ChestWorld() {
    LOGGER.debug("ChestWorld Loaded!");
    ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ChestWorldConfig.CLIENT_SPEC);
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
}
