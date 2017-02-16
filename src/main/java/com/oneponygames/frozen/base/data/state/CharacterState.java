package com.oneponygames.frozen.base.data.state;


/**
 * Created by Icewind on 16.02.2017.
 */
public enum CharacterState implements State  {

    WALK("walk"), IDLE("idle"), LIGHT_ATTACK("light_attack");

    private StateMachine stateMachine;
    private String label;

    CharacterState(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
}
