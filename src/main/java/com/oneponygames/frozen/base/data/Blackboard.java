package com.oneponygames.frozen.base.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 13.03.2017.
 */
public class Blackboard {

    private final Map<String, Object> baseValueMap = new HashMap<>();

    public boolean contains(String id) {
        return this.baseValueMap.containsKey(id);
    }

    public <C> C get(String id, Class<C> floatClass) {
        return (C) this.baseValueMap.get(id);
    }

    public void put(String id, Object value) {
        this.baseValueMap.put(id, value);
    }
}
