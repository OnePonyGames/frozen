package com.oneponygames.frozen.game;

import com.badlogic.gdx.Screen;
import com.oneponygames.frozen.logic.events.BasicEventSource;
import com.oneponygames.frozen.logic.events.lifecycle.ScreenRenderEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public class EventSourceScreenAdapter extends BasicEventSource implements Screen {

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        this.getEventSystem().reportEvent(new ScreenRenderEvent(delta));
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
