package net.coderandom.etheriacraft.util;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * Utility class for defining custom tags for blocks and items in EtheriaCraft mod.
 */
public class ModTags {

    /**
     * Nested class for defining custom block tags.
     */
    public static class Blocks {
        // Define custom block tags
        public static final TagKey<Block> END_ORES = tagKey("ores_end");
        public static final TagKey<Block> ORES_SILVER = tagKey("ores_silver");
        public static final TagKey<Block> ORES_METAL = tagKey("ores_metal");
        public static final TagKey<Block> ORES_GEM = tagKey("ores_gem");

        public static final TagKey<Block> MOSSY_BRICK = tagKey("mossy_brick");
        public static final TagKey<Block> GILDED_BLACKSTONE_BRICK = tagKey("gilded_blackstone_brick");
        public static final TagKey<Block> INFUSED_END_STONE_BRICK = tagKey("infused_end_stone_brick");
        public static final TagKey<Block> ENRICHED_NETHER_BRICK = tagKey("enriched_nether_brick");
        public static final TagKey<Block> PACKED_ICE = tagKey("packed_ice");
        public static final TagKey<Block> CHANNELLED_STONEBRICK = tagKey("channelled_stonebrick");

        // Define custom block tags for tools
        public static final TagKey<Block> MINEABLE_WITH_EXCAVATOR = tagKey("mineable/mineable_with_excavator");
        public static final TagKey<Block> MINEABLE_WITH_HARVESTER = tagKey("mineable/mineable_with_harvester");

        public static final TagKey<Block> NEEDS_ENDERITE_TOOL = tagKey("needs_enderite_tool");
        public static final TagKey<Block> NEEDS_ETHERIAN_TOOL = tagKey("needs_etherian_tool");

        public static final TagKey<Block> STRIPPABLE_LOGS = tagKey("strippable_logs");

        /**
         * Utility method to create a TagKey for blocks.
         *
         * @param key The tag name.
         * @return A TagKey object.
         */
        private static TagKey<Block> tagKey(String key) {
            return BlockTags.create(new ResourceLocation(EtheriaCraft.MOD_ID, key));
        }
    }

    /**
     * Nested class for defining custom item tags.
     */
    public static class Items {
        // Define custom item tags
        public static final TagKey<Item> TURTLE = tagKey("turtle");
        public static final TagKey<Item> ETHERIAN = tagKey("etherian");

        /**
         * Utility method to create a TagKey for items.
         *
         * @param key The tag name.
         * @return A TagKey object.
         */
        private static TagKey<Item> tagKey(String key) {
            return ItemTags.create(new ResourceLocation(EtheriaCraft.MOD_ID, key));
        }
    }
}
