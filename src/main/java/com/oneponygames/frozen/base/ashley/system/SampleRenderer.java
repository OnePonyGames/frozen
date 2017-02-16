package com.oneponygames.frozen.base.ashley.system;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.base.eventsystem.EventConsumer;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;

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
    public void subscribeTo(EventService system) {
        system.addConsumer(this, ScreenRenderEvent.class);
    }

    @Override
    public void event(ScreenRenderEvent event) {
        this.shapeRenderer.begin();
        this.shapeRenderer.setColor(Color.WHITE);
        this.shapeRenderer.rect(100, 100, 100, 100);
        this.shapeRenderer.end();
    }
}
