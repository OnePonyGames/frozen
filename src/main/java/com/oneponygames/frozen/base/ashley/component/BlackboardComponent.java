package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;
import com.oneponygames.frozen.base.data.Blackboard;

/**
 * Created by Icewind on 13.03.2017.
 */
public class BlackboardComponent implements Component, Pool.Poolable {

    private final Blackboard blackboard;

    public BlackboardComponent() {
        this.blackboard = new Blackboard();
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }

    public <C> C get(String id, Class<C> aClass) {
        return this.blackboard.get(id, aClass);
    }

    public void put(String id, Object value) {
        this.blackboard.put(id, value);
    }

    @Override
    public void reset() {
        this.blackboard.clear();
    }
}
