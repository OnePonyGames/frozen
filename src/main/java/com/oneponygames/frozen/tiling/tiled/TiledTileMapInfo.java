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

import java.util.*;

/**
 * Created by Icewind on 12.02.2017.
 */
public class TiledTileMapInfo implements TileMapInfo, EventSubscriber {

    public static final String PROP_SOLID = "solid";
    public static final String PROP_LIGHT_RADIUS = "light_radius";
    public static final String PROP_LIGHT_COLOR = "light_color";
    public static final String PROP_LIGHT_TYPE = "light_type";

    private static final String WIDTH = "width";
    private static final String HEIGHT = "height";
    private static final String TILE_WIDTH = "tilewidth";
    private static final String TILE_HEIGHT = "tileheight";

    private TiledMap map;
    private IntVector2 dimensions = new IntVector2(0,0);
    private int mapWidth;
    private int mapHeight;

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(e -> this.setMap(e.getMap()), TiledMapLoadedEvent.class);
    }

    @Override
    public Iterable<Tile> getTiles() {
        return new TileIterator(this.map);
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
        List<TiledMapTileLayer.Cell> cells = new ArrayList<>();
        for(MapLayer layer : this.map.getLayers()) {
            TiledMapTileLayer l = (TiledMapTileLayer)layer;
            cells.add(l.getCell(x, y));
        }

        return new TiledTile(new IntVector2(x, y), this.dimensions, cells);
    }

    private IntVector2 worldToGridPos(Vector2 from) {
        return new IntVector2((int)(from.x / this.getTileWidth()), (int)(from.y / this.getTileHeight()));
    }

    private void setMap(TiledMap map) {
        this.map = map;
        this.mapWidth = map.getProperties().get(WIDTH, Integer.class);
        this.mapHeight = map.getProperties().get(HEIGHT, Integer.class);
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

    private class TileIterator implements Iterable<Tile> {

        private final TiledMap map;

        public TileIterator(TiledMap map) {
            this.map = map;
        }

        @Override
        public Iterator<Tile> iterator() {
            return new Iterator<Tile>() {
                private int x = 0, y = 0;
                @Override
                public boolean hasNext() {
                    return x+y < mapHeight + mapWidth - 2;
                }

                @Override
                public Tile next() {
                    Tile t = getTile(x, y);
                    x++;
                    if(x == mapWidth) {
                        x = 0;
                        y++;
                    }
                    return t;
                }
            };
        }
    }
}
