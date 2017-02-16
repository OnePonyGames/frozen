package com.oneponygames.frozen.base.data.hitbox;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 25.01.2017.
 */
public interface Hitbox {

    public Vector2 getCenter();

    public float getBoundingBoxWidth();

    public float getBoundingBoxHeight();

    public float getCenterX();

    public float getCenterY();
}
