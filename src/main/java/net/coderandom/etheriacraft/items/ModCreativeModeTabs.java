package net.coderandom.etheriacraft.items;

import net.coderandom.etheriacraft.EtheriaCraft;
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

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
