package com.oneponygames.frozen.eventsystem.events;

import com.oneponygames.frozen.eventsystem.subscriber.EventConsumer;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface EventSystem {

    public <C extends GameEvent> void addConsumer(Class<C> eventClass, EventConsumer<C> subscriber);

    public <C extends GameEvent> void reportEvent(C event);

    public void addSource(EventSource source);
}
