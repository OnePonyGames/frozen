package com.oneponygames.frozen.base.data.state;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface State<T extends State> {

    public String getLabel();

    public void setStateMachine(StateMachine<T> tStateMachine);

    public void setActive(boolean active);

    public boolean isActivatable();
}
