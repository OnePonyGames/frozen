package com.oneponygames.frozen.data.debug;

import com.badlogic.gdx.Gdx;

/**
 * Created by Icewind on 24.01.2017.
 */
public class ScreenMouseCoordinates extends BasicDebugInfo {

    public ScreenMouseCoordinates() {
        super("Screen");
    }

    @Override
    public String getValue() {
        return "X " + Gdx.input.getX() + " - Y "+Gdx.input.getY();
    }
}
