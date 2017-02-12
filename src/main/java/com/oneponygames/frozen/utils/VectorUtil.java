package com.oneponygames.frozen.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.data.Line;

import java.util.List;

/**
 * Created by Icewind on 10.02.2016.
 */
public class VectorUtil {

    private VectorUtil() {}

    public static Vector2 fromAngle(float angle) {
        float theta = MathUtils.degreesToRadians * angle;
        return new Vector2((float)Math.sin(theta), (float)Math.cos(theta));
    }

    public static Vector2 rotate(Vector2 v, float angle) {
        float theta = MathUtils.degreesToRadians * angle;
        return new Vector2((float) (v.x * Math.cos(theta) - v.y * Math.sin(theta)), (float) (v.x * Math.sin(theta) + v.y * Math.cos(theta)));
    }

    public static float getAngleBetween180(Vector2 v1, Vector2 v2) {
        return (float) (MathUtils.radiansToDegrees * Math.acos(v1.nor().dot(v2.nor())));
    }

    public static float getAngleBetween360(Vector2 v1, Vector2 v2) {
        float dot = v1.dot(v2);
        float det = v1.x * v2.y - v1.y * v2.x;
        return (360.0f - (float) (MathUtils.radiansToDegrees * Math.atan2(det, dot))) % 360.0f;
    }

    public static float getDistance(Vector2 from, Vector2 to) {
        return new Vector2(to).sub(from).len();
    }

    public static float getDistance(Line line, Vector2 point) {
        double x0 = point.x;
        double y0 = point.y;
        double x1 = line.getFrom().x;
        double y1 = line.getFrom().y;
        double x2 = line.getTo().x;
        double y2 = line.getTo().y;

        float dividend = (float) Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2*y1 - y2*x1);
        float divisor = (float) Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        return dividend / divisor;
    }

    public static float calculatePathLength(List<Vector2> path) {
        float length = 0;

        for(int i=0;i<path.size()-1;i++) {
            length += getDistance(path.get(i), path.get(i+1));
        }
        return length;
    }
}
