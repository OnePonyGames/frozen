package com.oneponygames.frozen.base.data.debug;

/**
 * Created by Icewind on 24.01.2017.
 */
public abstract class BasicDebugInfo implements DebugInfo {

    private final String label;

    public BasicDebugInfo(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
