package com.oneponygames.frozen.ashley.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
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
public class EntityRenderer extends BasicEntitySubscriber {

    private final SpriteBatch batch;
    private final Camera camera;

    public EntityRenderer(SpriteBatch batch, Camera camera) {
        this.batch = batch;
        this.camera = camera;
    }

    @Override
    public EntitySystem getEntitySystem() {
        return new HookedIteratingSystem(Family.all(DrawableComponent.class, PositionComponent.class).get()) {
            @Override
            protected void afterUpdate() {
                batch.end();
            }

            @Override
            protected void beforeUpdate() {
                Gdx.gl.glClearColor(0, 0, 0.2f, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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

                        System.out.println(x + " x; " + y );

                        batch.draw(d.getTexture(), dx * 2, dy * 2, originX * 2, originY * 2, width * 2, height * 2, 1, 1, rotation);
                    }
                }
            }
        };
    }
}
