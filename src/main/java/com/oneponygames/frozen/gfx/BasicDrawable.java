package com.oneponygames.frozen.gfx;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class BasicDrawable implements Drawable {

    @Override
    public final float getWidth() {
        return this.getTexture().getRegionWidth();
    }

    @Override
    public final float getHeight() {
        return this.getTexture().getRegionHeight();
    }

    @Override
    public final float getXOffset() {
        return this.getPositionOffset().x;
    }

    @Override
    public final float getYOffset() {
        return this.getPositionOffset().y;
    }
}
