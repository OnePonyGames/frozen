package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;
import com.oneponygames.frozen.base.data.state.AiState;
import com.oneponygames.frozen.base.data.state.StateMachine;

/**
 * Created by Icewind on 17.02.2017.
 */
public class AiStateComponent implements Component, Pool.Poolable {

    private final StateMachine<AiState> stateMachine = new StateMachine<>();

    public StateMachine<AiState> getStateMachine() {
        return stateMachine;
    }

    @Override
    public void reset() {
        this.stateMachine.clear();
    }
}
