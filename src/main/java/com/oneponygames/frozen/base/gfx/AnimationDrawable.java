package com.oneponygames.frozen.base.gfx;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.data.timing.Timing;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created by Icewind on 21.01.2017.
 */
public class AnimationDrawable extends StaticOffsetDrawable {

    private final Timing time;
    private final Animation<TextureRegion> animation;
    private final boolean looping;
    private final Set<AnimationListener> listeners = new LinkedHashSet<>();
    private final String name;

    public AnimationDrawable(String name, Timing time, Animation<TextureRegion> animation, Vector2 offset, boolean looping) {
        super(0, offset, animation.getKeyFrame(0).getRegionWidth(), animation.getKeyFrame(0).getRegionHeight());
        this.name = name;
        this.time = time;
        this.animation = animation;
        this.looping = looping;
    }

    public AnimationDrawable(Timing time, Animation<TextureRegion> animation, Vector2 offset, boolean looping) {
        this("no-name", time, animation, offset, looping);
    }

    public AnimationDrawable(Timing time, Animation<TextureRegion> animation, Vector2 offset) {
        this(time, animation, offset, false);
    }

    public AnimationDrawable(Timing time, Animation<TextureRegion> animation) {
        this(time, animation, new Vector2(0,0));
    }

    public void addAnimationListener(AnimationListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public TextureRegion getTexture() {
        TextureRegion texture = this.animation.getKeyFrame(this.time.getTime(), this.looping);
        if(!this.looping && this.animation.isAnimationFinished(this.time.getTime()))
            this.notifyListenersFinished();
        return texture;
    }

    private void notifyListenersFinished() {
        for(AnimationListener listener : this.listeners)
            listener.animationFinished(this);
    }

    public int getKeyFrameIndex() {
        return this.animation.getKeyFrameIndex(this.time.getTime());
    }
}
