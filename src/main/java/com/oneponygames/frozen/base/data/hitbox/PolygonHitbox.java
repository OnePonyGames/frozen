package com.oneponygames.frozen.base.data.hitbox;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 17.02.2017.
 */
public class PolygonHitbox extends BasicHitbox {

    private final Polygon poly;

    public PolygonHitbox(Polygon poly) {
        this.poly = poly;
    }

    @Override
    public Vector2 getCenter() {
        return new Vector2(poly.getX(), poly.getY());
    }

    @Override
    public final float getBoundingBoxWidth() {
        return this.poly.getBoundingRectangle().width;
    }

    @Override
    public final float getBoundingBoxHeight() {
        return this.poly.getBoundingRectangle().height;
    }

    @Override
    public final Polygon getHitboxArea() {
        this.setCenter(this.getCenter());
        return this.poly;
    }

    protected void setCenter(Vector2 center) {
        this.poly.setPosition(center.x, center.y);
    }
}
