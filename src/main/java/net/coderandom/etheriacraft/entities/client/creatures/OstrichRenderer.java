package net.coderandom.etheriacraft.entities.client.creatures;

import com.mojang.blaze3d.vertex.PoseStack;
import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.entities.custom.creatures.OstrichEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Random;

public class OstrichRenderer extends GeoEntityRenderer<OstrichEntity> {
    public OstrichRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OstrichModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull OstrichEntity animatable) {
        return new ResourceLocation(EtheriaCraft.MOD_ID, "textures/entity/ostrich.png");
    }

    @Override
    public void render(OstrichEntity entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {

        if (entity.isBaby()) {
            Random random = new Random(entity.getId()); // Use entity ID as seed for consistent scaling
            float randomBabyScale = 0.2f + (0.5f - 0.2f) * random.nextFloat(); // Random scale for baby
            poseStack.scale(randomBabyScale, randomBabyScale, randomBabyScale);
        } else {
            Random random = new Random(entity.getId()); // Use entity ID as seed for consistent scaling
            float randomAdultScale = 0.7f + (0.8f - 0.7f) * random.nextFloat(); // Random scale for adult
            poseStack.scale(randomAdultScale, randomAdultScale, randomAdultScale);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
