package com.oneponygames.frozen.base.eventsystem;

import com.google.common.collect.*;
import com.oneponygames.frozen.base.eventsystem.events.GameEvent;
import com.oneponygames.frozen.utils.ClassComparator;

import java.util.*;

/**
 * Created by Icewind on 18.01.2017.
 */
public class BasicEventSystem implements EventService, EventSink, Comparator<EventConsumer<?>> {

    private final Multimap<Class<? extends GameEvent>, EventConsumer<? extends GameEvent>> consumers = TreeMultimap.create(new ClassComparator(), this);
    private final Set<EventSource> sources = new LinkedHashSet<>();
    private final Map<EventConsumer<? extends GameEvent>, Integer> priorities = new HashMap<>();

    public BasicEventSystem() {
    }

    @Override
    public <C extends GameEvent> void reportEvent(C event) {
        Class<? extends GameEvent> eventClass = event.getClass();
        Collection<EventConsumer<? extends GameEvent>> subs = this.consumers.get(eventClass);
        for(EventConsumer<? extends GameEvent> subscriber : subs) {
            EventConsumer<C> sub = (EventConsumer<C>)subscriber;
            sub.event(event);
        }
    }

    @Override
    public <C extends GameEvent> void addConsumer(Class<C> eventClass, EventConsumer<? super C> subscriber) {
        this.addConsumer(eventClass, subscriber, EventService.DEFAULT_PRIORITY);
    }

    @Override
    public <C extends GameEvent> void addConsumer(Class<C> eventClass, EventConsumer<? super C> consumer, int priority) {
        this.priorities.put(consumer, priority);
        this.consumers.put(eventClass, consumer);
    }

    @Override
    public void addSource(EventSource source) {
        this.sources.add(source);
        source.setEventSink(this);
    }

    @Override
    public int compare(EventConsumer<?> o1, EventConsumer<?> o2) {
        int p1 = this.getPriority(o1);
        int p2 = this.getPriority(o2);

        if(p1 == p2)
            return Integer.compare(o1.hashCode(), o2.hashCode());

        return Integer.compare(p1, p2);
    }

    private int getPriority(EventConsumer<?> o1) {
        if(!this.priorities.containsKey(o1))
            System.out.println(o1);
        return this.priorities.get(o1);
    }
}
