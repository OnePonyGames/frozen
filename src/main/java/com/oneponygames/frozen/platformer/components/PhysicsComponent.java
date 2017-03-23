package com.oneponygames.frozen.platformer.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

/**
 * Created by Icewind on 25.01.2017.
 */
public class PhysicsComponent implements Component, Pool.Poolable {

    public float gravityPull;

    public PhysicsComponent(float gravityPull) {
        this.gravityPull = gravityPull;
    }

    public PhysicsComponent() {
        this(1);
    }

    @Override
    public void reset() {
        this.gravityPull = 1;
    }
}
