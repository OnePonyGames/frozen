package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;
import com.oneponygames.frozen.base.data.state.CharacterState;
import com.oneponygames.frozen.base.data.state.StateChangeListener;
import com.oneponygames.frozen.base.data.state.StateMachine;
import com.oneponygames.frozen.base.data.timing.StateChangeResetTiming;
import com.oneponygames.frozen.base.data.timing.Timing;

import java.util.Collection;

/**
 * Created by Icewind on 16.02.2017.
 */
public class CharacterStateComponent<S extends CharacterState> implements Component, Pool.Poolable {

    private final StateMachine<S> stateMachine = new StateMachine<>();
    private StateChangeResetTiming activeStateTiming = new StateChangeResetTiming(this);

    public Timing getStateActiveTiming() {
        return activeStateTiming;
    }

    public StateMachine<S> getStateMachine() {
        return stateMachine;
    }

    @Override
    public void reset() {
        this.stateMachine.clear();
        this.stateMachine.addStateChangeListener(this.activeStateTiming);
        this.activeStateTiming.setTime(0);
    }
}
