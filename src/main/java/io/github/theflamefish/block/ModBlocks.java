package io.github.theflamefish.block;

import io.github.theflamefish.FlameFishModdingIntro;
import io.github.theflamefish.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
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

  public static void initialize() {}
}
