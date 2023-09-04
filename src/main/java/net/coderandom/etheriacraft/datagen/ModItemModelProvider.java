package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.items.custom.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> itemRegistryObject) {
        return withExistingParent(itemRegistryObject.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EtheriaCraft.MOD_ID, "item/" +itemRegistryObject.getId().getPath()));
    }
}
