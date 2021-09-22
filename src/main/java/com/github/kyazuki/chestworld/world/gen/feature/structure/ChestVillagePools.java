package com.github.kyazuki.chestworld.world.gen.feature.structure;

import com.github.kyazuki.chestworld.world.biome.ChestWorldBiomeMaker;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;

public class ChestVillagePools {
  public static final JigsawPattern START = JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/chest/town_centers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/chest/town_centers/plains_fountain_01"), 50), Pair.of(JigsawPiece.legacy("village/chest/town_centers/plains_meeting_point_1"), 50), Pair.of(JigsawPiece.legacy("village/chest/town_centers/plains_meeting_point_2"), 50), Pair.of(JigsawPiece.legacy("village/chest/town_centers/plains_meeting_point_3"), 50)), JigsawPattern.PlacementBehaviour.RIGID));

  public static void init() {
  }

  static {
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/chest/streets"), new ResourceLocation("village/chest/terminators"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/chest/streets/corner_01"), 2), Pair.of(JigsawPiece.legacy("village/chest/streets/corner_02"), 2), Pair.of(JigsawPiece.legacy("village/chest/streets/corner_03"), 2), Pair.of(JigsawPiece.legacy("village/chest/streets/straight_01"), 4), Pair.of(JigsawPiece.legacy("village/chest/streets/straight_02"), 4), Pair.of(JigsawPiece.legacy("village/chest/streets/straight_03"), 7), Pair.of(JigsawPiece.legacy("village/chest/streets/straight_04"), 7), Pair.of(JigsawPiece.legacy("village/chest/streets/straight_05"), 3), Pair.of(JigsawPiece.legacy("village/chest/streets/straight_06"), 4), Pair.of(JigsawPiece.legacy("village/chest/streets/crossroad_01"), 2), Pair.of(JigsawPiece.legacy("village/chest/streets/crossroad_02"), 1), Pair.of(JigsawPiece.legacy("village/chest/streets/crossroad_03"), 2), Pair.of(JigsawPiece.legacy("village/chest/streets/crossroad_04"), 2), Pair.of(JigsawPiece.legacy("village/chest/streets/crossroad_05"), 2), Pair.of(JigsawPiece.legacy("village/chest/streets/crossroad_06"), 2), Pair.of(JigsawPiece.legacy("village/chest/streets/turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/chest/houses"), new ResourceLocation("village/chest/terminators"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_house_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_house_2"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_house_3"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_house_4"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_house_5"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_house_6"), 1), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_house_7"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_house_8"), 3), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_medium_house_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_medium_house_2"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_big_house_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_butcher_shop_1"), 2), new Pair[]{Pair.of(JigsawPiece.legacy("village/chest/houses/plains_butcher_shop_2"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_tool_smith_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_fletcher_house_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_shepherds_house_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_armorer_house_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_fisher_cottage_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_tannery_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_cartographer_1"), 1), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_library_1"), 5), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_library_2"), 1), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_masons_house_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_weaponsmith_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_temple_3"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_temple_4"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_stable_1"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_stable_2"), 2), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_large_farm_1"), 4), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_small_farm_1"), 4), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_animal_pen_1"), 1), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_animal_pen_2"), 1), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_animal_pen_3"), 5), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_accessory_1"), 1), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_meeting_point_4"), 3), Pair.of(JigsawPiece.legacy("village/chest/houses/plains_meeting_point_5"), 1), Pair.of(JigsawPiece.empty(), 10)}), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/chest/terminators"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/chest/terminators/terminator_01"), 1), Pair.of(JigsawPiece.legacy("village/chest/terminators/terminator_02"), 1), Pair.of(JigsawPiece.legacy("village/chest/terminators/terminator_03"), 1), Pair.of(JigsawPiece.legacy("village/chest/terminators/terminator_04"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/chest/trees"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.feature(Feature.TREE.configured(ChestWorldBiomeMaker.CHEST_TREE_CONFIG)), 1)), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/chest/decor"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/chest/plains_lamp_1"), 2), Pair.of(JigsawPiece.feature(Feature.TREE.configured(ChestWorldBiomeMaker.CHEST_TREE_CONFIG)), 1), Pair.of(JigsawPiece.feature(Feature.BLOCK_PILE.configured(ChestWorldBiomeMaker.HAY_PILE_CONFIG)), 1), Pair.of(JigsawPiece.empty(), 2)), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/chest/villagers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/chest/villagers/nitwit"), 1), Pair.of(JigsawPiece.legacy("village/chest/villagers/baby"), 1), Pair.of(JigsawPiece.legacy("village/chest/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/common/animals"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/common/animals/cows_1"), 7), Pair.of(JigsawPiece.legacy("village/common/animals/pigs_1"), 7), Pair.of(JigsawPiece.legacy("village/common/animals/horses_1"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/horses_2"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/horses_3"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/horses_4"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/horses_5"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/sheep_1"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/sheep_2"), 1), Pair.of(JigsawPiece.empty(), 5)), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/common/sheep"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/common/animals/sheep_1"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/sheep_2"), 1)), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/common/cats"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/common/animals/cat_black"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_british"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_calico"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_persian"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_ragdoll"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_red"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_siamese"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_tabby"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_white"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/cat_jellie"), 1), Pair.of(JigsawPiece.empty(), 3)), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/common/butcher_animals"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/common/animals/cows_1"), 3), Pair.of(JigsawPiece.legacy("village/common/animals/pigs_1"), 3), Pair.of(JigsawPiece.legacy("village/common/animals/sheep_1"), 1), Pair.of(JigsawPiece.legacy("village/common/animals/sheep_2"), 1)), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/common/iron_golem"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/common/iron_golem"), 1)), JigsawPattern.PlacementBehaviour.RIGID));
    JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/common/well_bottoms"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/common/well_bottom"), 1)), JigsawPattern.PlacementBehaviour.RIGID));
  }
}