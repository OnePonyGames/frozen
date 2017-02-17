package com.oneponygames.frozen.base.data.state;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 17.02.2017.
 */
public abstract class EntityState<T extends State> extends BasicState<T> {

    private final Entity entity;

    public EntityState(String label, Entity entity) {
        super(label);
        this.entity = entity;
    }

    protected final Entity getEntity() {
        return entity;
    }
}
