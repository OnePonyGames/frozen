package com.oneponygames.frozen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.oneponygames.frozen.eventsystem.events.BasicEventSource;
import com.oneponygames.frozen.eventsystem.events.lifecycle.DisposeEvent;
import com.oneponygames.frozen.eventsystem.events.lifecycle.ScreenRenderEvent;

/**
 * Created by Icewind on 18.01.2017.
 */
public class EventSourceScreenAdapter extends BasicEventSource implements Screen {

    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
        this.getEventSystem().reportEvent(new DisposeEvent());
    }
}
