package com.oneponygames.frozen.logic.events;

import com.badlogic.gdx.Game;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.oneponygames.frozen.logic.subscriber.EventSubscriber;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Icewind on 18.01.2017.
 */
public class BasicEventSystem implements EventSystem {

    private final Multimap<Class<? extends GameEvent>, EventSubscriber<? extends GameEvent>> subscribers = LinkedHashMultimap.create();
    private final Set<EventSource> sources = new LinkedHashSet<>();

    @Override
    public <C extends GameEvent> void reportEvent(C event) {
        Class<? extends GameEvent> eventClass = event.getClass();
        Collection<EventSubscriber<? extends GameEvent>> subs = this.subscribers.get(eventClass);
        for(EventSubscriber<? extends GameEvent> subscriber : subs) {
            EventSubscriber<C> sub = (EventSubscriber<C>)subscriber;
            sub.event(event);
        }
    }

    @Override
    public <C extends GameEvent> void addSubscriber(Class<C> eventClass, EventSubscriber<C> subscriber) {
        this.subscribers.put(eventClass, subscriber);
    }

    @Override
    public void addSource(EventSource source) {
        this.sources.add(source);
        source.setEventSystem(this);
    }
}
