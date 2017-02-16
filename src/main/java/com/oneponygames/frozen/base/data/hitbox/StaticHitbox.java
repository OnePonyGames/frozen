package com.oneponygames.frozen.base.data.hitbox;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 16.02.2017.
 */
public class StaticHitbox extends AABBHitbox {

    private Vector2 center;

    public StaticHitbox(float width, float height, Vector2 center) {
        super(width, height);
        this.center = center;
    }

    @Override
    public Vector2 getCenter() {
        return this.center;
    }
}
