package net.coderandom.etheriacraft.items;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public  static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EtheriaCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_INGREDIENTS = CREATIVE_MODE_TABS.register("mod_ingredients_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("tab.mod_ingredients_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RAW_SILVER.get());
                        output.accept(ModItems.SILVER_INGOT.get());
                        output.accept(ModItems.SILVER_NUGGET.get());

                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.TOPAZ.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MOD_TOOLSANDUTILITIES = CREATIVE_MODE_TABS.register("mod_tools_and_utilities_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DIVING_ROD.get()))
                    .title(Component.translatable("tab.mod_tools_and_utilities_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.DIVING_ROD.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MOD_BLOCKS = CREATIVE_MODE_TABS.register("mod_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SAPPHIRE_ORE.get()))
                    .title(Component.translatable("tab.mod_blocks_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.SILVER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SILVER_ORE.get());
                        output.accept(ModBlocks.NETHER_SILVER_ORE.get());
                        output.accept(ModBlocks.END_SILVER_ORE.get());
                        output.accept(ModBlocks.END_GOLD_ORE.get());
                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.TOPAZ_ORE.get());

                        output.accept(ModBlocks.RAW_SILVER_BLOCK.get());
                        output.accept(ModBlocks.SILVER_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.TOPAZ_BLOCK.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MOD_COMBAT = CREATIVE_MODE_TABS.register("mod_combat_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DIVING_ROD.get()))
                    .title(Component.translatable("tab.mod_combat_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.DIVING_ROD.get());
                    })
                    .build());
//    public static final RegistryObject<CreativeModeTab> MOD_MISC = CREATIVE_MODE_TABS.register("mod_misc_tab",
//            () -> CreativeModeTab.builder()
//                    .icon(() -> new ItemStack(ModItems.DIVING_ROD.get()))
//                    .title(Component.translatable("tab.mod_misc_tab"))
//                    .displayItems((parameters, output) -> {
//                        output.accept(ModItems.DIVING_ROD.get());
//                    })
//                    .build());
//    public static final RegistryObject<CreativeModeTab> MOD_ARTIFACTS = CREATIVE_MODE_TABS.register("mod_artifacts_tab",
//            () -> CreativeModeTab.builder()
//                    .icon(() -> new ItemStack(ModItems.DIVING_ROD.get()))
//                    .title(Component.translatable("tab.mod_artifacts_tab"))
//                    .displayItems((parameters, output) -> {
//                        output.accept(ModItems.DIVING_ROD.get());
//                    })
//                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
