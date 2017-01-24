package com.oneponygames.frozen.ashley.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.oneponygames.frozen.ashley.component.DrawableComponent;
import com.oneponygames.frozen.ashley.component.PositionComponent;
import com.oneponygames.frozen.gfx.Drawable;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 23.01.2017.
 */
public class EntityRenderer extends HookedIteratingSystem {

    private final SpriteBatch batch;
    private final Camera camera;
    private final int pixelScaling;

    public EntityRenderer(SpriteBatch batch, Camera camera) {
        this(batch, camera, 1);
    }

    public EntityRenderer(SpriteBatch batch, Camera camera, int pixelScaling) {
        super(Family.all(DrawableComponent.class, PositionComponent.class).get());
        this.batch = batch;
        this.camera = camera;
        this.pixelScaling = pixelScaling;
    }

    @Override
    protected void afterUpdate() {
        batch.end();
    }

    @Override
    protected void beforeUpdate() {
        batch.begin();
    }

    @Override
    protected void processEntity(Entity entity, float delta) {
        PositionComponent pos = BaseMappers.positionMap.get(entity);
        DrawableComponent draw = BaseMappers.drawableMap.get(entity);

        batch.setProjectionMatrix(camera.combined);

        for(Drawable d : draw.getDrawables()) {
            if(d.doDraw()) {
                batch.setColor(1, 1, 1, d.getAlpha());
                float width = d.getWidth();
                float height = d.getHeight();
                float x = pos.getX() + d.getXOffset();
                float y = pos.getY() + d.getYOffset();
                float dx = x - width / 2f;
                float dy = y - height / 2f;
                float originX = -d.getXOffset() + width/2;
                float originY = -d.getYOffset() + height/2;
                float rotation = pos.getRotation() + d.getRotationOffset();

                batch.draw(d.getTexture(), dx * pixelScaling, dy * pixelScaling, originX * pixelScaling, originY * pixelScaling, width * pixelScaling, height * pixelScaling, 1, 1, rotation);
            }
        }
    }
}
