package com.oneponygames.frozen.game;

import com.badlogic.gdx.Screen;
import com.oneponygames.frozen.data.State;
import com.oneponygames.frozen.data.StateMachine;
import com.oneponygames.frozen.eventsystem.events.BasicEventSystem;
import com.oneponygames.frozen.eventsystem.events.EventSystem;
import com.oneponygames.frozen.eventsystem.events.EventSource;
import com.oneponygames.frozen.eventsystem.events.GameEvent;
import com.oneponygames.frozen.eventsystem.subscriber.EventConsumer;

/**
 * Created by Icewind on 18.01.2017.
 */
public class FrozenScreen implements State<FrozenScreen>, EventSystem {

    private final String label;
    private final BasicEventSystem eventSystem;
    private final EventSourceScreenAdapter screen;

    private StateMachine<FrozenScreen> stateMachine;

    public FrozenScreen(String label) {
        this.label = label;
        this.screen = new EventSourceScreenAdapter();
        this.eventSystem = new BasicEventSystem();

        this.addSource(this.screen);
    }

    public final Screen getScreen() {
        return screen;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setStateMachine(StateMachine<FrozenScreen> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public final <T extends GameEvent> void addConsumer(Class<T> eventClass, EventConsumer<T> subscriber) {
        this.eventSystem.addConsumer(eventClass, subscriber);
    }

    @Override
    public final void addSource(EventSource source) {
        this.eventSystem.addSource(source);
    }

    @Override
    public final <C extends GameEvent> void reportEvent(C event) {
        this.eventSystem.reportEvent(event);
    }
}
