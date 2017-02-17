package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.oneponygames.frozen.base.data.hitbox.Hitbox;

/**
 * Created by Icewind on 25.01.2017.
 */
public class HitBoxComponent implements Component {

    private Hitbox hitbox;

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
}
