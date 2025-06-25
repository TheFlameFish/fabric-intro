package io.github.theflamefish.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.DataProvider;

public class FlameFishModdingIntroDataGenerator implements DataGeneratorEntrypoint {

  /**
   * Register {@link DataProvider} with the {@link FabricDataGenerator} during this entrypoint.
   *
   * @param fabricDataGenerator The {@link FabricDataGenerator} instance
   */
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(ModBlockTagProvider::new);
    pack.addProvider(ModItemTagProvider::new);
    pack.addProvider(ModLootTableProvider::new);
    pack.addProvider(ModModelProvider::new);
    pack.addProvider(ModRecipeProvider::new);
  }
}
