package com.oneponygames.frozen.ashley.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.oneponygames.frozen.eventsystem.events.EventSystem;
import com.oneponygames.frozen.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.eventsystem.subscriber.EventConsumer;
import com.oneponygames.frozen.eventsystem.subscriber.EventSubscriber;

/**
 * Created by Icewind on 18.01.2017.
 */
public class SampleRenderer implements EventSubscriber, EventConsumer<ScreenRenderEvent> {

    private final ShapeRenderer shapeRenderer;

    public SampleRenderer() {
        this.shapeRenderer = new ShapeRenderer();
        this.shapeRenderer.setAutoShapeType(true);
    }

    @Override
    public void subscribeTo(EventSystem system) {
        system.addConsumer(ScreenRenderEvent.class, this);
    }

    @Override
    public void event(ScreenRenderEvent event) {
        this.shapeRenderer.begin();
        this.shapeRenderer.setColor(Color.WHITE);
        this.shapeRenderer.rect(100, 100, 100, 100);
        this.shapeRenderer.end();
    }
}
