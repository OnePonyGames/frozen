package com.oneponygames.frozen.data.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Icewind on 24.01.2017.
 */
public class WorldMouseCoordinates extends BasicDebugInfo {

    private final Camera camera;

    public WorldMouseCoordinates(Camera camera) {
        super("World");
        this.camera = camera;
    }

    @Override
    public String getValue() {
        Vector3 world = this.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        return "X " + world.x + " - Y "+world.y;
    }
}
