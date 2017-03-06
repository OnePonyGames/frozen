package com.oneponygames.frozen.base.ashley.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.oneponygames.frozen.base.ashley.component.CharacterStateComponent;
import com.oneponygames.frozen.base.data.state.CharacterState;
import com.oneponygames.frozen.utils.BaseMappers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 17.02.2017.
 */
public class CharacterStateUpdateSystem extends HookedIteratingSystem {

    private float accumulator;

    public CharacterStateUpdateSystem() {
        super(Family.all(CharacterStateComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        CharacterStateComponent<?> state = BaseMappers.stateMap.get(entity);

        state.getStateMachine().peekCurrentState().update(deltaTime, this.accumulator);
    }

    @Override
    protected void afterUpdate() {
    }

    @Override
    protected void beforeUpdate(float deltaTime) {
        this.accumulator += deltaTime;
    }
}
