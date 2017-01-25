package com.oneponygames.frozen.utils;

import com.badlogic.ashley.core.ComponentMapper;
import com.oneponygames.frozen.base.ashley.component.DrawableComponent;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;
import com.oneponygames.frozen.base.ashley.component.VelocityComponent;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class BaseMappers {

    public static final ComponentMapper<PositionComponent> positionMap = ComponentMapper.getFor(PositionComponent.class);
    public static final ComponentMapper<DrawableComponent> drawableMap = ComponentMapper.getFor(DrawableComponent.class);
    public static final ComponentMapper<VelocityComponent> velocityMap = ComponentMapper.getFor(VelocityComponent.class);

    private BaseMappers() {}
}
