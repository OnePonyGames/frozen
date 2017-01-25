package com.oneponygames.frozen.base.eventsystem.events.input;

/**
 * Created by Icewind on 25.01.2017.
 */
public class MouseMovedEvent implements InputEvent {

    private final float x;
    private final float y;

    public MouseMovedEvent(float x, float y) {
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
