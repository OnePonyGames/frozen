package com.oneponygames.frozen.tiling.tiled.event;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 25.01.2017.
 */
public class TiledMapLoadedEvent implements GameEvent {

    private final TiledMap map;

    public TiledMapLoadedEvent(TiledMap map) {
        this.map = map;
    }

    public TiledMap getMap() {
        return map;
    }
}
