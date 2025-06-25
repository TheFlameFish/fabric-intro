package io.github.theflamefish.datagen;

import io.github.theflamefish.item.ModItems;
import java.util.List;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class ModRecipeProvider extends FabricRecipeProvider {
  public ModRecipeProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generate(Consumer<RecipeJsonProvider> exporter) {
    offerSmelting(
        exporter,
        List.of(Items.NETHER_STAR),
        RecipeCategory.FOOD,
        ModItems.SUSPICIOUS_SUBSTANCE,
        0.1f,
        200,
        "");
    offerBlasting(
        exporter,
        List.of(Items.NETHER_STAR),
        RecipeCategory.FOOD,
        ModItems.SUSPICIOUS_SUBSTANCE,
        0.1f,
        200,
        "");
  }
}
