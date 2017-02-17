package com.oneponygames.frozen.platformer.events.movement;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;

/**
 * Created by Icewind on 17.02.2017.
 */
public class DodgeLeftEvent extends MoveEntityEvent {

    public DodgeLeftEvent(Entity entity) {
        super(entity, PositionComponent.ORIENTATION_LEFT);
    }
}
