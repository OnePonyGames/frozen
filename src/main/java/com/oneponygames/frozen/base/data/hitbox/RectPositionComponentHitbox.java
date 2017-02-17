package com.oneponygames.frozen.base.data.hitbox;

import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;

/**
 * Created by Icewind on 16.02.2017.
 */
public class RectPositionComponentHitbox extends RectangleHitbox {

    private final PositionComponent pos;
    private Vector2 offset;

    public RectPositionComponentHitbox(float width, float height, PositionComponent pos) {
        this(width, height, pos, new Vector2(0,0));
    }

    public RectPositionComponentHitbox(float width, float height, PositionComponent pos, Vector2 offset) {
        super(width, height);
        this.pos = pos;
        this.offset = offset;
    }

    public void setOffset(Vector2 offset) {
        this.offset = offset;
    }

    @Override
    public Vector2 getCenter() {
        this.setCenter(pos.getPositionVector().add(this.offset.cpy().scl(pos.getOrientation(), 1)));
        return super.getCenter();
    }
}
