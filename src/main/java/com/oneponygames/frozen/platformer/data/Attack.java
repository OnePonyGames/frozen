package com.oneponygames.frozen.platformer.data;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.oneponygames.frozen.base.ashley.component.PositionComponent;
import com.oneponygames.frozen.base.data.Line;
import com.oneponygames.frozen.base.data.hitbox.Hitbox;
import com.oneponygames.frozen.base.data.hitbox.RectPositionComponentHitbox;
import com.oneponygames.frozen.base.data.state.CharacterState;
import com.oneponygames.frozen.base.gfx.AnimationDrawable;
import com.oneponygames.frozen.platformer.events.combat.Damage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 17.02.2017.
 */
public class Attack<D extends Damage> {

    private final RangeMap<Integer, Line> frameNrPositionMap = TreeRangeMap.create();
    private final RectPositionComponentHitbox hitbox;
    private final AnimationDrawable animation;
    private final D damage;

    public Attack(PositionComponent basePos, AnimationDrawable animation, D d, float width, float height) {
        this.hitbox = new RectPositionComponentHitbox(width, height, basePos);
        this.animation = animation;
        this.damage = d;
    }

    /**
     * Beginning is inclusive and end is exclusive.
     * @param frameBegin
     * @param frameEnd
     */
    public void addKeyFramePoint(int frameBegin, int frameEnd, Vector2 positionBegin, Vector2 positionEnd) {
        this.frameNrPositionMap.put(Range.closedOpen(frameBegin, frameEnd), new Line(positionBegin, positionEnd));
    }

    public Hitbox getHitbox() {
        this.hitbox.setOffset(this.calculateOffset());

        return this.hitbox;
    }

    private Vector2 calculateOffset() {
        int idx = this.getKeyFrameIndex();
        Map.Entry<Range<Integer>, Line> entry = this.frameNrPositionMap.getEntry(idx);
        Line l = entry.getValue();

        float progress = (idx - entry.getKey().lowerEndpoint()) / (float)(entry.getKey().upperEndpoint() - entry.getKey().lowerEndpoint());
        float x = MathUtils.lerp(l.getFrom().x, l.getTo().x, progress);
        float y = MathUtils.lerp(l.getFrom().y, l.getTo().y, progress);

        return new Vector2(x, y);
    }

    public boolean isLive() {
        return this.getCurrentFrameOffset() != null;
    }

    private Line getCurrentFrameOffset() {
        int idx = this.getKeyFrameIndex();
        return this.frameNrPositionMap.get(idx);
    }

    private int getKeyFrameIndex() {
        return this.animation.getKeyFrameIndex();
    }

    public D getDamage() {
        return damage;
    }
}
