package com.oneponygames.frozen.base.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.oneponygames.frozen.base.ashley.EntityPool;
import com.oneponygames.frozen.base.ashley.FrozenAshleyEngine;
import com.oneponygames.frozen.base.data.state.State;
import com.oneponygames.frozen.base.data.state.StateMachine;
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
    private final FrozenAshleyEngine engine;

    private StateMachine<FrozenScreen> stateMachine;

    public FrozenScreen(String label) {
        this.label = label;
        this.screen = new EventSourceScreenAdapter();
        this.input = new InputSourceAdapter();
        this.eventSystem = new BasicEventSystem();
        this.engine = new FrozenAshleyEngine();

        this.addSource(this.screen);
        this.addSource(this.input);

        this.engine.subscribeTo(this);
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
    public <C extends GameEvent> void addConsumer(EventConsumer<C> subscriber, Class<? extends C>[] eventClass) {
        this.eventSystem.addConsumer(subscriber, eventClass);
    }

    @Override
    public <C extends GameEvent> void addConsumer(EventConsumer<C> subscriber, int priority, Class<? extends C>[] eventClass) {
        this.eventSystem.addConsumer(subscriber, priority, eventClass);
    }

    public EntityPool getEntityPool() {
        return this.engine;
    }

    @Override
    public final void addSource(EventSource source) {
        this.eventSystem.addSource(source);
    }

    @Override
    public final <C extends GameEvent> void reportEvent(C event) {
        this.eventSystem.reportEvent(event);
    }

    @Override
    public void setActive(boolean b) {
    }
}
