package io.github.theflamefish.item;

import io.github.theflamefish.FlameFishModdingIntro;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
  public static final RegistryKey<ItemGroup> CUSTOM_GROUP_KEY =
      RegistryKey.of(
          Registries.ITEM_GROUP.getKey(),
          new Identifier(FlameFishModdingIntro.MOD_ID, "intro_group"));
  public static final ItemGroup CUSTOM_GROUP =
      FabricItemGroup.builder()
          .icon(() -> new ItemStack(Items.COD))
          .displayName(Text.translatable("itemGroup." + FlameFishModdingIntro.MOD_ID))
          .build();

  public static final Item COOLARG_ITEM =
      register("coolarg_item", new Item(new FabricItemSettings()));

  public static final FoodComponent SUSPICIOUS_FOOD_COMPONENT =
      new FoodComponent.Builder()
          .alwaysEdible()
          .snack()
          .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 6 * 20, 1), 1.0f)
          .build();

  // Oh my
  public static final Item SUSPICIOUS_SUBSTANCE =
      register(
          "suspicious_substance",
          new Item(new FabricItemSettings().food(SUSPICIOUS_FOOD_COMPONENT)));

  // Docs for this function prob not needed but 80% chance imma be very confused about this later if
  // I don't :p
  /**
   * Register an item
   *
   * @param item The item to register. Instance of a class that extends Item.
   * @param id The unique identifier of the item. This'll be concatenated to the modid.
   * @param itemGroupKey The item group (creative tab) for this item to be added to. Nullable.
   * @return The registered item, cast to the same class as provided.
   */
  public static <T extends Item> T register(
      String id, T item, RegistryKey<ItemGroup> itemGroupKey) {
    // fullID is what'll define an item as, for example, "flamefish-modding-intro:coolarg-item"
    Identifier fullID = new Identifier(FlameFishModdingIntro.MOD_ID, id);

    T registeredItem = Registry.register(Registries.ITEM, fullID, item);

    if (itemGroupKey != null) {
      ItemGroupEvents.modifyEntriesEvent(itemGroupKey)
          .register((itemGroup) -> itemGroup.add(registeredItem));
    }

    return registeredItem;
  }

  /**
   * Register an item & add it to the primary creative tab
   *
   * @param item The item to register. Instance of a class that extends Item.
   * @param id The unique identifier of the item. This'll be concatenated to the modid.
   * @return The registered item, cast to the same class as provided.
   */
  public static <T extends Item> T register(String id, T item) {
    return register(id, item, CUSTOM_GROUP_KEY);
  }

  /** Initialize all modded items */
  // Ig this needs to be called for the static fields to be defined?
  public static void initialize() {
    Registry.register(Registries.ITEM_GROUP, CUSTOM_GROUP_KEY, CUSTOM_GROUP);

    // 30% chance of increasing composter level
    CompostingChanceRegistry.INSTANCE.add(SUSPICIOUS_SUBSTANCE, 0.3f);
  }
}
