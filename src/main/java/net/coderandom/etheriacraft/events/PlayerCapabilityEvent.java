package net.coderandom.etheriacraft.events;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.capabilities.PlayerMana;
import net.coderandom.etheriacraft.capabilities.PlayerManaProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EtheriaCraft.MOD_ID)
public class PlayerCapabilityEvent {
    // Subscribe to the AttachCapabilitiesEvent to attach player mana capabilities
    @SubscribeEvent
    public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            // Attach the PlayerManaProvider to the player entity
            event.addCapability(new ResourceLocation(EtheriaCraft.MOD_ID, "properties"), new PlayerManaProvider());
        }
    }

    // Subscribe to the PlayerEvent.Clone event to handle player cloning
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            // Copy the mana from the original player to the cloned player
            event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(sourceMana ->
                    event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(targetMana ->
                            targetMana.copyMana(sourceMana)
                    )
            );
        }
    }

    // Subscribe to the RegisterCapabilitiesEvent to register the PlayerMana capability
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        // Register the PlayerMana capability class
        event.register(PlayerMana.class);
    }
}
