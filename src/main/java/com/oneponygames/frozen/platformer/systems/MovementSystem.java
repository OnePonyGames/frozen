package com.oneponygames.frozen.platformer.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalIteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;
import com.oneponygames.frozen.platformer.components.VelocityComponent;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 25.01.2017.
 */
public class MovementSystem extends IntervalIteratingSystem {

    public MovementSystem(float interval) {
        super(Family.all(VelocityComponent.class, PositionComponent.class).get(), interval);
    }

    @Override
    protected void processEntity(Entity entity) {
        VelocityComponent velo = BaseMappers.velocityMap.get(entity);
        Vector2 vv = velo.getVelocityVector();

        if(vv.len()>0) {
            PositionComponent pos = BaseMappers.positionMap.get(entity);
            pos.move(vv.scl(this.getInterval()));
        }
    }
}
