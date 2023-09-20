package net.coderandom.etheriacraft.items.custom.base_items;

import net.coderandom.etheriacraft.util.ModTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;

public class HarvesterItem extends DiggerItem implements Vanishable {
    public HarvesterItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.MINEABLE_WITH_HARVESTER, pProperties);
    }
}
