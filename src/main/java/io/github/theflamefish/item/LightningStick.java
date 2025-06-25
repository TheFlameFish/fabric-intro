package io.github.theflamefish.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightningStick extends Item {
  public LightningStick(Settings settings) {
    super(settings);
  }

  public static LightningStick INSTANCE =
      ModItems.register("lightning_stick", new LightningStick(new FabricItemSettings()));

  public static void initialize() {}

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    // Only operate server-side
    if (world.isClient) {
      return TypedActionResult.pass(user.getStackInHand(hand));
    }

    BlockPos frontOfPlayer = BlockPos.ofFloored(user.raycast(50, 0, false).getPos());

    // Spawn the lightning bolt
    LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
    lightningBolt.setPosition(frontOfPlayer.toCenterPos());
    world.spawnEntity(lightningBolt);

    return TypedActionResult.success(user.getStackInHand(hand));
  }
}
