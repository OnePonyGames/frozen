package com.oneponygames.frozen.base.ashley.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.oneponygames.frozen.base.ashley.component.AiStateComponent;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 17.02.2017.
 */
public class AiStateUpdateSystem extends IteratingSystem {

    public AiStateUpdateSystem() {
        super(Family.all(AiStateComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        AiStateComponent aicomp = BaseMappers.aiMap.get(entity);

        aicomp.getStateMachine().peekCurrentState().update(deltaTime);
    }
}
