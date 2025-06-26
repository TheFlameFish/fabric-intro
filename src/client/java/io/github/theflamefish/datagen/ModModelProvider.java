package io.github.theflamefish.datagen;

import io.github.theflamefish.FlameFishModdingIntro;
import io.github.theflamefish.block.ModBlocks;
import io.github.theflamefish.item.LightningStick;
import io.github.theflamefish.item.ModArmors;
import io.github.theflamefish.item.ModItems;
import io.github.theflamefish.item.ModTools;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModModelProvider extends FabricModelProvider {
  public ModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_DIRT);

    // FIXME No rotate. I may have to do some fancy stuff (unless I'm stupid and missing smth obvious)
    blockStateModelGenerator.registerSingleton(
        ModBlocks.CONDENSED_OAK_LOG, TexturedModel.CUBE_COLUMN);

  }

  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.SUSPICIOUS_SUBSTANCE, Models.GENERATED);
    itemModelGenerator.register(ModItems.COOLARG_ITEM, Items.COD, Models.GENERATED);
    itemModelGenerator.register(LightningStick.INSTANCE, Items.STICK, Models.GENERATED);
    itemModelGenerator.register(ModArmors.GUIDITE_BOOTS, Models.GENERATED);
    itemModelGenerator.register(ModArmors.GUIDITE_CHESTPLATE, Models.GENERATED);
    itemModelGenerator.register(ModArmors.GUIDITE_HELMET, Models.GENERATED);
    itemModelGenerator.register(ModArmors.GUIDITE_LEGGINGS, Models.GENERATED);

    itemModelGenerator.register(ModTools.GUIDITE_SWORD, Models.HANDHELD);
  }
}
