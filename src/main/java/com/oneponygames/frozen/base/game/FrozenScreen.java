package com.oneponygames.frozen.base.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.oneponygames.frozen.base.data.State;
import com.oneponygames.frozen.base.data.StateMachine;
import com.oneponygames.frozen.base.eventsystem.*;
import com.oneponygames.frozen.base.eventsystem.events.GameEvent;
import com.oneponygames.frozen.base.eventsystem.sources.EventSourceScreenAdapter;
import com.oneponygames.frozen.base.eventsystem.sources.InputSourceAdapter;

/**
 * Created by Icewind on 18.01.2017.
 */
public class FrozenScreen implements State<FrozenScreen>, EventService, EventSink {

    private final String label;
    private final BasicEventSystem eventSystem;
    private final EventSourceScreenAdapter screen;
    private final InputSourceAdapter input;

    private StateMachine<FrozenScreen> stateMachine;

    public FrozenScreen(String label) {
        this.label = label;
        this.screen = new EventSourceScreenAdapter();
        this.input = new InputSourceAdapter();
        this.eventSystem = new BasicEventSystem();

        this.addSource(this.screen);
        this.addSource(this.input);
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

    public InputProcessor getInput() {
        return input;
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
