package com.oneponygames.frozen.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Icewind on 19.07.2016.
 */
public final class RandomUtil {

    private static final Random rand = new Random();

    private RandomUtil() {
    }

    public static int nextInt(int min, int max) {
        checkMinMax(min, max);
        return rand.nextInt(max - min + 1) + min;
    }

    public static boolean flipCoin() {
        return nextInt(0,1) == 0;
    }

    private static void checkMinMax(int min, int max) {
        if(min > max)
            throw new IllegalArgumentException("Max cannot be larger than min! "+min+" / "+max);
    }
    private static void checkMinMax(float min, float max) {
        if(min > max)
            throw new IllegalArgumentException("Max cannot be larger than min! "+min+" / "+max);
    }

    /**
     * Returns an integer from 0 to max inclusive.
     * @param max
     * @return
     */
    public static int nextInt(int max) {
        return RandomUtil.nextInt(0, max);
    }

    public static void setSeed(long seed) {
        rand.setSeed(seed);
    }

    public static double nextDouble() {
        return rand.nextDouble();
    }

    /**
     * Returns from the range of [from, to] (inclusive). "Number" amount of distinct integers.
     * @param from
     * @param to
     * @param number
     * @return
     */
    public static int[] distinctInts(int from, int to, int number) {
        if(from >= to)
            throw new IllegalArgumentException("From cannot be larget than to!");

        List<Integer> lst = new ArrayList<Integer>();
        for(int i=from; i<=to; i++)
            lst.add(i);

        Collections.shuffle(lst, rand);
        int[] ret = new int[number];
        for(int i=0;i<number;i++)
            ret[i] = lst.get(i);

        return ret;
    }

    public static <T> T randomEntry(T[] array) {
        int idx = nextInt(array.length-1);
        return array[idx];
    }

    public static <T> T randomEntry(List<T> list) {
        int idx = nextInt(list.size()-1);
        return list.get(idx);
    }

    public static float nextFloat(float min, float max) {
        checkMinMax(min, max);
        return rand.nextFloat() * (max - min) + min;
    }

    public static long nextLong() {
        return rand.nextLong();
    }

    public static List<Integer> createRandomSequence(int length, int times) {
        List<Integer> ret = new ArrayList<>(length * times);
        List<Integer> numbers = new ArrayList<>(length);
        for(int i=0;i<length;i++)
            numbers.add(i);

        for(int i=0;i<times;i++) {
            Collections.shuffle(numbers, rand);
            ret.addAll(numbers);
        }
        return ret;
    }
}
