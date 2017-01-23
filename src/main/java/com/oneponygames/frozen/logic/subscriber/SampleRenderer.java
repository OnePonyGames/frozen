package com.oneponygames.frozen.logic.subscriber;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.oneponygames.frozen.logic.events.EventSystem;
import com.oneponygames.frozen.logic.events.lifecycle.ScreenRenderEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public class SampleRenderer implements EventSubscriber<ScreenRenderEvent> {

    private final ShapeRenderer shapeRenderer;

    public SampleRenderer() {
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setAutoShapeType(true);
    }

    public void subscribeTo(EventSystem system) {
        system.addSubscriber(ScreenRenderEvent.class, this);
    }

    @Override
    public void event(ScreenRenderEvent event) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.shapeRenderer.begin();
        this.shapeRenderer.setColor(Color.WHITE);
        this.shapeRenderer.rect(100, 100, 100, 100);
        this.shapeRenderer.end();
    }
}
