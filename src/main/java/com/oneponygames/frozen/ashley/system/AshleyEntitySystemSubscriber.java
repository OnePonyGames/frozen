package com.oneponygames.frozen.ashley.system;

import com.badlogic.ashley.core.EntitySystem;
import com.oneponygames.frozen.eventsystem.events.BasicEventSource;
import com.oneponygames.frozen.eventsystem.events.EventSystem;
import com.oneponygames.frozen.eventsystem.events.entity.AddEntitySystemEvent;
import com.oneponygames.frozen.eventsystem.events.lifecycle.ScreenInitEvent;
import com.oneponygames.frozen.eventsystem.subscriber.EventSubscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Icewind on 23.01.2017.
 */
public final class AshleyEntitySystemSubscriber extends BasicEventSource implements EventSubscriber {

    private final List<EntitySystem> systems = new ArrayList<>();

    @Override
    public void subscribeTo(EventSystem system) {
        system.addConsumer(ScreenInitEvent.class, e -> systems.forEach( s-> system.reportEvent(new AddEntitySystemEvent(s))));
    }

    public void addEntitySystem(EntitySystem entitySystem) {
        this.systems.add(entitySystem);
    }
}
