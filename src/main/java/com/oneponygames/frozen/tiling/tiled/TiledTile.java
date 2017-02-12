package com.oneponygames.frozen.tiling.tiled;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.data.IntVector2;
import com.oneponygames.frozen.tiling.Tile;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Icewind on 12.02.2017.
 */
public class TiledTile implements Tile {

    private final TiledMapTileLayer.Cell cell;
    private final IntVector2 position;
    private final IntVector2 dimensions;

    public TiledTile(TiledMapTileLayer.Cell cell, IntVector2 pos, IntVector2 dimensions) {
        this.cell = cell;
        this.position = pos;
        this.dimensions = dimensions;
    }

    @Override
    public int getX() {
        return this.position.x;
    }

    @Override
    public int getY() {
        return this.position.y;
    }

    @Override
    public boolean isSolid() {
        if(cell != null)
            return cell.getTile().getProperties().get(TiledTileMapInfo.PROP_SOLID, Boolean.FALSE, Boolean.class);
        return false;
    }

    @Override
    public Vector2 getWorldCenter() {
        return new Vector2(position.x * dimensions.x + dimensions.x/2f, position.y * dimensions.y + dimensions.y/2f);
    }
}
