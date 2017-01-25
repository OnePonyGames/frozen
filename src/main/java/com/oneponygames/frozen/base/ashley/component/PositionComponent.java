package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.oneponygames.frozen.base.data.Position;

/**
 * Created by Icewind on 23.01.2017.
 */
public class PositionComponent implements Component {

    private final Position position;

    public PositionComponent(Position position) {
        this.position = position;
    }

    public float getX() {
        return this.position.getX();
    }

    public float getY() {
        return this.position.getY();
    }

    public Vector2 getPositionVector() {
        return position.getPositionVector();
    }

    public float getRotation() {
        return this.position.getRotation();
    }

    public void move(Vector2 movement) {
        this.position.move(movement);
    }
}
