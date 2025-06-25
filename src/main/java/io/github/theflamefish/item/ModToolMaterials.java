package io.github.theflamefish.item;

import com.google.common.base.Suppliers;
import java.util.function.Supplier;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterials implements ToolMaterial {
  GUIDITE(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.ofItems(ModItems.SUSPICIOUS_SUBSTANCE));

  private final int miningLevel;
  private final int itemDurability;
  private final float miningSpeedMultiplier;
  private final float attackDamage;
  private final int enchantability;
  private final Supplier<Ingredient> repairIngredient;

  ModToolMaterials(
      int miningLevel,
      int itemDurability,
      float miningSpeedMultiplier,
      float attackDamage,
      int enchantability,
      Supplier<Ingredient> repairIngredient) {
    this.miningLevel = miningLevel;
    this.itemDurability = itemDurability;
    this.miningSpeedMultiplier = miningSpeedMultiplier;
    this.attackDamage = attackDamage;
    this.enchantability = enchantability;
    this.repairIngredient = Suppliers.memoize(repairIngredient::get);
  }

  @Override
  public int getDurability() {
    return this.itemDurability;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return this.miningSpeedMultiplier;
  }

  @Override
  public float getAttackDamage() {
    return this.attackDamage;
  }

  @Override
  public int getMiningLevel() {
    return this.miningLevel;
  }

  @Override
  public int getEnchantability() {
    return this.enchantability;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return this.repairIngredient.get();
  }
}
