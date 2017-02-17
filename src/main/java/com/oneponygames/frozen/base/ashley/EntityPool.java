package com.oneponygames.frozen.base.ashley;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 17.02.2017.
 */
public interface EntityPool {

    public Entity createEntity();

    public <T extends Component> T createComponent (Class<T> componentType);
}
