package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.coderandom.etheriacraft.items.custom.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EtheriaCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_SILVER);
        simpleItem(ModItems.SILVER_INGOT);
        simpleItem(ModItems.SILVER_NUGGET);

        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.TOPAZ);

        simpleItem(ModItems.METAL_DOWSING_ROD);
        simpleItem(ModItems.GEM_DOWSING_ROD);

        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.CHILLI);

        simpleItem(ModItems.BLANK_SCROLL);
        simpleItem(ModItems.COMBUSTION_SCROLL);

        evenSimplerBlockItem(ModBlocks.MOSSY_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.MOSSY_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.MOSSY_BRICK_PRESSURE_PLATE);
        wallItem(ModBlocks.MOSSY_BRICK_WALL, ModBlocks.MOSSY_BRICK);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> itemRegistryObject) {
        return withExistingParent(itemRegistryObject.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EtheriaCraft.MOD_ID, "item/" +itemRegistryObject.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EtheriaCraft.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(EtheriaCraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
