package com.oneponygames.frozen.platformer.events.combat;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.eventsystem.events.entity.EntityEvent;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class AttackEvent extends EntityEvent {

    public AttackEvent(Entity entity) {
        super(entity);
    }
}
