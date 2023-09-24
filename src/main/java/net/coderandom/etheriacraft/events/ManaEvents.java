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

package net.coderandom.etheriacraft.events;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.capabilities.PlayerManaProvider;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EtheriaCraft.MOD_ID)
public class ManaEvents {
    // Tick counter to update manaRegen every 200 ticks
    private static int tickCounter = 0;

    @SubscribeEvent
    public static void manaRegenEvent(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER && event.phase == TickEvent.Phase.END) {
            // Only update mana once every 100 ticks
            if (tickCounter >= 100) {
                event.player.getCapability(PlayerManaProvider.PLAYER_MANA).orElseThrow(
                        () -> new IllegalArgumentException("LazyOptional must not be empty!")
                ).tick(event.player);
                // Reset the tick counter
                tickCounter = 0;
            } else {
                // Increment the tick counter
                tickCounter++;
            }
        }
    }

    @SubscribeEvent
    public static void onRightClick(BlockEvent.BreakEvent event) {
        if (event.getPlayer() != null) {
            event.getPlayer().getCapability(PlayerManaProvider.PLAYER_MANA).orElseThrow(
                    () -> new IllegalArgumentException("LazyOptional must not be empty!")
            ).blockBreakEvent(event.getPlayer());
        }
    }
}
