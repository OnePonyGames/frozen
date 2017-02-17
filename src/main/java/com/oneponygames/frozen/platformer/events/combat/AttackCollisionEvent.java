package com.oneponygames.frozen.platformer.events.combat;

import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.platformer.data.Attack;

/**
 * Created by Icewind on 17.02.2017.
 */
public class AttackCollisionEvent extends AttackEvent {

    private final Attack attack;

    public AttackCollisionEvent(Entity entity, Attack attack) {
        super(entity);
        this.attack = attack;
    }

    public Attack getAttack() {
        return attack;
    }
}
