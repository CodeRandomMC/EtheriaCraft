package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
