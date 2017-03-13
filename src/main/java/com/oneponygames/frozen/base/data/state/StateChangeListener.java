package com.oneponygames.frozen.base.data.state;

/**
 * Created by Icewind on 16.02.2017.
 */
public interface StateChangeListener<T extends State> {

    public void notifyStateChange(T oldState, T newState);
}
