package com.oneponygames.frozen.logic.events.lifecycle;

/**
 * Created by Icewind on 18.01.2017.
 */
public class ScreenRenderEvent implements LifecycleEvent {

    public final float delta;

    public ScreenRenderEvent(float delta) {
        this.delta = delta;
    }
}
