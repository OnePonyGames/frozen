package com.oneponygames.frozen.base.ashley;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.utils.ImmutableArray;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.base.eventsystem.events.entity.AddEntityEvent;
import com.oneponygames.frozen.base.eventsystem.events.entity.AddEntitySystemEvent;
import com.oneponygames.frozen.base.eventsystem.events.entity.RemoveEntityEvent;
import com.oneponygames.frozen.base.eventsystem.events.entity.RemoveEntitySystemEvent;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.utils.Accumulator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 13.02.2017.
 */
public class FrozenAshleyEngine extends PooledEngine implements EventSubscriber  {

    private Accumulator<EntitySystem> accumulator = new Accumulator<>();
    private Map<EntitySystem, Float> consumption = new HashMap<>();

    public void addSystem(EntitySystem system, Float interval) {
        this.accumulator.put(system);
        this.consumption.put(system, interval);
        super.addSystem(system);
    }

    @Override
    public void addSystem(EntitySystem system) {
        this.addSystem(system, null); // null indicates that it should consume everything per update
    }

    @Override
    public void update(float deltaTime) {
        ImmutableArray<EntitySystem> systems = this.getSystems();

        for(EntitySystem s : systems)
            this.accumulator.add(s, deltaTime);

        boolean update = true;
        while(update) {
            update = false;

            for (EntitySystem s : systems) {
                float consumption = this.getConsumption(s, deltaTime);
                if (this.accumulator.get(s) >= consumption) {
                    this.accumulator.subtract(s, consumption);

                    s.update(consumption);

                    if (!update && this.accumulator.get(s) > 0f)
                        update = true;
                }
            }
        }
    }

    private float getConsumption(EntitySystem s, float deltaTime) {
        Float consumption = this.consumption.get(s);
        if(consumption == null)
            return deltaTime;
        return consumption;
    }

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(e -> this.addEntity(e.getEntity()), AddEntityEvent.class);
        system.addConsumer(e-> this.removeEntity(e.getEntity()), RemoveEntityEvent.class);
        system.addConsumer(e-> this.addSystem(e.getSystem(), e.getInterval()), AddEntitySystemEvent.class);
        system.addConsumer(e-> this.removeSystem(e.getSystem()), RemoveEntitySystemEvent.class);

        system.addConsumer(e-> this.update(e.getDelta()), ScreenRenderEvent.class);
    }
}
