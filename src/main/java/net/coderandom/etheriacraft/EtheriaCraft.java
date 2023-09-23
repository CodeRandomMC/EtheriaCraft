/*
 * // This code and associated files are protected by the Creative Commons Attribution-NonCommercial-NoDerivatives (CC BY-NC-ND) 4.0 International License.
 * // You are not allowed to use this code or associated files for commercial purposes.
 * // You may not modify or create derivative works based on this code.
 * // Attribution must be given to the original author (DARKJ0K3R/CodeRandom Studios) if you use this code for non-commercial purposes.
 *
 * Copyright (c) 2023. All rights reserved.
 *
 * For more details about the license, please visit:
 * https://creativecommons.org/licenses/by-nc-nd/4.0/legalcode
 *
 */

package net.coderandom.etheriacraft;

import com.mojang.logging.LogUtils;
import net.coderandom.etheriacraft.entities.client.creatures.BisonRenderer;
import net.coderandom.etheriacraft.entities.client.creatures.BlackBearRenderer;
import net.coderandom.etheriacraft.entities.client.creatures.OstrichRenderer;
import net.coderandom.etheriacraft.init.*;
import net.coderandom.etheriacraft.init.itemsInit.ModArmor;
import net.coderandom.etheriacraft.init.itemsInit.ModFoods;
import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.coderandom.etheriacraft.init.itemsInit.ModTools;
import net.coderandom.etheriacraft.loot.ModLootModifiers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod(EtheriaCraft.MOD_ID)
public class EtheriaCraft {
    public static final String MOD_ID = "etheria_craft";
    public static final Logger LOGGER = LogUtils.getLogger();  // Logger for debugging and information

    public EtheriaCraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Initialize GeckoLib for animations
        GeckoLib.initialize();

        // Register mod content to the mod event bus
        ModItems.register(modEventBus);
        ModTools.register(modEventBus);
        ModFoods.register(modEventBus);
        ModArmor.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);

        // Register event listeners for common setup and client setup
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        // Register this mod with Minecraft Forge
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Method for common setup (server-side)
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Add any common setup code here if needed
    }

    // Method for client setup (client-side)
    private void clientSetup(final FMLCommonSetupEvent event) {
        // Register custom entity renderers for client rendering
        EntityRenderers.register(ModEntities.BLACK_BEAR.get(), BlackBearRenderer::new);
        EntityRenderers.register(ModEntities.BISON.get(), BisonRenderer::new);
        EntityRenderers.register(ModEntities.OSTRICH.get(), OstrichRenderer::new);
    }
}
