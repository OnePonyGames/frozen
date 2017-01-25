package com.oneponygames.frozen.base.eventsystem.sources;

import com.badlogic.gdx.InputProcessor;
import com.oneponygames.frozen.base.eventsystem.BasicEventSource;
import com.oneponygames.frozen.base.eventsystem.events.input.MouseMovedEvent;

/**
 * Created by Icewind on 25.01.2017.
 */
public class InputSourceAdapter extends BasicEventSource implements InputProcessor {

    @Override
    public boolean keyDown(int keycode) {
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        this.getEventSink().reportEvent(new MouseMovedEvent(screenX, screenY));
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return true;
    }
}
