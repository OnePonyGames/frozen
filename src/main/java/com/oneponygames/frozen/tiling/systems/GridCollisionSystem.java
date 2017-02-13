package com.oneponygames.frozen.tiling.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalIteratingSystem;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.platformer.components.CollisionComponent;
import com.oneponygames.frozen.base.ashley.component.HitBoxComponent;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;
import com.oneponygames.frozen.base.data.Hitbox;
import com.oneponygames.frozen.base.data.Line;
import com.oneponygames.frozen.tiling.Tile;
import com.oneponygames.frozen.tiling.TileMapInfo;
import com.oneponygames.frozen.utils.BaseMappers;
import com.oneponygames.frozen.utils.VectorUtil;

/**
 * Created by Icewind on 25.01.2017.
 */
public class GridCollisionSystem extends IteratingSystem {

    private final TileMapInfo tileInfo;
    private float allowedDistance = 3;

    public GridCollisionSystem(TileMapInfo tileInfo) {
        super(Family.all(HitBoxComponent.class, PositionComponent.class, CollisionComponent.class).get());

        this.tileInfo = tileInfo;
    }

    @Override
    protected void processEntity(Entity entity, float delta) {
        Vector2 pos = BaseMappers.positionMap.get(entity).getPositionVector();
        CollisionComponent col = BaseMappers.collisionMap.get(entity);
        Hitbox hb = BaseMappers.hitboxMap.get(entity).getHitbox();

        Line left = this.getLeftLine(pos, hb);
        Line right = this.getRightLine(pos, hb);
        Line top = this.getTopLine(pos, hb);
        Line bottom = this.getBottomLine(pos, hb);

        Iterable<Tile> tilesL = this.tileInfo.getIntersectingTiles(left);
        Iterable<Tile> tilesR = this.tileInfo.getIntersectingTiles(right);
        Iterable<Tile> tilesT = this.tileInfo.getIntersectingTiles(top);
        Iterable<Tile> tilesB = this.tileInfo.getIntersectingTiles(bottom);

        if(this.isInContactWithSolidTile(bottom, tilesB, 0, -1))
            col.contactBottom = true;
        /*if(this.isInContactWithSolidTile(left, tilesL))
            col.contactLeft = true;
        */
    }

    private boolean isInContactWithSolidTile(Line line, Iterable<Tile> tiles, int xDir, int yDir) {
        for(Tile t : tiles) {
            Tile toCheck = this.tileInfo.getTile(t.getX() + xDir, t.getY() + yDir);

            if(toCheck.isSolid()) {
                float distance = VectorUtil.getDistance(line, toCheck.getWorldCenter());
                float threshold = Math.abs(this.tileInfo.getTileWidth() / 2f * xDir) + Math.abs(this.tileInfo.getTileHeight() / 2f * yDir) + this.allowedDistance;

                if(distance < threshold)
                    return true;
            }
        }
        return false;
    }

    private Line getBottomLine(Vector2 pos, Hitbox hb) {
        return this.getLine(pos, hb, -1, -1, 1, -1);
    }

    private Line getTopLine(Vector2 pos, Hitbox hb) {
        return this.getLine(pos, hb, -1, 1, 1, 1);
    }

    private Line getRightLine(Vector2 pos, Hitbox hb) {
        return this.getLine(pos, hb, 1, -1, 1, 1);
    }

    private Line getLeftLine(Vector2 pos, Hitbox hb) {
        return this.getLine(pos, hb, -1, -1, -1, 1);
    }

    private Line getLine(Vector2 pos, Hitbox hb, int x1Fct, int y1Fct, int x2Fct, int y2Fct) {
        float x1 = pos.x + (hb.getBoundingBoxWidth()/2f * x1Fct);
        float y1 = pos.y + (hb.getBoundingBoxHeight()/2f * y1Fct);
        float x2 = pos.x + (hb.getBoundingBoxWidth()/2f * x2Fct);
        float y2 = pos.y + (hb.getBoundingBoxHeight()/2f * y2Fct);
        return new Line(x1, y1, x2, y2);
    }
}
