package com.oneponygames.frozen.base.eventsystem.events.entity;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class EntityEvent implements GameEvent {

    private final Entity entity;

    public EntityEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return this.entity;
    }
}
