package com.oneponygames.frozen.base.eventsystem;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Icewind on 18.01.2017.
 */
public class BasicEventSystem implements EventSystem {

    private final Multimap<Class<? extends GameEvent>, EventConsumer<? extends GameEvent>> subscribers = LinkedHashMultimap.create();
    private final Set<EventSource> sources = new LinkedHashSet<>();

    @Override
    public <C extends GameEvent> void reportEvent(C event) {
        Class<? extends GameEvent> eventClass = event.getClass();
        Collection<EventConsumer<? extends GameEvent>> subs = this.subscribers.get(eventClass);
        for(EventConsumer<? extends GameEvent> subscriber : subs) {
            EventConsumer<C> sub = (EventConsumer<C>)subscriber;
            sub.event(event);
        }
    }

    @Override
    public <C extends GameEvent> void addConsumer(Class<C> eventClass, EventConsumer<C> subscriber) {
        this.subscribers.put(eventClass, subscriber);
    }

    @Override
    public void addSource(EventSource source) {
        this.sources.add(source);
        source.setEventSystem(this);
    }
}
