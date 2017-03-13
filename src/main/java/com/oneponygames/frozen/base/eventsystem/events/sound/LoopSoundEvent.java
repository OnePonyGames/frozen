package com.oneponygames.frozen.base.eventsystem.events.sound;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 13.03.2017.
 */
public class LoopSoundEvent extends SoundEvent {

    public LoopSoundEvent(Entity entity, String soundTypeId) {
        super(entity, soundTypeId);
    }
}
