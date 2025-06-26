package io.github.theflamefish.datagen;

import io.github.theflamefish.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
  public ModLootTableProvider(FabricDataOutput dataOutput) {
    super(dataOutput);
  }

  @Override
  public void generate() {
    selfDrop(
        ModBlocks.CONDENSED_DIRT,
        ModBlocks.RUBY_BLOCK,
        ModBlocks.RUBY_STAIRS,
        ModBlocks.RUBY_TRAPDOOR,
        ModBlocks.RUBY_WALL,
        ModBlocks.RUBY_FENCE,
        ModBlocks.RUBY_FENCE_GATE,
        ModBlocks.RUBY_BUTTON,
        ModBlocks.RUBY_PRESSURE_PLATE);

    addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
    addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));
  }

  private void selfDrop(Block... blocks) {
    for (Block block : blocks) {
      addDrop(block);
    }
  }
}
