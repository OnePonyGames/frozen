package com.oneponygames.frozen.base.data.stats;

/**
 * Created by Icewind on 06.03.2017.
 */
public class StatNotDefinedException extends RuntimeException {

    public StatNotDefinedException(String stat) {
        super("No stat with name: "+stat+" defined!");
    }
}
