package com.oneponygames.frozen.base.gfx;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.data.state.CharacterState;
import com.oneponygames.frozen.base.ashley.component.CharacterStateComponent;
import com.oneponygames.frozen.base.data.state.StateChangeListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 16.02.2017.
 */
public class CharacterStateDrawable implements Drawable, StateChangeListener<CharacterState> {

    private final CharacterStateComponent state;
    private final Map<CharacterState, Drawable> stateDrawableMap = new HashMap<>();
    private Drawable currentDrawable;

    public CharacterStateDrawable(CharacterStateComponent state) {
        this.state = state;
        this.state.getStateMachine().addStateChangeListener(this);
    }

    public void putDrawable(CharacterState state, Drawable drawable) {
        this.stateDrawableMap.put(state, drawable);
    }

    @Override
    public float getWidth() {
        if(this.currentDrawable!=null)
            return this.currentDrawable.getWidth();
        return 0;
    }

    @Override
    public float getHeight() {
        if(this.currentDrawable!=null)
            return this.currentDrawable.getHeight();
        return 0;
    }

    @Override
    public float getXOffset() {
        if(this.currentDrawable!=null)
            return this.currentDrawable.getXOffset();
        return 0;
    }

    @Override
    public float getYOffset() {
        if(this.currentDrawable!=null)
            return this.currentDrawable.getYOffset();
        return 0;
    }

    @Override
    public TextureRegion getTexture() {
        if(this.currentDrawable!=null)
            return this.currentDrawable.getTexture();
        return null;
    }

    @Override
    public Vector2 getPositionOffset() {
        if(this.currentDrawable!=null)
            return this.currentDrawable.getPositionOffset();
        return null;
    }

    @Override
    public boolean doDraw() {
        return this.currentDrawable!=null;
    }

    @Override
    public float getAlpha() {
        if(this.currentDrawable!=null)
            return this.currentDrawable.getAlpha();
        return 0;
    }

    @Override
    public float getRotationOffset() {
        if(this.currentDrawable!=null)
            return this.currentDrawable.getRotationOffset();
        return 0;
    }

    @Override
    public void notifyStateChange(CharacterState oldState, CharacterState newState) {
        this.currentDrawable = this.stateDrawableMap.get(newState);
    }
}
