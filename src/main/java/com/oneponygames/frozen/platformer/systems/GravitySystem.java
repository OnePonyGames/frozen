package com.oneponygames.frozen.platformer.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalIteratingSystem;
import com.badlogic.ashley.systems.IteratingSystem;
import com.oneponygames.frozen.platformer.components.PhysicsComponent;
import com.oneponygames.frozen.platformer.components.VelocityComponent;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 25.01.2017.
 */
public class GravitySystem extends IteratingSystem {

    private float gravity;

    public GravitySystem(float gravity) {
        super(Family.all(VelocityComponent.class, PhysicsComponent.class).get());
        this.gravity = gravity;
    }

    public GravitySystem() {
        this(-10);
    }

    @Override
    protected void processEntity(Entity entity, float delta) {
        PhysicsComponent phys = BaseMappers.physicsMap.get(entity);
        VelocityComponent velocityMap = BaseMappers.velocityMap.get(entity);

        velocityMap.addY(this.gravity * phys.gravityPull * delta);
    }
}
