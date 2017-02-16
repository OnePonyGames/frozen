package com.oneponygames.frozen.base.eventsystem.events.input;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class MouseEvent implements InputEvent {

    private final float x;
    private final float y;

    public MouseEvent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
