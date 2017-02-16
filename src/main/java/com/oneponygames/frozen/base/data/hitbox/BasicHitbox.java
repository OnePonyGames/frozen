package com.oneponygames.frozen.base.data.hitbox;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class BasicHitbox implements Hitbox {

    @Override
    public final float getCenterX() {
        return this.getCenter().x;
    }

    @Override
    public final float getCenterY() {
        return this.getCenter().y;
    }
}
