package com.oneponygames.frozen.base.eventsystem.events.lifecycle;

/**
 * Created by Icewind on 18.01.2017.
 */
public class ScreenRenderEvent implements LifecycleEvent {

    private final float delta;

    public ScreenRenderEvent(float delta) {
        this.delta = delta;
    }

    public float getDelta() {
        return delta;
    }
}
