package com.oneponygames.frozen.tiling;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Icewind on 12.02.2017.
 */
public interface Tile {

    public int getX();

    public int getY();

    public boolean isSolid();

    public Vector2 getWorldCenter();

    public boolean isLight();

    public LightingInfo getLightingInfo();

    float getWorldX();

    float getWorldY();
}
