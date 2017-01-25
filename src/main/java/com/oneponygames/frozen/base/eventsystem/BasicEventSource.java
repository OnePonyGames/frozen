package com.oneponygames.frozen.base.eventsystem;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class BasicEventSource implements EventSource {

    private EventSink sink;

    @Override
    public void setEventSink(EventSink sink) {
        this.sink = sink;
    }

    protected EventSink getEventSink() {
        return sink;
    }
}
