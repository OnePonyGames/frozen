package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.oneponygames.frozen.base.data.state.AiState;
import com.oneponygames.frozen.base.data.state.StateMachine;

/**
 * Created by Icewind on 17.02.2017.
 */
public class AiStateComponent implements Component {

    private final StateMachine<AiState> stateMachine = new StateMachine<>();

    public StateMachine<AiState> getStateMachine() {
        return stateMachine;
    }
}
