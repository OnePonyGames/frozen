package com.oneponygames.frozen.tiling.tiled;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.data.IntVector2;
import com.oneponygames.frozen.base.data.Line;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.tiling.Tile;
import com.oneponygames.frozen.tiling.TileMapInfo;
import com.oneponygames.frozen.tiling.tiled.event.TiledMapLoadedEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Icewind on 12.02.2017.
 */
public class TiledTileMapInfo implements TileMapInfo, EventSubscriber {

    public static final String PROP_SOLID = "solid";
    private static final String TILE_WIDTH = "tilewidth";
    private static final String TILE_HEIGHT = "tileheight";

    private TiledMap map;
    private TiledMapTileLayer layer;
    private IntVector2 dimensions = new IntVector2(0,0);

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(TiledMapLoadedEvent.class, e -> this.setMap(e.getMap()));
    }

    @Override
    public Iterable<Tile> getIntersectingTiles(Line worldCoordinates) {
        int xDir = worldCoordinates.isHorizontal() ? 1 : 0;
        int yDir = worldCoordinates.isVertical() ? 1 : 0;

        IntVector2 minPos = this.worldToGridPos(worldCoordinates.getFrom());
        IntVector2 maxPos = this.worldToGridPos(worldCoordinates.getTo());

        int x = minPos.x;
        int y = minPos.y;

        List<Tile> ret = new ArrayList<>();
        while(x <= maxPos.x && y <= maxPos.y) {
            ret.add(this.getTile(x, y));

            x += xDir;
            y += yDir;
        }

        return ret;
    }

    public Tile getTile(int x, int y) {
        TiledMapTileLayer.Cell cell = this.layer.getCell(x, y);

        return new TiledTile(cell, new IntVector2(x, y), this.dimensions);
    }

    private IntVector2 worldToGridPos(Vector2 from) {
        return new IntVector2((int)(from.x / this.getTileWidth()), (int)(from.y / this.getTileHeight()));
    }

    private void setMap(TiledMap map) {
        this.map = map;
        this.layer = (TiledMapTileLayer)this.map.getLayers().get(0);
        this.dimensions = new IntVector2(map.getProperties().get(TILE_WIDTH, Integer.class), map.getProperties().get(TILE_HEIGHT, Integer.class));
    }

    @Override
    public float getTileWidth() {
        return this.dimensions.x;
    }

    @Override
    public float getTileHeight() {
        return this.dimensions.y;
    }
}
