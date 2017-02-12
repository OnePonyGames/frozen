package com.oneponygames.frozen.platformer.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 25.01.2017.
 */
public class VelocityComponent implements Component {

    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Vector2 getVelocityVector() {
        return new Vector2(x,y);
    }

    public void addY(float v) {
        this.y += v;
    }
}
