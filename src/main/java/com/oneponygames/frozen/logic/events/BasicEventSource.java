package com.oneponygames.frozen.logic.events;

/**
 * Created by Icewind on 23.01.2017.
 */
public abstract class BasicEventSource implements EventSource {

    private EventSystem eventSystem;

    @Override
    public void setEventSystem(EventSystem system) {
        this.eventSystem = system;
    }

    protected EventSystem getEventSystem() {
        return eventSystem;
    }
}
