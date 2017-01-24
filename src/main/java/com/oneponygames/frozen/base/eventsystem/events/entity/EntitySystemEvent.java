package com.oneponygames.frozen.base.eventsystem.events.entity;

import com.badlogic.ashley.core.EntitySystem;
import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class EntitySystemEvent implements GameEvent {

    private final EntitySystem system;

    public EntitySystemEvent(EntitySystem system) {
        this.system = system;
    }

    public EntitySystem getSystem() {
        return system;
    }
}
