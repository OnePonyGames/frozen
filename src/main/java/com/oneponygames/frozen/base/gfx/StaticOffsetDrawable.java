package com.oneponygames.frozen.base.gfx;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class StaticOffsetDrawable extends BasicDrawable {

    private final float rotOffset;
    private final Vector2 posOffset;

    public StaticOffsetDrawable(float rotOffset, Vector2 posOffset, float width, float height) {
        super(width, height);
        this.rotOffset = rotOffset;
        this.posOffset = posOffset;
    }

    @Override
    public final Vector2 getPositionOffset() {
        return this.posOffset;
    }

    @Override
    public final float getRotationOffset() {
        return this.rotOffset;
    }
}
