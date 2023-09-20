package net.coderandom.etheriacraft.entities.custom.creatures;

import net.coderandom.etheriacraft.init.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
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

public class BisonEntity extends Animal implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public BisonEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.ATTACK_SPEED, 2.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 8)
                .add(Attributes.KNOCKBACK_RESISTANCE, 3)
                .add(Attributes.ATTACK_KNOCKBACK, 3)
                .build();
    }

    @Override
    protected void registerGoals() {
        // Priority 1: Basic necessities like floating in water
        this.goalSelector.addGoal(1, new FloatGoal(this));

        // Priority 2: Defend itself when hurt
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));

        // Priority 3: Avoid enemies
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 12.0F, 1.0D, 1.2D));

        // Priority 4: Attack when provoked
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));

        // Priority 5: Randomly look around
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        // Priority 6: Look at player if within a certain range
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 5.0F));

        // Priority 7: Follow other mobs
        this.goalSelector.addGoal(7, new FollowMobGoal(this, 1.0D, 10.0F, 5.0F));

        // Priority 8: Walk around randomly
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1.0D));

        // Targeting goals
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, BlackBearEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Wolf.class, true));
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel level, @NotNull AgeableMob otherParent) {
        return ModEntities.BISON.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::precicate));
    }

    private <T extends GeoAnimatable> PlayState precicate(AnimationState<T> state) {
        if (state.isMoving()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.bison.walk", Animation.LoopType.LOOP));
        } else {
            state.getController().setAnimation(RawAnimation.begin().then("animation.bison.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
