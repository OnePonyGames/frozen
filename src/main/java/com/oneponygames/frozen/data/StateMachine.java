package com.oneponygames.frozen.data;

import com.badlogic.gdx.Screen;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Icewind on 18.01.2017.
 */
public class StateMachine<T extends State> {

    private Deque<T> stateStack = new LinkedList<T>();
    private final Map<String, T> labelStateMap = new HashMap<String, T>();

    public void addState(T state) {
        this.labelStateMap.put(state.getLabel(), state);
        state.setStateMachine(this);
    }

    public void pushState(T nextState) {
        if(this.hasState())
            this.peekCurrentState().afterStateInactive();
        this.stateStack.addFirst(nextState);
        this.peekCurrentState().beforeStateActive();
    }

    public T peekCurrentState() {
        return stateStack.peekFirst();
    }

    public void popCurrentState() {
        T e = this.stateStack.removeFirst();
        e.afterStateInactive();
        this.peekCurrentState().beforeStateActive();
    }

    public void transition(T nextState) {
        this.popCurrentState();
        this.pushState(nextState);
    }

    public String getActiveStateLabel() {
        if(this.hasState())
            return this.peekCurrentState().getLabel();
        return null;
    }

    private boolean hasState() {
        return this.stateStack.size() > 0;
    }

    public void pushStateByLabel(String label) {
        this.pushState(this.getStateByLabel(label));
    }

    private T getStateByLabel(String label) {
        if(this.labelStateMap.containsKey(label))
            return this.labelStateMap.get(label);

        throw new IllegalArgumentException("No state of label '"+label+"' found, available are: "+this.labelStateMap.keySet());
    }
}
