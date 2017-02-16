package com.oneponygames.frozen.utils;

import java.util.Comparator;

/**
 * Created by Icewind on 16.02.2017.
 */
public class ClassComparator implements Comparator<Class<?>> {

    @Override
    public int compare(Class<?> o1, Class<?> o2) {
        return o1.getCanonicalName().compareTo(o2.getCanonicalName());
    }
}
