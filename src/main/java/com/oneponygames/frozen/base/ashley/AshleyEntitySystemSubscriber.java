package com.oneponygames.frozen.base.ashley;

import com.badlogic.ashley.core.EntitySystem;
import com.oneponygames.frozen.base.eventsystem.BasicEventSource;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.events.entity.AddEntitySystemEvent;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenInitEvent;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 23.01.2017.
 */
public final class AshleyEntitySystemSubscriber extends BasicEventSource implements EventSubscriber {

    private final Map<EntitySystem, Float> systems = new HashMap<>();

    @Override
    public void subscribeTo(EventService service) {
        service.addConsumer(ScreenInitEvent.class, e -> systems.forEach( (s, i)-> this.getEventSink().reportEvent(new AddEntitySystemEvent(s, i))));
    }

    /**
     *
     * @param entitySystem the system to add.
     * @param interval the update interval that this system is called at
     */
    public void addEntitySystem(EntitySystem entitySystem, Float interval) {
        this.systems.put(entitySystem, interval);
    }

    public void addEntitySystem(EntitySystem entitySystem) {
        this.addEntitySystem(entitySystem, null);
    }
}
