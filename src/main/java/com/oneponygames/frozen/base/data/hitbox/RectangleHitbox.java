package com.oneponygames.frozen.base.data.hitbox;


import com.oneponygames.frozen.utils.ShapeUtil;

/**
 * Created by Icewind on 12.02.2017.
 */
public abstract class RectangleHitbox extends PolygonHitbox {

    public RectangleHitbox(float width, float height) {
        super(ShapeUtil.createPolygon(width, height));
    }
}
