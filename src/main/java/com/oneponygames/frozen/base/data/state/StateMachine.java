package com.oneponygames.frozen.base.data.state;

import com.google.common.collect.ImmutableList;

import java.util.*;

/**
 * Created by Icewind on 18.01.2017.
 */
public class StateMachine<T extends State> {

    private LinkedList<T> stateStack = new LinkedList<T>();
    private final Map<String, T> labelStateMap = new HashMap<String, T>();
    private final List<StateChangeListener<T>> listeners = new ArrayList<>();

    public void addState(T state) {
        this.labelStateMap.put(state.getLabel(), state);
        state.setStateMachine(this);
    }

    public void pushState(T nextState) {
        if(!this.hasState() || !this.peekCurrentState().equals(nextState)) {
            if(this.hasState())
                this.peekCurrentState().setActive(false);
            this.stateStack.addFirst(nextState);
            nextState.setActive(true);
            this.notifyListenersNewState(nextState);
        }
    }

    public T peekCurrentState() {
        return stateStack.peekFirst();
    }

    public void popCurrentState() {
        this.popCurrentState(true);
    }

    private void popCurrentState(boolean notifyListeners) {
        this.peekCurrentState().setActive(false);
        this.stateStack.removeFirst();

        if(notifyListeners) {
            this.peekCurrentState().setActive(true);
            this.notifyListenersNewState(this.peekCurrentState());
        }
    }

    private void notifyListenersNewState(T newState) {
        for(StateChangeListener<T> lst : this.listeners)
            lst.notifyOfNewState(newState);
    }

    public void transition(T nextState) {
        this.popCurrentState(false);
        this.pushState(nextState);
    }

    public String getActiveStateLabel() {
        if(this.hasState())
            return this.peekCurrentState().getLabel();
        return null;
    }

    public void removeFromStack(T state) {
        if(state.equals(this.peekCurrentState()))
            this.popCurrentState();
        else
            this.stateStack.remove(state);
    }

    public void addStateChangeListener(StateChangeListener<T> lst) {
        this.listeners.add(lst);
    }

    private boolean hasState() {
        return this.stateStack.size() > 0;
    }

    public void pushStateByLabel(String label) {
        this.pushState(this.getStateByLabel(label));
    }

    public void transitionByLabel(String label) {
        T state = this.getStateByLabel(label);
        this.transition(state);
    }

    public T getStateByLabel(String label) {
        if(this.labelStateMap.containsKey(label))
            return this.labelStateMap.get(label);

        throw new IllegalArgumentException("No state of label '"+label+"' found, available are: "+this.labelStateMap.keySet());
    }

    public void removeFromStackByLabel(String label) {
        T state = this.getStateByLabel(label);
        this.removeFromStack(state);
    }

    public void insertState(T state, int positionFromTop) {
        this.stateStack.add(positionFromTop, state);
    }

    public void insertStateByLabel(String label, int posFromTop) {
        T state = this.getStateByLabel(label);
        this.insertState(state, posFromTop);
    }

    public Collection<T> getStateStack() {
        return ImmutableList.copyOf(this.stateStack);
    }
}
