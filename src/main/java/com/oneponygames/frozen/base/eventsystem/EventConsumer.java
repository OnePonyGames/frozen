package com.oneponygames.frozen.base.eventsystem;

import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface EventConsumer<C extends GameEvent> {

    public void event(C event);
}
