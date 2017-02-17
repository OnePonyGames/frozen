package com.oneponygames.frozen.base.data.timing;

import com.oneponygames.frozen.base.ashley.component.CharacterStateComponent;
import com.oneponygames.frozen.base.data.state.State;
import com.oneponygames.frozen.base.data.state.StateChangeListener;

/**
 * Created by Icewind on 16.02.2017.
 */
public class StateChangeResetTiming extends BasicTiming implements StateChangeListener {

    public StateChangeResetTiming(CharacterStateComponent stateComponent) {
        stateComponent.getStateMachine().addStateChangeListener(this);
    }

    @Override
    public void notifyOfNewState(State newState) {
        this.setTime(0);
    }
}
