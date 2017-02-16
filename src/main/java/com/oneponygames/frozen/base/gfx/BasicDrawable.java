package com.oneponygames.frozen.base.gfx;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class BasicDrawable implements Drawable {

    private final float height;
    private final float width;

    public BasicDrawable(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public final float getWidth() {
        return this.width;
    }

    @Override
    public final float getHeight() {
        return this.height;
    }

    @Override
    public final float getXOffset() {
        return this.getPositionOffset().x;
    }

    @Override
    public final float getYOffset() {
        return this.getPositionOffset().y;
    }

    @Override
    public boolean doDraw() {
        return true;
    }

    @Override
    public float getAlpha() {
        return 1;
    }

}
