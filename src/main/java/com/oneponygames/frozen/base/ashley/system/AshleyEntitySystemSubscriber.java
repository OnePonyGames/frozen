package com.oneponygames.frozen.base.ashley.system;

import com.badlogic.ashley.core.EntitySystem;
import com.oneponygames.frozen.base.eventsystem.BasicEventSource;
import com.oneponygames.frozen.base.eventsystem.EventSystem;
import com.oneponygames.frozen.base.eventsystem.events.entity.AddEntitySystemEvent;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenInitEvent;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;

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
