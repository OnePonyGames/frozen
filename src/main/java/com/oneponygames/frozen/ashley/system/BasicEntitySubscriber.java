package com.oneponygames.frozen.ashley.system;

import com.badlogic.ashley.core.EntitySystem;
import com.oneponygames.frozen.eventsystem.events.BasicEventSource;
import com.oneponygames.frozen.eventsystem.events.EventSystem;
import com.oneponygames.frozen.eventsystem.events.entity.AddEntitySystemEvent;
import com.oneponygames.frozen.eventsystem.events.lifecycle.ScreenInitEvent;
import com.oneponygames.frozen.eventsystem.subscriber.EventSubscriber;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class BasicEntitySubscriber extends BasicEventSource implements EventSubscriber {

    @Override
    public void subscribeTo(EventSystem system) {
        system.addConsumer(ScreenInitEvent.class, e -> system.reportEvent(new AddEntitySystemEvent(this.getEntitySystem())));
    }

    public abstract EntitySystem getEntitySystem();
}
