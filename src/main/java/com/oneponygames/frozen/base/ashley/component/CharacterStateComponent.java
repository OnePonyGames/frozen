package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.oneponygames.frozen.base.data.state.CharacterState;
import com.oneponygames.frozen.base.data.state.StateChangeListener;
import com.oneponygames.frozen.base.data.state.StateMachine;
import com.oneponygames.frozen.base.data.timing.StateChangeResetTiming;
import com.oneponygames.frozen.base.data.timing.Timing;

import java.util.Collection;

/**
 * Created by Icewind on 16.02.2017.
 */
public class CharacterStateComponent implements Component {

    private final StateMachine<CharacterState> stateMachine = new StateMachine<>();
    private Timing activeStateTiming = new StateChangeResetTiming(this);

    public Timing getStateActiveTiming() {
        return activeStateTiming;
    }

    public void addState(CharacterState state) {
        this.stateMachine.addState(state);
    }

    public void pushState(CharacterState state) {
        this.stateMachine.pushState(state);
    }

    public void popCurrentState() {
        this.stateMachine.popCurrentState();
    }

    public void transition(CharacterState state) {
        this.stateMachine.transition(state);
    }

    public CharacterState peekCurrentState() {
        return this.stateMachine.peekCurrentState();
    }

    public void insertState(CharacterState state, int positionFromTop) {
        this.stateMachine.insertState(state, positionFromTop);
    }

    public void removeFromStack(CharacterState state) {
        this.stateMachine.removeFromStack(state);
    }

    public void addStateChangeListener(StateChangeListener listener) {
        this.stateMachine.addStateChangeListener(listener);
    }

    public Collection<CharacterState> getStateStack() {
        return this.stateMachine.getStateStack();
    }
}
