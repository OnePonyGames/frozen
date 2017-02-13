package com.oneponygames.frozen.platformer.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalIteratingSystem;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;
import com.oneponygames.frozen.platformer.components.CollisionComponent;
import com.oneponygames.frozen.platformer.components.VelocityComponent;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 25.01.2017.
 */
public class MovementSystem extends IteratingSystem {

    public MovementSystem() {
        super(Family.all(VelocityComponent.class, CollisionComponent.class, PositionComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float delta) {
        VelocityComponent velo = BaseMappers.velocityMap.get(entity);
        Vector2 vv = velo.getVelocityVector();

        if(vv.len()>0) {
            PositionComponent pos = BaseMappers.positionMap.get(entity);
            CollisionComponent col = BaseMappers.collisionMap.get(entity);

            if(col.contactBottom && vv.y < 0) {
                vv.y = 0;
                velo.setY(0);
            }
            if(col.contactTop && vv.y > 0) {
                vv.y = 0;
                velo.setY(-0.1f);
            }
            if(col.contactLeft)
                vv.x = Math.max(0, vv.x);
            if(col.contactRight)
                vv.x = Math.min(0, vv.x);

            vv.x *= delta;
            vv.y *= delta;

            pos.move(vv);
        }
    }
}
