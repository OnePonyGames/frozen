package com.oneponygames.frozen.base.eventsystem.subscriber;

import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.events.input.MouseMovedEvent;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;

/**
 * Created by Icewind on 25.01.2017.
 */
public class CameraMouseScrollController implements EventSubscriber {

    private static final float X_SCROLL_RANGE = 10;
    private static final float Y_SCROLL_RANGE = 10;
    private static final float SCROLL_SPEED = 400;

    private final OrthoCameraController camera;
    private float scrollX = 0;
    private float scrollY = 0;

    public CameraMouseScrollController(OrthoCameraController camera) {
        this.camera = camera;
    }

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(e->this.checkForScrolling(e.getX(), e.getY()), MouseMovedEvent.class);

        system.addConsumer(e->this.camera.move(this.scrollX * e.getDelta(), this.scrollY * e.getDelta()), ScreenRenderEvent.class);
    }

    private void checkForScrolling(float x, float y) {
        if(x < X_SCROLL_RANGE)
            this.scrollX = -SCROLL_SPEED;
        else if(x > this.camera.getScreenWidth() - X_SCROLL_RANGE)
            this.scrollX = SCROLL_SPEED;
        else
            this.scrollX = 0;

        if(y < Y_SCROLL_RANGE)
            this.scrollY = SCROLL_SPEED;
        else if(y > this.camera.getScreenHeight() - Y_SCROLL_RANGE)
            this.scrollY = -SCROLL_SPEED;
        else
            this.scrollY = 0;
    }
}
