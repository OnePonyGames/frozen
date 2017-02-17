package com.oneponygames.frozen.base.eventsystem.events.lifecycle;

/**
 * Created by Icewind on 18.01.2017.
 */
public class ScreenRenderEvent implements LifecycleEvent {

    private final float delta;
    private final float totalTime;

    public ScreenRenderEvent(float delta, float totalTime) {
        this.delta = delta;
        this.totalTime = totalTime;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public float getDelta() {
        return delta;
    }
}
