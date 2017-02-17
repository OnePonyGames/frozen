package com.oneponygames.frozen.platformer.events.movement;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.eventsystem.events.entity.EntityEvent;

/**
 * Created by Icewind on 17.02.2017.
 */
public class StopMoveEvent extends EntityEvent {

    public StopMoveEvent(Entity entity) {
        super(entity);
    }
}
