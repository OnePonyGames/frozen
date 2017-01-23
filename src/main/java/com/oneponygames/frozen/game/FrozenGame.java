package com.oneponygames.frozen.game;

import com.badlogic.gdx.Game;
import com.oneponygames.frozen.data.StateMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Icewind on 18.01.2017.
 */
public abstract class FrozenGame extends Game {

    private final StateMachine<FrozenScreen> screenStateMachine = new StateMachine<FrozenScreen>();

    private void addScreen(FrozenScreen screen) {
        this.screenStateMachine.addState(screen);
    }

    protected void pushScreen(FrozenScreen screen) {
        this.screenStateMachine.pushState(screen);

        this.updateScreen();
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
        this.setScreen(this.screenStateMachine.peekCurrentState().getScreen());
    }

    protected abstract String getInitialScreenLabel();

    protected abstract void createScreens(List<FrozenScreen> screens);

    private void addScreens(List<FrozenScreen> screens) {
        for(FrozenScreen screen : screens)
            this.addScreen(screen);
    }
}
