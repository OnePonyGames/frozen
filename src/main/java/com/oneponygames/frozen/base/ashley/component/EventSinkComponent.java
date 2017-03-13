package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.oneponygames.frozen.base.eventsystem.EventSink;
import com.oneponygames.frozen.base.eventsystem.EventSource;

/**
 * Created by Icewind on 13.03.2017.
 */
public class EventSinkComponent implements Component, EventSource {

    private EventSink eventSink;

    @Override
    public void setEventSink(EventSink eventSink) {
        this.eventSink = eventSink;
    }

    public EventSink getEventSink() {
        return eventSink;
    }
}
