package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;
import com.oneponygames.frozen.base.gfx.Drawable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Icewind on 23.01.2017.
 */
public class DrawableComponent implements Component, Pool.Poolable {

    private final List<Drawable> drawables = new ArrayList<>();

    public DrawableComponent() {
        this(null);
    }

    public DrawableComponent(Drawable drawable) {
        this.addDrawable(drawable);
    }

    public void addDrawable(Drawable drawable) {
        if(drawable != null)
            this.drawables.add(drawable);
    }

    public Collection<Drawable> getDrawables() {
        return this.drawables;
    }

    @Override
    public void reset() {
        this.drawables.clear();
    }
}
