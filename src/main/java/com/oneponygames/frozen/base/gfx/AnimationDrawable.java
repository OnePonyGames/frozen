package com.oneponygames.frozen.base.gfx;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.data.timing.Timing;


/**
 * Created by Icewind on 21.01.2017.
 */
public class AnimationDrawable extends StaticOffsetDrawable {

    private final Timing time;
    private final Animation<TextureRegion> animation;

    public AnimationDrawable(Timing time, Animation<TextureRegion> animation, Vector2 position) {
        super(0, position);
        this.time = time;
        this.animation = animation;
    }

    public AnimationDrawable(Timing time, Animation<TextureRegion> animation) {
        this(time, animation, new Vector2(0,0));
    }

    @Override
    public TextureRegion getTexture() {
        return this.animation.getKeyFrame(this.time.getTime(), true);
    }
}
