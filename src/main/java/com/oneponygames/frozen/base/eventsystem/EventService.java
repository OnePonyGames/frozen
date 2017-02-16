package com.oneponygames.frozen.base.eventsystem;

import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface EventService {

    public static final int DEFAULT_PRIORITY = 10;

    public <C extends GameEvent> void addConsumer(Class<C> eventClass, EventConsumer<? super C> subscriber);

    public <C extends GameEvent> void addConsumer(Class<C> eventClass, EventConsumer<? super C> subscriber, int priority);
}
