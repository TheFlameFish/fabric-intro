package io.github.theflamefish.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class ModArmors {
  public static final Item GUIDITE_HELMET =
      ModItems.register(
          "guidite_helmet",
          new ArmorItem(ModArmorMaterials.GUIDITE, ArmorItem.Type.HELMET, new Item.Settings()));
  public static final Item GUIDITE_BOOTS =
      ModItems.register(
          "guidite_boots",
          new ArmorItem(ModArmorMaterials.GUIDITE, ArmorItem.Type.BOOTS, new Item.Settings()));
  public static final Item GUIDITE_LEGGINGS =
      ModItems.register(
          "guidite_leggings",
          new ArmorItem(ModArmorMaterials.GUIDITE, ArmorItem.Type.LEGGINGS, new Item.Settings()));
  public static final Item GUIDITE_CHESTPLATE =
      ModItems.register(
          "guidite_chestplate",
          new ArmorItem(ModArmorMaterials.GUIDITE, ArmorItem.Type.CHESTPLATE, new Item.Settings()));

  public static void initialize() {}
}
