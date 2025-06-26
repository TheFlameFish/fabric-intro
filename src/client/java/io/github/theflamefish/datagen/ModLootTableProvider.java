package io.github.theflamefish.datagen;

import io.github.theflamefish.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
  public ModLootTableProvider(FabricDataOutput dataOutput) {
    super(dataOutput);
  }

  @Override
  public void generate() {
    addDrop(ModBlocks.CONDENSED_DIRT);
  }
}
