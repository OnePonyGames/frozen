package com.oneponygames.frozen.base.eventsystem.events.sound;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 13.03.2017.
 */
public class PlaySoundEvent extends SoundEvent {

    public PlaySoundEvent(Entity entity, String soundId) {
        super(entity, soundId);
    }
}
