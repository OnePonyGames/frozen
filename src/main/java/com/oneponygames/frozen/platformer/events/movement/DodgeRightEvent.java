package com.oneponygames.frozen.platformer.events.movement;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;

/**
 * Created by Icewind on 17.02.2017.
 */
public class DodgeRightEvent extends MoveEntityEvent {

    public DodgeRightEvent(Entity entity) {
        super(entity, PositionComponent.ORIENTATION_RIGHT);
    }
}
