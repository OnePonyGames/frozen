package com.oneponygames.frozen.base.eventsystem.events.sound;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.eventsystem.events.entity.EntityEvent;

/**
 * Created by Icewind on 13.03.2017.
 */
public class SoundEvent extends EntityEvent {

    private final String soundId;

    public SoundEvent(Entity entity, String soundTypeId) {
        super(entity);
        this.soundId = soundTypeId;
    }

    public String getSoundTypeId() {
        return soundId;
    }
}
