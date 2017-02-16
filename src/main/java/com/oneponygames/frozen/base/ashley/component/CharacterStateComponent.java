package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.oneponygames.frozen.base.data.state.CharacterState;
import com.oneponygames.frozen.base.data.state.StateChangeListener;
import com.oneponygames.frozen.base.data.state.StateMachine;

/**
 * Created by Icewind on 16.02.2017.
 */
public class CharacterStateComponent implements Component {

    private final StateMachine<CharacterState> stateMachine = new StateMachine<>();

    public void addState(CharacterState state) {
        this.stateMachine.addState(state);
    }

    public void pushState(CharacterState state) {
        this.stateMachine.pushState(state);
    }

    public void popCurrentState() {
        this.stateMachine.popCurrentState();
    }

    public CharacterState peekCurrentState() {
        return this.stateMachine.peekCurrentState();
    }

    public void addStateChangeListener(StateChangeListener listener) {
        this.stateMachine.addStateChangeListener(listener);
    }
}
