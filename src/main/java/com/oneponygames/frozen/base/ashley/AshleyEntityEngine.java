package com.oneponygames.frozen.base.ashley;

import com.badlogic.ashley.core.Engine;
import com.oneponygames.frozen.base.eventsystem.EventSystem;
import com.oneponygames.frozen.base.eventsystem.events.entity.AddEntityEvent;
import com.oneponygames.frozen.base.eventsystem.events.entity.AddEntitySystemEvent;
import com.oneponygames.frozen.base.eventsystem.events.entity.RemoveEntityEvent;
import com.oneponygames.frozen.base.eventsystem.events.entity.RemoveEntitySystemEvent;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;

/**
 * Created by Icewind on 23.01.2017.
 */
public class AshleyEntityEngine implements EventSubscriber {

    private final Engine engine;

    public AshleyEntityEngine() {
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
