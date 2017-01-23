package com.oneponygames.frozen.logic.subscriber;

import com.oneponygames.frozen.logic.events.EventSystem;
import com.oneponygames.frozen.logic.events.GameEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface EventSubscriber<C extends GameEvent> {

    public void subscribeTo(EventSystem system);

    public void event(C event);
}
