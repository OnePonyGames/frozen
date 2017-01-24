package com.oneponygames.frozen.base.eventsystem.events.entity;

import com.badlogic.ashley.core.EntitySystem;

/**
 * Created by Icewind on 23.01.2017.
 */
public class RemoveEntitySystemEvent  extends EntitySystemEvent {

    public RemoveEntitySystemEvent(EntitySystem system) {
        super(system);
    }
}
