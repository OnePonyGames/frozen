package com.oneponygames.frozen.tiling;


import com.oneponygames.frozen.base.data.Line;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Icewind on 25.01.2017.
 */
public interface TileMapInfo {

    public Iterable<Tile> getIntersectingTiles(Line line);

    public Tile getTile(int x, int y);

    public float getTileWidth();

    public float getTileHeight();

    public Iterable<Tile> getTiles();
}
