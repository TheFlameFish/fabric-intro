package io.github.theflamefish.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PrismarineLampBlock extends Block {
  public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

  public static final PrismarineLampBlock INSTANCE =
      ModBlocks.register(
          "prismarine_lamp",
          new PrismarineLampBlock(
              AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                  .luminance((BlockState state) -> state.get(ACTIVATED) ? 10 : 0)));

  public PrismarineLampBlock(Settings settings) {
    super(settings);

    setDefaultState(getDefaultState().with(ACTIVATED, false));
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(ACTIVATED);
  }

  @Override
  public ActionResult onUse(
      BlockState state,
      World world,
      BlockPos pos,
      PlayerEntity player,
      Hand hand,
      BlockHitResult hit) {
    if (!player.getAbilities().allowModifyWorld) {
      return ActionResult.PASS;
    } else {
      boolean activated = state.get(ACTIVATED);

      world.setBlockState(pos, state.with(ACTIVATED, !activated));

      world.playSound(
          player, pos, SoundEvents.ENTITY_TROPICAL_FISH_FLOP, SoundCategory.BLOCKS, 1.0f, 1.0f);

      return ActionResult.SUCCESS;
    }
  }

  public static void initialize() {}
}
