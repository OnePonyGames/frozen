package com.oneponygames.frozen.base.eventsystem.events.physics;

/**
 * Created by Icewind on 24.01.2017.
 */
public class PhysicsUpdateEvent implements PhysicsEvent {

    private final float delta;

    public PhysicsUpdateEvent(float delta) {
        this.delta = delta;
    }

    public float getDelta() {
        return delta;
    }
}
