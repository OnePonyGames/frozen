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

    public StateMachine<CharacterState> getStateMachine() {
        return stateMachine;
    }
}
