package com.oneponygames.frozen.utils;

import com.badlogic.ashley.core.EntitySystem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 13.02.2017.
 */
public class Accumulator<T extends EntitySystem> {

    private final Map<T, Float> entries = new HashMap<T, Float>();

    public void add(T s, Float value) {
        entries.put(s, entries.get(s) + value);
    }

    public void subtract(T s, Float value) {
        if(value == null)
            entries.put(s, 0f);
        else
            entries.put(s, entries.get(s) - value);
    }

    public void put(T system) {
        this.entries.put(system, 0f);
    }

    public Float get(T s) {
        return this.entries.get(s);
    }
}
