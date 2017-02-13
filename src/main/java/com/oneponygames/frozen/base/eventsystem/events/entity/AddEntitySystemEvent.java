package com.oneponygames.frozen.base.eventsystem.events.entity;

import com.badlogic.ashley.core.EntitySystem;

/**
 * Created by Icewind on 23.01.2017.
 */
public class AddEntitySystemEvent extends EntitySystemEvent {

    private Float interval;

    public AddEntitySystemEvent(EntitySystem system, Float interval) {
        super(system);
        this.interval = interval;
    }

    public Float getInterval() {
        return interval;
    }
}
