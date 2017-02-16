package com.oneponygames.frozen.base.data.state;


/**
 * Created by Icewind on 16.02.2017.
 */
public enum CharacterState implements State  {

    WALK_LEFT("walk_left", false), WALK_RIGHT("walk_right", false), IDLE("idle", false), LIGHT_ATTACK("light_attack", true);

    private StateMachine stateMachine;
    private String label;
    private boolean attackState;

    CharacterState(String label, boolean attackState) {
        this.label = label;
        this.attackState = attackState;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public boolean isAttackState() {
        return this.attackState;
    }
}
