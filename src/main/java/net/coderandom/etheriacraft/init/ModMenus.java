package net.coderandom.etheriacraft.init;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.client.gui.InfusionTableMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, EtheriaCraft.MOD_ID);
    public static final RegistryObject<MenuType<InfusionTableMenu>> INFUSION_TABLE_GUI =
            MENUS.register("infusion_table_gui", () -> IForgeMenuType.create(InfusionTableMenu::new));


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
