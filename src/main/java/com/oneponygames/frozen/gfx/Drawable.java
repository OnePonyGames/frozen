package com.oneponygames.frozen.gfx;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 23.01.2017.
 */
public interface Drawable {

    public TextureRegion getTexture();

    public Vector2 getPositionOffset();

    public boolean doDraw();

    public float getAlpha();

    public float getWidth();

    public float getHeight();

    public float getXOffset();

    public float getYOffset();

    public float getRotationOffset();
}
