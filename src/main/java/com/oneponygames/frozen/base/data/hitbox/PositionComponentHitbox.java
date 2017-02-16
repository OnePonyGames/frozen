package com.oneponygames.frozen.base.data.hitbox;

import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;

/**
 * Created by Icewind on 16.02.2017.
 */
public class PositionComponentHitbox extends AABBHitbox {

    private final PositionComponent pos;
    private final Vector2 offset;

    public PositionComponentHitbox(float width, float height, PositionComponent pos, Vector2 offset) {
        super(width, height);
        this.pos = pos;
        this.offset = offset;
    }

    @Override
    public Vector2 getCenter() {
        return pos.getPositionVector().add(this.offset.cpy().scl(pos.getOrientation(), 1));
    }
}
