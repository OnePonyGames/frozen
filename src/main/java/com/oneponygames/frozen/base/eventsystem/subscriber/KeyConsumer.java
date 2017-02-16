package com.oneponygames.frozen.base.eventsystem.subscriber;

import com.oneponygames.frozen.base.eventsystem.EventConsumer;
import com.oneponygames.frozen.base.eventsystem.events.input.KeyEvent;


/**
 * Created by Icewind on 16.02.2017.
 */
public class KeyConsumer implements EventConsumer<KeyEvent> {

    private final int keycode;
    private final EventConsumer<KeyEvent> function;

    public KeyConsumer(int keycode, EventConsumer<KeyEvent> function) {
        this.keycode = keycode;
        this.function = function;
    }

    public static KeyConsumer key(int keycode, EventConsumer<KeyEvent> function) {
        return new KeyConsumer(keycode, function);
    }

    @Override
    public void event(KeyEvent event) {
        if(event.getKeycode() == this.keycode)
            this.function.event(event);
    }
}
