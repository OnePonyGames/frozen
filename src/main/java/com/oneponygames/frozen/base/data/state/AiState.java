package com.oneponygames.frozen.base.data.state;


import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.logic.AiContext;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 17.02.2017.
 */
public abstract class AiState<C extends AiContext, S extends CharacterState> extends EntityState<AiState> {

    private final C context;
    private float activeTime;

    public AiState(String label, Entity entity, C context) {
        super(label, entity);
        this.context = context;
    }

    protected final C getContext() {
        return context;
    }

    public S getCharacterState() {
        return (S) BaseMappers.stateMap.get(this.getEntity()).getStateMachine().peekCurrentState();
    }

    public final void update(float deltaTime) {
        this.activeTime += deltaTime;

        this.updateInternal(deltaTime, this.activeTime);
    }

    protected abstract void updateInternal(float deltaTime, float activeTime);

    protected void resetActive() {
        this.activeTime = 0;
    }
}
