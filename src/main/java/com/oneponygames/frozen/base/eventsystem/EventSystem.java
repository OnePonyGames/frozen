package com.oneponygames.frozen.base.eventsystem;

import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface EventSystem {

    public <C extends GameEvent> void addConsumer(Class<C> eventClass, EventConsumer<C> subscriber);

    public <C extends GameEvent> void reportEvent(C event);

    public void addSource(EventSource source);
}
