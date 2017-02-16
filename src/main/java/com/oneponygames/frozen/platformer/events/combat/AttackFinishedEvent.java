package com.oneponygames.frozen.platformer.events.combat;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 16.02.2017.
 */
public class AttackFinishedEvent extends AttackEvent {

    public AttackFinishedEvent(Entity attacker) {
        super(attacker);
    }
}
