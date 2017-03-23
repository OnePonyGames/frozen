package com.oneponygames.frozen.base.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.oneponygames.frozen.base.data.state.StateChangeListener;
import com.oneponygames.frozen.base.data.state.StateMachine;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenInitEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Icewind on 18.01.2017.
 */
public abstract class FrozenGame extends Game implements StateChangeListener<FrozenScreen> {

    private final StateMachine<FrozenScreen> screenStateMachine = new StateMachine<FrozenScreen>();

    public FrozenGame() {
        this.screenStateMachine.addStateChangeListener(this);
    }

    private void addScreen(FrozenScreen screen) {
        screen.reportEvent(new ScreenInitEvent());
        this.screenStateMachine.addState(screen);
    }

    @Override
    public final void create() {
        List<FrozenScreen> screens = new ArrayList<>();

        this.createScreens(screens);
        this.addScreens(screens);

        this.screenStateMachine.pushStateByLabel(this.getInitialScreenLabel());

        this.updateScreen();
    }

    private void updateScreen() {
        this.screenStateMachine.peekCurrentState().init();
        this.setScreen(this.screenStateMachine.peekCurrentState().getScreen());

        Gdx.input.setInputProcessor(this.screenStateMachine.peekCurrentState().getInput());
    }

    protected abstract String getInitialScreenLabel();

    protected abstract void createScreens(List<FrozenScreen> screens);

    private void addScreens(List<FrozenScreen> screens) {
        for(FrozenScreen screen : screens)
            this.addScreen(screen);
    }

    @Override
    public void notifyStateChange(FrozenScreen oldState, FrozenScreen newState) {
        this.updateScreen();
    }
}
