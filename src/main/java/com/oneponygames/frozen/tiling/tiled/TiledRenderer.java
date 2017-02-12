package com.oneponygames.frozen.tiling.tiled;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.oneponygames.frozen.base.eventsystem.subscriber.OrthoCameraController;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.tiling.tiled.event.TiledMapLoadedEvent;

/**
 * Created by Icewind on 25.01.2017.
 */
public class TiledRenderer implements EventSubscriber {

    private static final String ORTHOGONAL = "orthogonal";

    private final Batch batch;
    private final float unitScale;
    private final OrthoCameraController camera;
    private TiledMapRenderer renderer;
    private TiledMap map;

    public TiledRenderer(Batch batch, float unitScale, OrthoCameraController c) {
        this.batch = batch;
        this.unitScale = unitScale;
        this.camera = c;
    }

    public TiledRenderer(Batch batch, OrthoCameraController c) {
        this(batch, 1, c);
    }

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(TiledMapLoadedEvent.class, e->this.setMap(e.getMap()));

        system.addConsumer(ScreenRenderEvent.class, e->this.render());
    }

    private void render() {
        this.renderer.setView(this.camera.getCamera());
        this.renderer.render();
    }

    private void setMap(TiledMap newMap) {
        if(newMap.getProperties().get("orientation").equals(ORTHOGONAL)) {
            this.renderer = new OrthogonalTiledMapRenderer(newMap, this.unitScale, this.batch);
        } else {
            this.renderer = new IsometricTiledMapRenderer(newMap, this.unitScale, this.batch);
        }

        this.map = newMap;
    }
}
