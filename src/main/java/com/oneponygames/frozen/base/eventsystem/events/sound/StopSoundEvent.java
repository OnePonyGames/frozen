package com.oneponygames.frozen.base.eventsystem.events.sound;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 13.03.2017.
 */
public class StopSoundEvent extends SoundEvent {

    public StopSoundEvent(Entity entity, String soundId) {
        super(entity, soundId);
    }
}
