package com.oneponygames.frozen.base.ashley.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.oneponygames.frozen.base.ashley.component.TimingComponent;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 21.01.2017.
 */
public class TimingSystem extends IteratingSystem {

    public TimingSystem() {
        super(Family.all(TimingComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TimingComponent tc = BaseMappers.timeMap.get(entity);
        tc.addTime(deltaTime);
    }
}
