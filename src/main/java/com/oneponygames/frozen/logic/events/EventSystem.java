package com.oneponygames.frozen.logic.events;

import com.oneponygames.frozen.logic.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.logic.subscriber.EventSubscriber;

/**
 * Created by Icewind on 18.01.2017.
 */
public interface EventSystem {

    public <C extends GameEvent> void addSubscriber(Class<C> eventClass, EventSubscriber<C> subscriber);

    public <C extends GameEvent> void reportEvent(C event);

    public void addSource(EventSource source);
}
