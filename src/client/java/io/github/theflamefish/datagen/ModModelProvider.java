package io.github.theflamefish.datagen;

import io.github.theflamefish.block.ModBlocks;
import io.github.theflamefish.block.PrismarineLampBlock;
import io.github.theflamefish.item.LightningStick;
import io.github.theflamefish.item.ModArmors;
import io.github.theflamefish.item.ModItems;
import io.github.theflamefish.item.ModTools;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
  public ModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_DIRT);

    BlockStateModelGenerator.BlockTexturePool rubyPool =
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);

    rubyPool.stairs(ModBlocks.RUBY_STAIRS);
    rubyPool.slab(ModBlocks.RUBY_SLAB);
    rubyPool.button(ModBlocks.RUBY_BUTTON);
    rubyPool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
    rubyPool.fence(ModBlocks.RUBY_FENCE);
    rubyPool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
    rubyPool.wall(ModBlocks.RUBY_WALL);

    blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
    blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);

    // registerLog actually makes a texture pool; it doesn't make any blockstates
    blockStateModelGenerator
        .registerLog(ModBlocks.CONDENSED_OAK_LOG)
        .log(ModBlocks.CONDENSED_OAK_LOG)
        .wood(ModBlocks.CONDENSED_OAK_WOOD);

    TextureMap primarineLampOffTextureMap =
        new TextureMap()
            .put(TextureKey.ALL, ModelIds.getBlockModelId(PrismarineLampBlock.INSTANCE));

    TextureMap primarineLampOnTextureMap =
        new TextureMap()
            .put(TextureKey.ALL, ModelIds.getBlockSubModelId(PrismarineLampBlock.INSTANCE, "_on"));

    Identifier prismarineLampOff =
        Models.CUBE_ALL.upload(
            PrismarineLampBlock.INSTANCE,
            primarineLampOffTextureMap,
            blockStateModelGenerator.modelCollector);
    Identifier prismarineLampOn =
        Models.CUBE_ALL.upload(
            ModelIds.getBlockSubModelId(PrismarineLampBlock.INSTANCE, "_on"),
            primarineLampOnTextureMap,
            blockStateModelGenerator.modelCollector);

    BlockStateSupplier prismarineLampBlockStates =
        VariantsBlockStateSupplier.create(PrismarineLampBlock.INSTANCE)
            .coordinate(
                BlockStateVariantMap.create(PrismarineLampBlock.ACTIVATED)
                    .register(
                        false,
                        BlockStateVariant.create().put(VariantSettings.MODEL, prismarineLampOff))
                    .register(
                        true,
                        BlockStateVariant.create().put(VariantSettings.MODEL, prismarineLampOn)));

    blockStateModelGenerator.blockStateCollector.accept(prismarineLampBlockStates);
    blockStateModelGenerator.registerParentedItemModel(
        PrismarineLampBlock.INSTANCE, prismarineLampOff);
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
