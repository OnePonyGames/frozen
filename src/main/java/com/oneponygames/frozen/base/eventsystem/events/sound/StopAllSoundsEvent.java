package com.oneponygames.frozen.base.eventsystem.events.sound;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.eventsystem.events.entity.EntityEvent;

/**
 * Created by Icewind on 13.03.2017.
 */
public class StopAllSoundsEvent extends EntityEvent {

    public StopAllSoundsEvent(Entity entity) {
        super(entity);
    }
}
