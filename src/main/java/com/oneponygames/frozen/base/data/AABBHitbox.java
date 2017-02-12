package com.oneponygames.frozen.base.data;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 12.02.2017.
 */
public class AABBHitbox implements Hitbox {

    private final float height;
    private final float width;

    public AABBHitbox(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }
}
