package io.github.theflamefish.datagen;

import io.github.theflamefish.block.ModBlocks;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
  public ModBlockTagProvider(
      FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(ModBlocks.CONDENSED_DIRT);

    getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE);
    getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_FENCE_GATE);
    getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.RUBY_WALL);
  }
}
