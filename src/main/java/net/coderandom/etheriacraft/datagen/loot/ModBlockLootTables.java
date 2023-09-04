package net.coderandom.etheriacraft.datagen.loot;

import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.coderandom.etheriacraft.items.custom.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SILVER_BLOCK.get());
        dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());
        dropSelf(ModBlocks.SILVER_BLOCK.get());
        dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.TOPAZ_BLOCK.get());
        dropSelf(ModBlocks.QUICK_SAND.get());

        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get(), 1.00F, 3.00F));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get(), 2.00F, 6.00F));
        this.add(ModBlocks.NETHER_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.NETHER_SILVER_ORE.get(), ModItems.SILVER_NUGGET.get(), 2.00F, 6.00F));
        this.add(ModBlocks.END_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.END_SILVER_ORE.get(), ModItems.SILVER_INGOT.get(), 1.00F, 2.00F));
        this.add(ModBlocks.END_GOLD_ORE.get(),
                block -> createOreDrops(ModBlocks.END_GOLD_ORE.get(), Items.GOLD_INGOT, 1.00F, 2.00F));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get(), 2.00F, 6.00F));
        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get(), 1.00F, 3.00F));
        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get(), 1.00F, 3.00F));
        this.add(ModBlocks.TOPAZ_ORE.get(),
                block -> createOreDrops(ModBlocks.TOPAZ_ORE.get(), ModItems.TOPAZ.get(), 1.00F, 3.00F));
    }

    protected LootTable.Builder createOreDrops(Block block, Item item, Float min, Float max) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
