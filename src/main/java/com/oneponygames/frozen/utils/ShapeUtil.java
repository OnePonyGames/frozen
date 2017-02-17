package com.oneponygames.frozen.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;

/**
 * Created by Icewind on 30.11.2016.
 */
public final class ShapeUtil {
    private ShapeUtil() {
    }

    public static Polygon createPolygon(Rectangle bounds) {
        float[] corners = new float[8];
        corners[0] = bounds.x;
        corners[1] = bounds.y;
        corners[2] = bounds.x + bounds.width;
        corners[3] = bounds.y;
        corners[4] = bounds.x + bounds.width;
        corners[5] = bounds.y + bounds.height;
        corners[6] = bounds.x;
        corners[7] = bounds.y + bounds.height;

        return new Polygon(corners);
    }

    public static Polygon createPolygon(Vector2 dimensions) {
        return createPolygon(dimensions.x, dimensions.y);
    }

    public static Vector2 getLowerLeftCorner(Rectangle rect) {
        return new Vector2(rect.x, rect.y);
    }

    public static Vector2 getUpperRightCorner(Rectangle rect) {
        return new Vector2(rect.x + rect.width, rect.y + rect.height);
    }

    public static Polygon createPolygon(float width, float height) {
        return createPolygon(new Rectangle(- (width / 2f), -(height / 2f),  width, height));
    }
}
