package com.oneponygames.frozen.platformer.components;

import com.badlogic.ashley.core.Component;
import com.oneponygames.frozen.base.ashley.component.CharacterStateComponent;
import com.oneponygames.frozen.base.data.state.CharacterState;
import com.oneponygames.frozen.platformer.data.Attack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 17.02.2017.
 */
public class AttackComponent implements Component {

    private final Map<CharacterState, Attack> stateAttackMap = new HashMap<>();
    private CharacterStateComponent state;

    public void setAttack(CharacterState state, Attack att) {
        stateAttackMap.put(state, att);
    }

    public Attack getActiveAttack() {
        return stateAttackMap.get(state.getStateMachine().peekCurrentState());
    }

    public void setState(CharacterStateComponent state) {
        this.state = state;
    }

    public boolean hasActiveAttack() {
        return this.getActiveAttack() != null;
    }
}
