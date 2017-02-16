package com.oneponygames.frozen.platformer.events.movement;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class StopMoveEvent extends MoveEntityEvent {

    public StopMoveEvent(Entity entity, int orientation) {
        super(entity, orientation);
    }
}
