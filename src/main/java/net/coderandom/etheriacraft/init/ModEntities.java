package net.coderandom.etheriacraft.init;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.entities.custom.creatures.BisonEntity;
import net.coderandom.etheriacraft.entities.custom.creatures.BlackBearEntity;
import net.coderandom.etheriacraft.entities.custom.creatures.OstrichEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EtheriaCraft.MOD_ID);

    public static final RegistryObject<EntityType<BlackBearEntity>> BLACK_BEAR =
            ENTITY_TYPES.register("black_bear",
                    () -> EntityType.Builder.of(BlackBearEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.8f)
                            .build(new ResourceLocation(EtheriaCraft.MOD_ID, "black_bear").toString()));

    public static final RegistryObject<EntityType<BisonEntity>> BISON =
            ENTITY_TYPES.register("bison",
                    () -> EntityType.Builder.of(BisonEntity::new, MobCategory.CREATURE)
                            .sized(1.3f, 1.3f)
                            .build(new ResourceLocation(EtheriaCraft.MOD_ID, "bison").toString()));

    public static final RegistryObject<EntityType<OstrichEntity>> OSTRICH =
            ENTITY_TYPES.register("ostrich",
                    () -> EntityType.Builder.of(OstrichEntity::new, MobCategory.CREATURE)
                            .sized(1.3f, 2.8f)
                            .build(new ResourceLocation(EtheriaCraft.MOD_ID, "ostrich").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
