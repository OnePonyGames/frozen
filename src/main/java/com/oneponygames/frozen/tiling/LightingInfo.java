package com.oneponygames.frozen.tiling;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 14.03.2017.
 */
public class LightingInfo {

    public enum TYPE {
        POINT, CONE, FIRE;

        public static TYPE forString(String name) {
            for(TYPE t : values()) {
                if(t.toString().toLowerCase().equals(name))
                    return t;
            }
            throw new RuntimeException("No enum value for: "+name);
        }
    }

    private final float radius;
    private final Color color;
    private final Vector2 direction;
    private final float angle;
    private final TYPE type;

    public LightingInfo(float radius, Color color, TYPE type) {
        this(radius, color, null, 0, type);
    }

    public LightingInfo(float radius, Color color, Vector2 direction, float angle, TYPE type) {
        this.radius = radius;
        this.color = color;
        this.direction = direction;
        this.angle = angle;
        this.type = type;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public float getAngle() {
        return angle;
    }

    public TYPE getType() {
        return type;
    }

    public float getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }
}
