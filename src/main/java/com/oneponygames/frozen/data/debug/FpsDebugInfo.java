package com.oneponygames.frozen.data.debug;

import com.badlogic.gdx.Gdx;

/**
 * Created by Icewind on 24.01.2017.
 */
public class FpsDebugInfo extends BasicDebugInfo {

    public FpsDebugInfo() {
        super("FPS");
    }

    @Override
    public String getValue() {
        return ""+Gdx.graphics.getFramesPerSecond();
    }
}
