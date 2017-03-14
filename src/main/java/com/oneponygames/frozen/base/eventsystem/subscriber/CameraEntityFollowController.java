package com.oneponygames.frozen.base.eventsystem.subscriber;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 13.03.2017.
 */
public class CameraEntityFollowController implements EventSubscriber {

    private final OrthoCameraController camera;
    private final float pixelScaling;
    private Entity followEntity;

    public CameraEntityFollowController(OrthoCameraController camera, float pixelScaling) {
        this.camera = camera;
        this.pixelScaling = pixelScaling;
    }

    public void setFollowEntity(Entity e) {
        this.followEntity = e;
    }

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(e->{
            PositionComponent pos = BaseMappers.positionMap.get(this.followEntity);
            Vector2 diff = pos.getPositionVector().scl(pixelScaling).sub(this.camera.getCamera().position.x, this.camera.getCamera().position.y);
            this.camera.move(diff.x, diff.y);
        }, ScreenRenderEvent.class);
    }
}
