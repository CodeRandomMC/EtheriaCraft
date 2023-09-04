package net.coderandom.etheriacraft.util;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ORES_SILVER = tagKey("ores_silver");
        public static final TagKey<Block> ORES_METAL = tagKey("ores_metal");
        public static final TagKey<Block> ORES_GEM = tagKey("ores_gem");


        private static TagKey<Block> tagKey(String key) {
            return BlockTags.create(new ResourceLocation(EtheriaCraft.MOD_ID, key));
        }
    }
    public static class Items {


        private static TagKey<Item> tagKey(String key) {
            return ItemTags.create(new ResourceLocation(EtheriaCraft.MOD_ID, key));
        }
    }
}
