package com.oneponygames.frozen.base.data.hitbox;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 16.02.2017.
 */
public class StaticHitbox extends RectangleHitbox {

    public StaticHitbox(float width, float height, Vector2 center) {
        super(width, height);
        this.setCenter(center);
    }
}
