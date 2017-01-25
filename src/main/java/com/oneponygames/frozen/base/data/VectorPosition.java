package com.oneponygames.frozen.base.data;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 24.01.2017.
 */
public class VectorPosition implements Position {

    private final Vector2 position;
    private float rotation;

    public VectorPosition(float x, float y) {
        this(new Vector2(x, y), 0);
    }

    public VectorPosition(Vector2 position, float rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    @Override
    public float getX() {
        return this.position.x;
    }

    @Override
    public float getY() {
        return this.position.y;
    }

    @Override
    public Vector2 getPositionVector() {
        return this.position.cpy();
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    @Override
    public void move(Vector2 movement) {
        this.position.add(movement);
    }
}
