package net.coderandom.etheriacraft.entities.custom.creatures;

import net.coderandom.etheriacraft.init.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class OstrichEntity extends Animal implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public OstrichEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 12)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.ATTACK_SPEED, 3.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 8)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .build();
    }

    @Override
    protected void registerGoals() {
        // Priority 1: Basic necessities like floating in water
        this.goalSelector.addGoal(1, new FloatGoal(this));

        // Priority 2: Run away when panicked
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.5)); // Ostriches are fast runners

        // Priority 3: Avoid natural enemies
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 15.0F, 1.5D, 2.0D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, BlackBearEntity.class, 12.0F, 1.5D, 2.0D));

        // Priority 4: Randomly look around
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        // Priority 5: Look at player if within a certain range but do not attack
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));

        // Priority 6: Walk around randomly
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0D));

        // Priority 7: Follow other ostriches or friendly mobs
        this.goalSelector.addGoal(7, new FollowMobGoal(this, 1.0D, 10.0F, 5.0F));

        // Targeting goals
        // React when hurt but do not proactively attack
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel level, @NotNull AgeableMob otherParent) {
        return ModEntities.OSTRICH.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::precicate));
    }

    private <T extends GeoAnimatable> PlayState precicate(AnimationState<T> state) {
        // Play walk animation if mob is moving
        if (state.isMoving()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.ostrich.walk", Animation.LoopType.LOOP));
        } else {
            state.getController().setAnimation(RawAnimation.begin().then("animation.ostrich.idle", Animation.LoopType.LOOP));
        }
        // Play attack animation if mob is attacking
//        if (this.isAggressive() && this.getTarget() != null) {
//            state.getController().setAnimation(RawAnimation.begin().then("animation.ostrich.attack", Animation.LoopType.PLAY_ONCE));
//        }

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
