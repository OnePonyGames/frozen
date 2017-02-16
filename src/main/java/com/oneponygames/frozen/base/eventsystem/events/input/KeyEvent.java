package com.oneponygames.frozen.base.eventsystem.events.input;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class KeyEvent implements InputEvent {

    private final int keycode;

    public KeyEvent(int keycode) {
        this.keycode = keycode;
    }

    public int getKeycode() {
        return keycode;
    }
}
