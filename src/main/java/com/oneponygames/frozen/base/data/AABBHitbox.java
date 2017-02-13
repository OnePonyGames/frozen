package com.oneponygames.frozen.base.data;


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
    public float getBoundingBoxWidth() {
        return this.width;
    }

    @Override
    public float getBoundingBoxHeight() {
        return this.height;
    }
}
