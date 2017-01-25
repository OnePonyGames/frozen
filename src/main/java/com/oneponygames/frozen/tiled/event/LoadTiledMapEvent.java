package com.oneponygames.frozen.tiled.event;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.oneponygames.frozen.base.eventsystem.events.GameEvent;

/**
 * Created by Icewind on 25.01.2017.
 */
public class LoadTiledMapEvent implements GameEvent {

    private final TiledMap map;

    public LoadTiledMapEvent(TiledMap map) {
        this.map = map;
    }

    public TiledMap getMap() {
        return map;
    }
}
