package com.oneponygames.frozen.base.ashley.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;
import com.oneponygames.frozen.base.data.hitbox.Hitbox;
import com.oneponygames.frozen.base.eventsystem.subscriber.OrthoCameraController;
import com.oneponygames.frozen.platformer.components.AttackComponent;
import com.oneponygames.frozen.platformer.data.Attack;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 17.02.2017.
 */
public class AttackHitboxRenderer extends HookedIteratingSystem {

    private final ShapeRenderer shape;
    private final OrthoCameraController camera;
    private final Matrix4 scaleMatrix;

    public AttackHitboxRenderer(ShapeRenderer shape, OrthoCameraController camera, float scaling) {
        super(Family.all(AttackComponent.class, PositionComponent.class).get());

        this.camera = camera;
        this.shape = shape;
        this.scaleMatrix = new Matrix4();
        this.scaleMatrix.scl(scaling);
    }

    @Override
    protected void afterUpdate() {
        this.shape.end();
    }

    @Override
    protected void beforeUpdate() {
        this.shape.setAutoShapeType(true);
        this.shape.begin();
        this.shape.setProjectionMatrix(camera.getCombined());
        this.shape.setTransformMatrix(this.scaleMatrix);
        this.shape.setColor(Color.CHARTREUSE);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        AttackComponent att = BaseMappers.attackMap.get(entity);

        if(att.hasActiveAttack()) {
            Attack a = att.getActiveAttack();

            if(a.isLive()) {
                Hitbox hb = a.getHitbox();

                this.shape.polygon(hb.getHitboxArea().getTransformedVertices());
            }
        }
    }
}
