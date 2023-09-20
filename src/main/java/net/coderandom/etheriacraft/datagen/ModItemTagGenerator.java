package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.coderandom.etheriacraft.init.itemsInit.ModTools;
import net.coderandom.etheriacraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, EtheriaCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ModTags.Items.TURTLE)
                .add(
                        ModItems.TURTLE_CHESTPLATE.get(),
                        ModItems.TURTLE_LEGGINGS.get(),
                        ModItems.TURTLE_BOOTS.get()
                );

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .addTag(ModTags.Items.TURTLE)
                .add(ModItems.VILLAGE_CHESTPLATE.get());

        this.tag(ItemTags.SWORDS)
                .add(ModTools.ETHERIAN_SWORD.get());

        this.tag(ItemTags.AXES)
                .add(ModTools.ETHERIAN_HARVESTER.get())
                .add(ModTools.ETHERIAN_AXE.get());

        this.tag(ItemTags.PICKAXES)
                .add(ModTools.ETHERIAN_EXCAVATOR.get())
                .add(ModTools.ETHERIAN_PICKAXE.get());

        this.tag(ItemTags.SHOVELS)
                .add(ModTools.ETHERIAN_EXCAVATOR.get())
                .add(ModTools.ETHERIAN_SHOVEL.get());

        this.tag(ItemTags.HOES)
                .add(ModTools.ETHERIAN_HARVESTER.get())
                .add(ModTools.ETHERIAN_HOE.get());
    }
}
