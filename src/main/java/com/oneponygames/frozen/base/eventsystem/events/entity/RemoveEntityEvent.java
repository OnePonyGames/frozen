package com.oneponygames.frozen.base.eventsystem.events.entity;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 23.01.2017.
 */
public class RemoveEntityEvent extends EntityEvent {

    public RemoveEntityEvent(Entity entity) {
        super(entity);
    }
}
