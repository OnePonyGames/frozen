package com.oneponygames.frozen.base.ashley.system;

import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class HookedIteratingSystem extends IteratingSystem {

    public HookedIteratingSystem(Family family) {
        super(family);
    }

    public HookedIteratingSystem(Family family, int priority) {
        super(family, priority);
    }

    @Override
    public void update(float deltaTime) {
        this.beforeUpdate(deltaTime);
        super.update(deltaTime);
        this.afterUpdate();
    }

    protected abstract void afterUpdate();

    protected abstract void beforeUpdate(float deltaTime);
}
