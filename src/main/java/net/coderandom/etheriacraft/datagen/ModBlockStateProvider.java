package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.custom.crops.CilliCropBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.CornCropBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.LettuceCropBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.TomatoCropBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.essence_crops.EmeraldEssenceCropBlock;
import net.coderandom.etheriacraft.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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
        blockWithItem(ModBlocks.INFUSION_TABLE);

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

        blockWithItem(ModBlocks.ENRICHED_NETHER_BRICK);
        stairs(ModBlocks.ENRICHED_NETHER_BRICK_STAIRS.get(), ModBlocks.ENRICHED_NETHER_BRICK.get());
        slabBlock(((SlabBlock) ModBlocks.ENRICHED_NETHER_BRICK_SLAB.get()), blockTexture(ModBlocks.ENRICHED_NETHER_BRICK.get()), blockTexture(ModBlocks.ENRICHED_NETHER_BRICK.get()));
        wall(ModBlocks.ENRICHED_NETHER_BRICK_WALL.get(), ModBlocks.ENRICHED_NETHER_BRICK.get());
        fence(ModBlocks.ENRICHED_NETHER_BRICK_FENCE.get(), ModBlocks.ENRICHED_NETHER_BRICK.get());
        fenceGate(ModBlocks.ENRICHED_NETHER_BRICK_FENCE_GATE.get(), ModBlocks.ENRICHED_NETHER_BRICK.get());

        blockWithItem(ModBlocks.ENRICHED_RED_NETHER_BRICK);
        stairs(ModBlocks.ENRICHED_RED_NETHER_BRICK_STAIRS.get(), ModBlocks.ENRICHED_RED_NETHER_BRICK.get());
        slabBlock(((SlabBlock) ModBlocks.ENRICHED_RED_NETHER_BRICK_SLAB.get()), blockTexture(ModBlocks.ENRICHED_RED_NETHER_BRICK.get()), blockTexture(ModBlocks.ENRICHED_RED_NETHER_BRICK.get()));
        wall(ModBlocks.ENRICHED_RED_NETHER_BRICK_WALL.get(), ModBlocks.ENRICHED_RED_NETHER_BRICK.get());
        fence(ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE.get(), ModBlocks.ENRICHED_RED_NETHER_BRICK.get());
        fenceGate(ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE_GATE.get(), ModBlocks.ENRICHED_RED_NETHER_BRICK.get());

        stairs(ModBlocks.PACKED_ICE_STAIRS.get(), Blocks.PACKED_ICE);
        slabBlock(((SlabBlock) ModBlocks.PACKED_ICE_SLAB.get()), blockTexture(Blocks.PACKED_ICE), blockTexture(Blocks.PACKED_ICE));
        wall(ModBlocks.PACKED_ICE_WALL.get(), Blocks.PACKED_ICE);

        blockWithItem(ModBlocks.CHANNELLED_STONEBRICK);
        stairs(ModBlocks.CHANNELLED_STONEBRICK_STAIRS.get(), ModBlocks.CHANNELLED_STONEBRICK.get());
        slabBlock(((SlabBlock) ModBlocks.CHANNELLED_STONEBRICK_SLAB.get()), blockTexture(ModBlocks.CHANNELLED_STONEBRICK.get()), blockTexture(ModBlocks.CHANNELLED_STONEBRICK.get()));
        wall(ModBlocks.CHANNELLED_STONEBRICK_WALL.get(), ModBlocks.CHANNELLED_STONEBRICK.get());

        blockWithItem(ModBlocks.CHANNELLED_MOSSY_STONEBRICK);
        stairs(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_STAIRS.get(), ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get());
        slabBlock(((SlabBlock) ModBlocks.CHANNELLED_MOSSY_STONEBRICK_SLAB.get()), blockTexture(ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get()), blockTexture(ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get()));
        wall(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_WALL.get(), ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get());

        blockWithItem(ModBlocks.CHANNELLED_STONEBRICK_CARVED);
        stairs(ModBlocks.CHANNELLED_STONEBRICK_CARVED_STAIRS.get(), ModBlocks.CHANNELLED_STONEBRICK_CARVED.get());
        slabBlock(((SlabBlock) ModBlocks.CHANNELLED_STONEBRICK_CARVED_SLAB.get()), blockTexture(ModBlocks.CHANNELLED_STONEBRICK_CARVED.get()), blockTexture(ModBlocks.CHANNELLED_STONEBRICK_CARVED.get()));
        wall(ModBlocks.CHANNELLED_STONEBRICK_CARVED_WALL.get(), ModBlocks.CHANNELLED_STONEBRICK_CARVED.get());

        // Crops
        makeTomatoCrop((CropBlock) ModBlocks.TOMATO_CROP.get(), "tomato_stage_", "tomato_stage_");
        makeChilliCrop((CropBlock) ModBlocks.CHILLI_CROP.get(), "chilli_stage_", "chilli_stage_");
        makeLettuceCrop((CropBlock) ModBlocks.LETTUCE_CROP.get(), "lettuce_stage_", "lettuce_stage_");
        makeEmeraldEssenceCrop((CropBlock) ModBlocks.EMERALD_ESSENCE_CROP.get(), "emerald_essence_stage_", "emerald_essence_stage_");
        makeCornCrop(((CropBlock) ModBlocks.CORN_CROP.get()), "corn_stage_", "corn_stage_");
    }


    public void makeChilliCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> ChilliStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] ChilliStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CilliCropBlock) block).getAgeProperty()),
                new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + textureName + state.getValue(((CilliCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeTomatoCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> TomatoStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] TomatoStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeLettuceCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> lettuceStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] lettuceStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LettuceCropBlock) block).getAgeProperty()),
                new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + textureName + state.getValue(((LettuceCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeEmeraldEssenceCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> EmeraldEssenceStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] EmeraldEssenceStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((EmeraldEssenceCropBlock) block).getAgeProperty()),
                new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + textureName + state.getValue(((EmeraldEssenceCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
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
