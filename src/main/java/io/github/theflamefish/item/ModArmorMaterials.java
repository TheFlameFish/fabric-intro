package io.github.theflamefish.item;

import java.util.EnumMap;
import java.util.function.Supplier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;

public enum ModArmorMaterials implements StringIdentifiable, ArmorMaterial {
  GUIDITE(
      "guidite",
      15,
      Util.make(
          new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class),
          (map) -> {
            map.put(Type.BOOTS, 3);
            map.put(Type.LEGGINGS, 6);
            map.put(Type.CHESTPLATE, 8);
            map.put(Type.HELMET, 0);
          }),
      5,
      SoundEvents.ITEM_ARMOR_EQUIP_IRON,
      2.0F,
      0.0F,
      () -> {
        return Ingredient.ofItems(new ItemConvertible[] {ModItems.SUSPICIOUS_SUBSTANCE});
      });

  public static final StringIdentifiable.Codec<net.minecraft.item.ArmorMaterials> CODEC =
      StringIdentifiable.createCodec(net.minecraft.item.ArmorMaterials::values);
  private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY =
      Util.make(
          new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class),
          (map) -> {
            map.put(Type.BOOTS, 13);
            map.put(Type.LEGGINGS, 15);
            map.put(Type.CHESTPLATE, 16);
            map.put(Type.HELMET, 11);
          });
  private final String name;
  private final int durabilityMultiplier;
  private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
  private final int enchantability;
  private final SoundEvent equipSound;
  private final float toughness;
  private final float knockbackResistance;
  private final Lazy<Ingredient> repairIngredientSupplier;

  private ModArmorMaterials(
      String name,
      int durabilityMultiplier,
      EnumMap protectionAmounts,
      int enchantability,
      SoundEvent equipSound,
      float toughness,
      float knockbackResistance,
      Supplier repairIngredientSupplier) {
    this.name = name;
    this.durabilityMultiplier = durabilityMultiplier;
    this.protectionAmounts = protectionAmounts;
    this.enchantability = enchantability;
    this.equipSound = equipSound;
    this.toughness = toughness;
    this.knockbackResistance = knockbackResistance;
    this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
  }

  public int getDurability(ArmorItem.Type type) {
    return (Integer) BASE_DURABILITY.get(type) * this.durabilityMultiplier;
  }

  public int getProtection(ArmorItem.Type type) {
    return (Integer) this.protectionAmounts.get(type);
  }

  public int getEnchantability() {
    return this.enchantability;
  }

  public SoundEvent getEquipSound() {
    return this.equipSound;
  }

  public Ingredient getRepairIngredient() {
    return (Ingredient) this.repairIngredientSupplier.get();
  }

  public String getName() {
    return this.name;
  }

  public float getToughness() {
    return this.toughness;
  }

  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }

  public String asString() {
    return this.name;
  }
}
