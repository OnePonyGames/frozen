package com.oneponygames.frozen.base.data;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 25.01.2017.
 */
public class Line {

    private final Vector2 from;
    private final Vector2 to;

    public Line(Vector2 from, Vector2 to) {
        this.from = from;
        this.to = to;
    }

    public Line(float x1, float y1, float x2, float y2) {
        this(new Vector2(x1, y1), new Vector2(x2, y2));
    }

    public Vector2 getFrom() {
        return from;
    }

    public Vector2 getTo() {
        return to;
    }

    public boolean isHorizontal() {
        return from.x == to.x;
    }

    public boolean isVertical() {
        return from.y == to.y;
    }
}
