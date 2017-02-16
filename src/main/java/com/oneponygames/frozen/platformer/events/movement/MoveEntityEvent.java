package com.oneponygames.frozen.platformer.events.movement;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.eventsystem.events.GameEvent;
import com.oneponygames.frozen.base.eventsystem.events.entity.EntityEvent;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class MoveEntityEvent extends EntityEvent {

    private final int orientation;

    public MoveEntityEvent(Entity entity, int orientation) {
        super(entity);
        this.orientation = orientation;
    }

    public int getOrientation() {
        return orientation;
    }
}
