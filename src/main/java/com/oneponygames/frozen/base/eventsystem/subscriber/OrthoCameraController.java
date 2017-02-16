package com.oneponygames.frozen.base.eventsystem.subscriber;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;

/**
 * Created by Icewind on 25.01.2017.
 */
public class OrthoCameraController implements EventSubscriber {

    private final OrthographicCamera camera;

    public OrthoCameraController(OrthographicCamera camera) {
        this.camera = camera;
    }

    public void move(float scrollX, float scrollY) {
        this.camera.translate(scrollX, scrollY);
    }

    public float getScreenWidth() {
        return this.camera.viewportWidth;
    }

    public float getScreenHeight() {
        return this.camera.viewportHeight;
    }

    public void setPosition(float x, float y) {
        this.move(x - this.camera.position.x, y - this.camera.position.y);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Matrix4 getCombined() {
        return this.camera.combined;
    }

    public Vector2 screenToWorld(Vector2 screen) {
        Vector3 world = this.camera.unproject(new Vector3(screen.x, screen.y, 0));
        return new Vector2(world.x, world.y);
    }

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(e->this.camera.update(), ScreenRenderEvent.class);
    }
}
