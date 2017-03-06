package com.oneponygames.frozen.base.data.stats;

/**
 * Created by Icewind on 06.03.2017.
 */
public abstract class BasicStatModifier implements StatModifier {

    private String stat;

    public BasicStatModifier(String stat) {
        this.stat = stat;
    }

    @Override
    public final String getModifiedStat() {
        return this.stat;
    }
}
