package com.oneponygames.frozen.utils;

/**
 * Created by Icewind on 20.06.2016.
 */
public final class MathUtils {

    private MathUtils() {
    }

    public static int roundDownToNearestK(float v, int k){
        return (int) (Math.floor(v / k) * k);
    }

    public static int roundToNearestK(float v, int k){
        return (int) (Math.round(v / k) * k);
    }
}
