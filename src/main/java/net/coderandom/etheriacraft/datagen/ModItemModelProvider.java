package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.init.ModBlocks;
import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.coderandom.etheriacraft.init.itemsInit.ModTools;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();

    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EtheriaCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Ingots & Gems
        simpleItem(ModItems.RAW_SILVER);
        simpleItem(ModItems.SILVER_INGOT);
        simpleItem(ModItems.SILVER_NUGGET);

        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.TOPAZ);

        simpleItem(ModItems.ENDERITE_SCRAP);
        simpleItem(ModItems.ENDERITE_INGOT);
        simpleItem(ModItems.ETHERIAN_SCRAP);
        simpleItem(ModItems.ETHERIAN_INGOT);

        //Tools and Weapons
        handHeldItem(ModTools.GEM_DOWSING_ROD);
        handHeldItem(ModTools.METAL_DOWSING_ROD);
        handHeldItem(ModTools.ETHERIAN_SWORD);
        handHeldItem(ModTools.ETHERIAN_AXE);
        handHeldItem(ModTools.ETHERIAN_PICKAXE);
        handHeldItem(ModTools.ETHERIAN_SHOVEL);
        handHeldItem(ModTools.ETHERIAN_HOE);
        handHeldItem(ModTools.ETHERIAN_EXCAVATOR);
        handHeldItem(ModTools.ETHERIAN_HARVESTER);

        // Essence
        simpleItem(ModItems.EMERALD_ESSENCE);

        // Food
        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.CHILLI);
        simpleItem(ModItems.LETTUCE);
        simpleItem(ModItems.CORN);

        // Seeds
        simpleItem(ModItems.CHILLI_SEEDS);
        simpleItem(ModItems.TOMATO_SEEDS);
        simpleItem(ModItems.LETTUCE_SEEDS);
        simpleItem(ModItems.CORN_SEEDS);
        simpleItem(ModItems.EMERALD_ESSENCE_SEEDS);

        // Scrolls
        simpleItem(ModItems.BLANK_SCROLL);
        simpleItem(ModItems.COMBUSTION_SCROLL);

        // Armor
        trimmedArmorItem(ModItems.TURTLE_CHESTPLATE);
        trimmedArmorItem(ModItems.TURTLE_LEGGINGS);
        trimmedArmorItem(ModItems.TURTLE_BOOTS);
        trimmedArmorItem(ModItems.VILLAGE_CHESTPLATE);

        //Spawn Eggs
        withExistingParent(ModItems.BLACK_BEAR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.BISON_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.OSTRICH_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        // Decoration Blocks
        simpleBlockItem(ModBlocks.MOSSY_BRICK_STAIRS);
        simpleBlockItem(ModBlocks.MOSSY_BRICK_SLAB);
        simpleBlockItem(ModBlocks.MOSSY_BRICK_PRESSURE_PLATE);
        wallItem(ModBlocks.MOSSY_BRICK_WALL, ModBlocks.MOSSY_BRICK);

        simpleBlockItem(ModBlocks.GILDED_BLACKSTONE_BRICK_STAIRS);
        simpleBlockItem(ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB);
        wallItem(ModBlocks.GILDED_BLACKSTONE_BRICK_WALL, ModBlocks.GILDED_BLACKSTONE_BRICK);

        simpleBlockItem(ModBlocks.INFUSED_END_BRICK_STAIRS);
        simpleBlockItem(ModBlocks.INFUSED_END_BRICK_SLAB);
        wallItem(ModBlocks.INFUSED_END_BRICK_WALL, ModBlocks.INFUSED_END_BRICK);

        simpleBlockItem(ModBlocks.ENRICHED_NETHER_BRICK_STAIRS);
        simpleBlockItem(ModBlocks.ENRICHED_NETHER_BRICK_SLAB);
        wallItem(ModBlocks.ENRICHED_NETHER_BRICK_WALL, ModBlocks.ENRICHED_NETHER_BRICK);
        fenceItem(ModBlocks.ENRICHED_NETHER_BRICK_FENCE, ModBlocks.ENRICHED_NETHER_BRICK);
        simpleBlockItem(ModBlocks.ENRICHED_NETHER_BRICK_FENCE_GATE);

        simpleBlockItem(ModBlocks.ENRICHED_RED_NETHER_BRICK_STAIRS);
        simpleBlockItem(ModBlocks.ENRICHED_RED_NETHER_BRICK_SLAB);
        wallItem(ModBlocks.ENRICHED_RED_NETHER_BRICK_WALL, ModBlocks.ENRICHED_RED_NETHER_BRICK);
        fenceItem(ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE, ModBlocks.ENRICHED_RED_NETHER_BRICK);
        simpleBlockItem(ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE_GATE);

        simpleBlockItem(ModBlocks.PACKED_ICE_STAIRS);
        simpleBlockItem(ModBlocks.PACKED_ICE_SLAB);
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(ModBlocks.PACKED_ICE_WALL.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation("minecraft", "block/" + ForgeRegistries.BLOCKS.getKey(Blocks.PACKED_ICE).getPath()));

        simpleBlockItem(ModBlocks.CHANNELLED_STONEBRICK_STAIRS);
        simpleBlockItem(ModBlocks.CHANNELLED_STONEBRICK_SLAB);
        wallItem(ModBlocks.CHANNELLED_STONEBRICK_WALL, ModBlocks.CHANNELLED_STONEBRICK);

        simpleBlockItem(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_STAIRS);
        simpleBlockItem(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_SLAB);
        wallItem(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_WALL, ModBlocks.CHANNELLED_MOSSY_STONEBRICK);

        simpleBlockItem(ModBlocks.CHANNELLED_STONEBRICK_CARVED_STAIRS);
        simpleBlockItem(ModBlocks.CHANNELLED_STONEBRICK_CARVED_SLAB);
        wallItem(ModBlocks.CHANNELLED_STONEBRICK_CARVED_WALL, ModBlocks.CHANNELLED_STONEBRICK_CARVED);

    }

    private ItemModelBuilder handHeldItem(RegistryObject<Item> itemRegistryObject) {
        return withExistingParent(itemRegistryObject.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(EtheriaCraft.MOD_ID, "item/" + itemRegistryObject.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> itemRegistryObject) {
        return withExistingParent(itemRegistryObject.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EtheriaCraft.MOD_ID, "item/" + itemRegistryObject.getId().getPath()));
    }

    public void simpleBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(EtheriaCraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(EtheriaCraft.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = EtheriaCraft.MOD_ID; // Change this to your mod id

        if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
