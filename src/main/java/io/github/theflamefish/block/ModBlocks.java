package io.github.theflamefish.block;

import io.github.theflamefish.FlameFishModdingIntro;
import io.github.theflamefish.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
  public static final Block CONDENSED_DIRT =
      register(
          "condensed_dirt",
          new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).hardness(0.7f)));

  public static final PillarBlock CONDENSED_OAK_LOG =
      register(
          "condensed_oak_log",
          new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).hardness(2.5f)));

  public static final Block CONDENSED_OAK_WOOD =
      register(
          "condensed_oak_wood",
          new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).hardness(2.5f)));

  public static final Block RUBY_BLOCK =
      register(
          "ruby_block",
          new Block(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static final Block RUBY_STAIRS =
      register(
          "ruby_stairs",
          new StairsBlock(
              RUBY_BLOCK.getDefaultState(),
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static final Block RUBY_SLAB =
      register(
          "ruby_slab",
          new SlabBlock(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static final Block RUBY_BUTTON =
      register(
          "ruby_button",
          new ButtonBlock(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .noCollision()
                  .sounds(BlockSoundGroup.AMETHYST_BLOCK),
              BlockSetType.IRON,
              10,
              true));

  public static final Block RUBY_PRESSURE_PLATE =
      register(
          "ruby_pressure_plate",
          new PressurePlateBlock(
              PressurePlateBlock.ActivationRule.EVERYTHING,
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK),
              BlockSetType.IRON));

  public static final Block RUBY_FENCE =
      register(
          "ruby_fence",
          new FenceBlock(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static final Block RUBY_FENCE_GATE =
      register(
          "ruby_fence_gate",
          new FenceGateBlock(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK),
              WoodType.ACACIA));

  public static final Block RUBY_WALL =
      register(
          "ruby_wall",
          new WallBlock(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static final Block RUBY_DOOR =
      register(
          "ruby_door",
          new DoorBlock(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .nonOpaque()
                  .sounds(BlockSoundGroup.AMETHYST_BLOCK),
              BlockSetType.IRON));

  public static final Block RUBY_TRAPDOOR =
      register(
          "ruby_trapdoor",
          new TrapdoorBlock(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .nonOpaque()
                  .sounds(BlockSoundGroup.AMETHYST_BLOCK),
              BlockSetType.IRON));

  public static <T extends Block> T register(
      String name, T block, boolean registerItem, RegistryKey<ItemGroup> creativeTab) {
    Identifier id = new Identifier(FlameFishModdingIntro.MOD_ID, name);

    if (registerItem) {
      BlockItem blockItem = new BlockItem(block, new Item.Settings());
      ModItems.register(name, blockItem, creativeTab);
    }

    return Registry.register(Registries.BLOCK, id, block);
  }

  public static <T extends Block> T register(String name, T block, boolean registerItem) {
    return register(name, block, registerItem, ModItems.CUSTOM_GROUP_KEY);
  }

  public static <T extends Block> T register(String name, T block) {
    return register(name, block, true);
  }

  public static void initialize() {
    PrismarineLampBlock.initialize();
  }
}
