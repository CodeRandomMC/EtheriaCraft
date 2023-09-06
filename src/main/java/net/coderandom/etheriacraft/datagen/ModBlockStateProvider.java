package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EtheriaCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.END_GOLD_ORE);
        blockWithItem(ModBlocks.ENDERITE_SCRAP_ORE);

        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(ModBlocks.NETHER_SILVER_ORE);
        blockWithItem(ModBlocks.END_SILVER_ORE);
        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.RAW_SILVER_BLOCK);

        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.TOPAZ_ORE);
        blockWithItem(ModBlocks.TOPAZ_BLOCK);

        blockWithItem(ModBlocks.QUICK_SAND);

        blockWithItem(ModBlocks.MOSSY_BRICK);
        stairs(ModBlocks.MOSSY_BRICK_STAIRS.get(), ModBlocks.MOSSY_BRICK.get());
        slabBlock(((SlabBlock) ModBlocks.MOSSY_BRICK_SLAB.get()), blockTexture(ModBlocks.MOSSY_BRICK.get()), blockTexture(ModBlocks.MOSSY_BRICK.get()));
        pressurePlate(ModBlocks.MOSSY_BRICK_PRESSURE_PLATE.get(), ModBlocks.MOSSY_BRICK.get());
        wall(ModBlocks.MOSSY_BRICK_WALL.get(), ModBlocks.MOSSY_BRICK.get());


        blockWithItem(ModBlocks.GILDED_BLACKSTONE_BRICK);
        stairs(ModBlocks.GILDED_BLACKSTONE_BRICK_STAIRS.get(), ModBlocks.GILDED_BLACKSTONE_BRICK.get());
        slabBlock(((SlabBlock) ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB.get()), blockTexture(ModBlocks.GILDED_BLACKSTONE_BRICK.get()), blockTexture(ModBlocks.GILDED_BLACKSTONE_BRICK.get()));
        wall(ModBlocks.GILDED_BLACKSTONE_BRICK_WALL.get(), ModBlocks.GILDED_BLACKSTONE_BRICK.get());


        blockWithItem(ModBlocks.INFUSED_END_BRICK);
        stairs(ModBlocks.INFUSED_END_BRICK_STAIRS.get(), ModBlocks.INFUSED_END_BRICK.get());
        slabBlock(((SlabBlock) ModBlocks.INFUSED_END_BRICK_SLAB.get()), blockTexture(ModBlocks.INFUSED_END_BRICK.get()), blockTexture(ModBlocks.INFUSED_END_BRICK.get()));
        wall(ModBlocks.INFUSED_END_BRICK_WALL.get(), ModBlocks.INFUSED_END_BRICK.get());
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void stairs(Block stairsBlock, Block textureBlock) {
        stairsBlock(((StairBlock) stairsBlock), blockTexture(textureBlock));
    }

    private void wall(Block wallBlock, Block textureBlock) {
        wallBlock(((WallBlock) wallBlock), blockTexture(textureBlock));
    }

    private void button(Block buttonBlock, Block textureBlock) {
        buttonBlock(((ButtonBlock) buttonBlock), blockTexture(textureBlock));
    }

    private void pressurePlate(Block pressurePlateBlock, Block textureBlock) {
        pressurePlateBlock(((PressurePlateBlock) pressurePlateBlock), blockTexture(textureBlock));
    }

    private void fence(Block fenceBlock, Block textureBlock) {
        fenceBlock(((FenceBlock) fenceBlock), blockTexture(textureBlock));
    }

    private void fenceGate(Block fenceGateBlock, Block textureBlock) {
        fenceGateBlock(((FenceGateBlock) fenceGateBlock), blockTexture(textureBlock));
    }

    private void door(Block doorBlock, String bottomTextureLocation, String topTextureLocation) {
        doorBlockWithRenderType(((DoorBlock) doorBlock), modLoc(bottomTextureLocation), modLoc(topTextureLocation), "cutout");
    }

    private void trapDoor(Block trapDoorBlock, String textureLocation) {
        trapdoorBlockWithRenderType(((TrapDoorBlock) trapDoorBlock), modLoc(textureLocation), true, "cutout");
    }
}
