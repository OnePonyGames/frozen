package com.oneponygames.frozen.base.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 23.01.2017.
 */
public class TextureDrawable extends BasicDrawable {

    private final TextureRegion region;
    private final Vector2 positionOffset;
    private final float rotationOffset;

    public TextureDrawable(Texture texture) {
        this(new TextureRegion(texture), new Vector2(0,0), 0);
    }

    public TextureDrawable(TextureRegion region, Vector2 positionOffset, float rotationOffset) {
        this.region = region;
        this.positionOffset = positionOffset;
        this.rotationOffset = rotationOffset;
    }

    @Override
    public TextureRegion getTexture() {
        return this.region;
    }

    @Override
    public Vector2 getPositionOffset() {
        return this.positionOffset.cpy();
    }

    @Override
    public float getRotationOffset() {
        return this.rotationOffset;
    }
}
