package io.github.theflamefish.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class ModTools {
  public static final Item GUIDITE_SWORD =
      ModItems.register(
          "guidite_sword",
          new SwordItem(ModToolMaterials.GUIDITE, 2, 0.5f, new FabricItemSettings()));

  public static void initialize() {}
}
