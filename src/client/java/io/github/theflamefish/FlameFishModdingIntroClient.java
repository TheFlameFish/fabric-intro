package io.github.theflamefish;

import io.github.theflamefish.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FlameFishModdingIntroClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    // This entrypoint is suitable for setting up client-specific logic, such as rendering.
    BlockRenderLayerMap.INSTANCE.putBlocks(
        RenderLayer.getCutout(), ModBlocks.RUBY_DOOR, ModBlocks.RUBY_TRAPDOOR);
  }
}
