package com.oneponygames.frozen.eventsystem.subscriber;

import com.oneponygames.frozen.eventsystem.events.EventSystem;

/**
 * Created by Icewind on 23.01.2017.
 */
public interface EventSubscriber {

    public void subscribeTo(EventSystem system);
}
