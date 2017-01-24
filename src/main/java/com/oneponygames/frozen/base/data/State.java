package com.oneponygames.frozen.base.data;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface State<T extends State> {

    public String getLabel();

    void setStateMachine(StateMachine<T> tStateMachine);
}
