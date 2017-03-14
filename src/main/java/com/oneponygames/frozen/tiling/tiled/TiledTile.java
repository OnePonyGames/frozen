package com.oneponygames.frozen.tiling.tiled;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.data.IntVector2;
import com.oneponygames.frozen.tiling.LightingInfo;
import com.oneponygames.frozen.tiling.Tile;
import com.oneponygames.frozen.utils.ColorUtil;

import java.util.List;

/**
 * Created by Icewind on 12.02.2017.
 */
public class TiledTile implements Tile {

    private final List<TiledMapTileLayer.Cell> cells;
    private final IntVector2 position;
    private final IntVector2 dimensions;
    private LightingInfo lightingInfo;

    public TiledTile(IntVector2 pos, IntVector2 dimensions, List<TiledMapTileLayer.Cell> cells) {
        this.cells = cells;
        this.position = pos;
        this.dimensions = dimensions;

        for(TiledMapTileLayer.Cell cell : this.cells) {
            if (cell != null) {
                String lightType = cell.getTile().getProperties().get(TiledTileMapInfo.PROP_LIGHT_TYPE, String.class);
                if (lightType != null) {
                    LightingInfo.TYPE type = LightingInfo.TYPE.forString(lightType);
                    String lightColor = cell.getTile().getProperties().get(TiledTileMapInfo.PROP_LIGHT_COLOR, String.class);
                    Color c = ColorUtil.parseColor(lightColor);
                    float radius = cell.getTile().getProperties().get(TiledTileMapInfo.PROP_LIGHT_RADIUS, Float.class);

                    this.lightingInfo = new LightingInfo(radius, c, type);
                    break;
                }
            }
        }
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
        for(TiledMapTileLayer.Cell cell : this.cells) {
            if (cell != null)
                if(cell.getTile().getProperties().get(TiledTileMapInfo.PROP_SOLID, Boolean.FALSE, Boolean.class))
                    return true;
        }
        return false;
    }

    @Override
    public boolean isLight() {
        return this.getLightingInfo() != null;
    }

    @Override
    public LightingInfo getLightingInfo() {
        return this.lightingInfo;
    }

    @Override
    public Vector2 getWorldCenter() {
        return new Vector2(position.x * dimensions.x + dimensions.x/2f, position.y * dimensions.y + dimensions.y/2f);
    }

    @Override
    public float getWorldX() {
        return this.getWorldCenter().x;
    }

    @Override
    public float getWorldY() {
        return this.getWorldCenter().y;
    }
}
