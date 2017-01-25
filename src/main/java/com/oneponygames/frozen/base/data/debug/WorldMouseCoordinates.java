package com.oneponygames.frozen.base.data.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.eventsystem.subscriber.OrthoCameraController;

/**
 * Created by Icewind on 24.01.2017.
 */
public class WorldMouseCoordinates extends BasicDebugInfo {

    private final OrthoCameraController camera;

    public WorldMouseCoordinates(OrthoCameraController camera) {
        super("World");
        this.camera = camera;
    }

    @Override
    public String getValue() {
        Vector2 world = this.camera.screenToWorld(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
        return "X " + world.x + " - Y "+world.y;
    }
}
