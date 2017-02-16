package com.oneponygames.frozen.base.data.timing;

/**
 * Created by Icewind on 21.01.2017.
 */
public class BasicTiming implements Timing {

    private float accumulator = 0;

    @Override
    public void addTime(float delta) {
        this.accumulator += delta;
    }

    @Override
    public final float getTime() {
        return accumulator;
    }

    protected void setTime(float time) {
        this.accumulator = time;
    }
}
