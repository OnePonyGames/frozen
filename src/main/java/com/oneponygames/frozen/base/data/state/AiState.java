package com.oneponygames.frozen.base.data.state;


import com.badlogic.ashley.core.Entity;
import com.oneponygames.frozen.base.ashley.component.CharacterStateComponent;
import com.oneponygames.frozen.base.logic.AiContext;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 17.02.2017.
 */
public abstract class AiState<C extends AiContext> extends EntityState<AiState> {

    private final C context;

    public AiState(String label, Entity entity, C context) {
        super(label, entity);
        this.context = context;
    }

    protected final C getContext() {
        return context;
    }

    public CharacterState getCharacterState() {
        return BaseMappers.stateMap.get(this.getEntity()).getStateMachine().peekCurrentState();
    }

    public abstract void update(float deltaTime);
}
