package com.oneponygames.frozen.ashley.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 23.01.2017.
 */
public class PositionComponent implements Component {

    private final Vector2 position;
    private float rotation;

    public PositionComponent(float x, float y) {
        this(new Vector2(x, y));
    }

    public PositionComponent(Vector2 position) {
        this(position, 0);
    }

    public PositionComponent(Vector2 position, float rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public float getX() {
        return this.position.x;
    }

    public float getY() {
        return this.position.y;
    }

    public Vector2 getPosition() {
        return position.cpy();
    }

    public float getRotation() {
        return rotation;
    }
}
