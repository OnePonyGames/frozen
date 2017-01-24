package com.oneponygames.frozen.base.eventsystem;

import com.oneponygames.frozen.base.eventsystem.EventSystem;

/**
 * Created by Icewind on 23.01.2017.
 */
public interface EventSubscriber {

    public void subscribeTo(EventSystem system);
}
