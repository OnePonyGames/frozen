package com.oneponygames.frozen.utils;

import com.badlogic.ashley.core.ComponentMapper;
import com.oneponygames.frozen.base.ashley.component.*;
import com.oneponygames.frozen.platformer.components.CollisionComponent;
import com.oneponygames.frozen.platformer.components.PhysicsComponent;
import com.oneponygames.frozen.platformer.components.VelocityComponent;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class BaseMappers {

    public static final ComponentMapper<PositionComponent> positionMap = ComponentMapper.getFor(PositionComponent.class);
    public static final ComponentMapper<DrawableComponent> drawableMap = ComponentMapper.getFor(DrawableComponent.class);
    public static final ComponentMapper<VelocityComponent> velocityMap = ComponentMapper.getFor(VelocityComponent.class);
    public static final ComponentMapper<PhysicsComponent> physicsMap = ComponentMapper.getFor(PhysicsComponent.class);
    public static final ComponentMapper<HitBoxComponent> hitboxMap = ComponentMapper.getFor(HitBoxComponent.class);
    public static final ComponentMapper<CollisionComponent> collisionMap = ComponentMapper.getFor(CollisionComponent.class);

    private BaseMappers() {}
}
