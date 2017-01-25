package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 25.01.2017.
 */
public class VelocityComponent implements Component {

    public float x;
    public float y;

    public Vector2 getVelocityVector() {
        return new Vector2(x,y);
    }
}
