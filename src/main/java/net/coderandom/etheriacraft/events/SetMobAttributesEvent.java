package net.coderandom.etheriacraft.events;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.entities.custom.creatures.BisonEntity;
import net.coderandom.etheriacraft.entities.custom.creatures.BlackBearEntity;
import net.coderandom.etheriacraft.entities.custom.creatures.OstrichEntity;
import net.coderandom.etheriacraft.init.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EtheriaCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetMobAttributesEvent {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent createAttributeEvent) {
        createAttributeEvent.put(ModEntities.BLACK_BEAR.get(), BlackBearEntity.setAttributes());
        createAttributeEvent.put(ModEntities.BISON.get(), BisonEntity.setAttributes());
        createAttributeEvent.put(ModEntities.OSTRICH.get(), OstrichEntity.setAttributes());
    }
}
