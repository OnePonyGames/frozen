package com.oneponygames.frozen.platformer.events.combat;

/**
 * Created by Icewind on 07.03.2017.
 */
public class FixedDamage implements SimpleDamage {

    private final float damage;

    public FixedDamage(float damage) {
        this.damage = damage;
    }

    @Override
    public float calculateDamage() {
        return this.damage;
    }
}
