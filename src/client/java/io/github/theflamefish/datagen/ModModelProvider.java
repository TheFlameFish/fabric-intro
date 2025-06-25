package io.github.theflamefish.datagen;

import io.github.theflamefish.item.LightningStick;
import io.github.theflamefish.item.ModArmors;
import io.github.theflamefish.item.ModItems;
import io.github.theflamefish.item.ModTools;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Items;

public class ModModelProvider extends FabricModelProvider {
  public ModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.SUSPICIOUS_SUBSTANCE, Models.GENERATED);
    itemModelGenerator.register(LightningStick.INSTANCE, Items.STICK, Models.GENERATED);
    itemModelGenerator.register(ModArmors.GUIDITE_BOOTS, Models.GENERATED);
    itemModelGenerator.register(ModArmors.GUIDITE_CHESTPLATE, Models.GENERATED);
    itemModelGenerator.register(ModArmors.GUIDITE_HELMET, Models.GENERATED);
    itemModelGenerator.register(ModArmors.GUIDITE_LEGGINGS, Models.GENERATED);

    itemModelGenerator.register(ModTools.GUIDITE_SWORD, Models.HANDHELD);
  }
}
