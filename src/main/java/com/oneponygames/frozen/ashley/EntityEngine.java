package com.oneponygames.frozen.ashley;

import com.badlogic.ashley.core.Engine;
import com.oneponygames.frozen.eventsystem.events.EventSystem;
import com.oneponygames.frozen.eventsystem.events.entity.AddEntityEvent;
import com.oneponygames.frozen.eventsystem.events.entity.AddEntitySystemEvent;
import com.oneponygames.frozen.eventsystem.events.entity.RemoveEntityEvent;
import com.oneponygames.frozen.eventsystem.events.entity.RemoveEntitySystemEvent;
import com.oneponygames.frozen.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.eventsystem.subscriber.EventSubscriber;

/**
 * Created by Icewind on 23.01.2017.
 */
public class EntityEngine implements EventSubscriber {

    private final Engine engine;

    public EntityEngine() {
        this.engine = new Engine();
    }

    @Override
    public void subscribeTo(EventSystem system) {
        system.addConsumer(AddEntityEvent.class, e -> this.engine.addEntity(e.getEntity()));
        system.addConsumer(RemoveEntityEvent.class, e-> this.engine.removeEntity(e.getEntity()));
        system.addConsumer(AddEntitySystemEvent.class, e-> this.engine.addSystem(e.getSystem()));
        system.addConsumer(RemoveEntitySystemEvent.class, e-> this.engine.removeSystem(e.getSystem()));

        system.addConsumer(ScreenRenderEvent.class, e-> this.engine.update(e.delta));
    }
}
