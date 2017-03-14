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

    /**
     * Scales the input to a range of [0..1]
     * @param input
     * @param min
     * @param max
     * @return
     */
    public static double[] scale(double[] input, double min, double max) {
        double[] output = new double[input.length];
        double range = max - min;
        for(int i=0;i<input.length;i++)
            output[i] = (input[i] - min) / range;
        return output;
    }
}
