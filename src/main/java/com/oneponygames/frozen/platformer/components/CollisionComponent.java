package com.oneponygames.frozen.platformer.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

/**
 * Created by Icewind on 25.01.2017.
 */
public class CollisionComponent implements Component, Pool.Poolable {

    public boolean contactLeft;
    public boolean contactRight;
    public boolean contactBottom;
    public boolean contactTop;

    @Override
    public void reset() {
        this.contactBottom = contactLeft = contactRight = contactTop = false;
    }
}
