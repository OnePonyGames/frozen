package com.oneponygames.frozen.platformer.events.movement;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;

/**
 * Created by Icewind on 16.02.2017.
 */
public class StopMoveLeftEvent extends MoveEntityEvent {

    public StopMoveLeftEvent(Entity entity) {
        super(entity, PositionComponent.ORIENTATION_LEFT);
    }
}
