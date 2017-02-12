package com.oneponygames.frozen.platformer.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by Icewind on 25.01.2017.
 */
public class PhysicsComponent implements Component {

    public float gravityPull;

    public PhysicsComponent(float gravityPull) {
        this.gravityPull = gravityPull;
    }

    public PhysicsComponent() {
        this(1);
    }
}
