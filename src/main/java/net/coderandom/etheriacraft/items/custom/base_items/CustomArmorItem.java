package net.coderandom.etheriacraft.items.custom.base_items;

import com.google.common.collect.ImmutableMap;
import net.coderandom.etheriacraft.init.itemsInit.ModArmor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.Map;

public class CustomArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            ImmutableMap.of(
                    ArmorMaterials.TURTLE, new MobEffectInstance(MobEffects.NIGHT_VISION, 0, 0, false, false, true),
                    ArmorMaterials.GOLD, new MobEffectInstance(MobEffects.DIG_SPEED, 0, 0, false, false, true)
            );

    public CustomArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (isSpecificMaterial(ArmorMaterials.TURTLE, stack) && !player.isUnderWater()) {
                return;
            }

            ArmorMaterial fullSetMaterial = hasFullArmorSet(player);
            if (fullSetMaterial != null) {
                applyArmorSetEffects(player, fullSetMaterial);
            }

            applyIndividualArmorEffects(stack, player);
        }
    }

    private void applyIndividualArmorEffects(ItemStack stack, Player player) {
        // You can add other armor-effect pairings here
        applyEffectIfItemMatches(stack, player, ModArmor.TURTLE_CHESTPLATE.get(), MobEffects.DIG_SPEED);
        applyEffectIfItemMatches(stack, player, ModArmor.TURTLE_LEGGINGS.get(), MobEffects.DAMAGE_RESISTANCE);
        applyEffectIfItemMatches(stack, player, ModArmor.TURTLE_BOOTS.get(), MobEffects.DOLPHINS_GRACE);
        applyEffectIfItemMatches(stack, player, ModArmor.VILLAGE_CHESTPLATE.get(), MobEffects.HERO_OF_THE_VILLAGE);
    }

    private void applyEffectIfItemMatches(ItemStack stack, Player player, Item specificItem, MobEffect effect) {
        if (stack.getItem() == specificItem && !player.hasEffect(effect)) {
            player.addEffect(new MobEffectInstance(effect, 0, 0, false, false, true));
        }
    }

    private void applyArmorSetEffects(Player player, ArmorMaterial material) {
        if (MATERIAL_TO_EFFECT_MAP.containsKey(material) && !player.hasEffect(MATERIAL_TO_EFFECT_MAP.get(material).getEffect())) {
            player.addEffect(MATERIAL_TO_EFFECT_MAP.get(material));
        }
    }

    private ArmorMaterial hasFullArmorSet(Player player) {
        ArmorMaterial material = null;
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return null;
            }

            ArmorMaterial currentMaterial = ((ArmorItem) armorStack.getItem()).getMaterial();
            if (material == null) {
                material = currentMaterial;
            } else if (material != currentMaterial) {
                return null;
            }
        }
        return material;
    }

    private boolean isSpecificMaterial(ArmorMaterial material, ItemStack stack) {
        return stack.getItem() instanceof ArmorItem && ((ArmorItem) stack.getItem()).getMaterial() == material;
    }
}
