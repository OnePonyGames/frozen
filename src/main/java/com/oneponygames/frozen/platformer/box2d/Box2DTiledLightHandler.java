package com.oneponygames.frozen.platformer.box2d;

import box2dLight.ConeLight;
import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.base.eventsystem.subscriber.OrthoCameraController;
import com.oneponygames.frozen.tiling.LightingInfo;
import com.oneponygames.frozen.tiling.Tile;
import com.oneponygames.frozen.tiling.TileMapInfo;
import com.oneponygames.frozen.tiling.tiled.event.TiledMapLoadedEvent;

/**
 * Created by Icewind on 14.03.2017.
 */
public class Box2DTiledLightHandler implements EventSubscriber {

    private final RayHandler rayHandler;
    private final float pixelScale;
    private final OrthoCameraController camera;
    private final TileMapInfo info;

    public Box2DTiledLightHandler(TileMapInfo info, OrthoCameraController camera, World world, float pixelScaling) {
        this.rayHandler = new RayHandler(world);
        this.camera = camera;
        this.info = info;
        this.pixelScale = pixelScaling;
    }

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(e -> this.drawLights(), EventService.DEFAULT_PRIORITY + 1, ScreenRenderEvent.class);

        system.addConsumer(e -> this.initializeLights(), 20, TiledMapLoadedEvent.class);
    }

    private void initializeLights() {
        for(Tile t : this.info.getTiles()) {
            if(t.isLight()) {
                LightingInfo info = t.getLightingInfo();
                switch (info.getType()) {
                    case POINT: new PointLight(this.rayHandler, 200, info.getColor(), info.getRadius() * pixelScale, t.getWorldX() * pixelScale, t.getWorldY() * pixelScale);
                        break;
                    case CONE: new ConeLight(this.rayHandler, 200, info.getColor(), info.getRadius() * pixelScale, t.getWorldX() * pixelScale, t.getWorldY() * pixelScale, info.getAngle(), 90);
                        break;
                    case FIRE: new FireLight(this.rayHandler, 200, info.getColor(), info.getRadius() * pixelScale, t.getWorldX() * pixelScale, t.getWorldY() * pixelScale);
                        break;
                }
            }
        }
    }

    private void drawLights() {
        this.rayHandler.setCombinedMatrix(camera.getCamera());
        this.rayHandler.updateAndRender();
    }

    public void setAmbientLight(Color color) {
        this.rayHandler.setAmbientLight(color);
    }
}
