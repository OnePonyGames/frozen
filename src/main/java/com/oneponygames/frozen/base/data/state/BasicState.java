package com.oneponygames.frozen.base.data.state;

/**
 * Created by Icewind on 17.02.2017.
 */
public abstract class BasicState<T extends State> implements State<T> {

    private final String label;
    private StateMachine<T> stateMachine;

    public BasicState(String label) {
        this.label = label;
    }

    protected final StateMachine<T> getStateMachine() {
        return stateMachine;
    }

    @Override
    public final String getLabel() {
        return this.label;
    }

    @Override
    public final void setStateMachine(StateMachine<T> tStateMachine) {
        this.stateMachine = tStateMachine;
    }
}
