package com.oneponygames.frozen.eventsystem.subscriber;

import com.oneponygames.frozen.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface EventConsumer<C extends GameEvent> {

    public void event(C event);
}
