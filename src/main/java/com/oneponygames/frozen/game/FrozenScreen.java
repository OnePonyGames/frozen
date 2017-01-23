package com.oneponygames.frozen.game;

import com.badlogic.gdx.Screen;
import com.oneponygames.frozen.data.State;
import com.oneponygames.frozen.data.StateMachine;
import com.oneponygames.frozen.logic.events.BasicEventSystem;
import com.oneponygames.frozen.logic.events.EventSystem;
import com.oneponygames.frozen.logic.events.EventSource;
import com.oneponygames.frozen.logic.events.GameEvent;
import com.oneponygames.frozen.logic.subscriber.EventSubscriber;

/**
 * Created by Icewind on 18.01.2017.
 */
public class FrozenScreen implements State<FrozenScreen>, EventSystem {

    private final BasicEventSystem eventSystem;
    private final String label;
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

    public void afterStateInactive() {
    }

    public void beforeStateActive() {
    }

    @Override
    public final <T extends GameEvent> void addSubscriber(Class<T> eventClass, EventSubscriber<T> subscriber) {
        this.eventSystem.addSubscriber(eventClass, subscriber);
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
