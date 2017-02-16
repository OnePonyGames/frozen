package com.oneponygames.frozen.base.eventsystem;

import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface EventService {

    public static final int DEFAULT_PRIORITY = 10;

    public <C extends GameEvent> void addConsumer(EventConsumer<C> subscriber, Class<? extends C>... eventClass);

    public <C extends GameEvent> void addConsumer(EventConsumer<C> subscriber, int priority, Class<? extends C>... eventClass);
}
