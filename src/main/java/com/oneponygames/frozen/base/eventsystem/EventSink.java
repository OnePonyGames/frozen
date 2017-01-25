package com.oneponygames.frozen.base.eventsystem;

import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 25.01.2017.
 */
public interface EventSink {

    public <C extends GameEvent> void reportEvent(C event);

    public void addSource(EventSource source);
}
