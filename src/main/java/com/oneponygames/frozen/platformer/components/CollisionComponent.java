package com.oneponygames.frozen.platformer.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by Icewind on 25.01.2017.
 */
public class CollisionComponent implements Component {

    public boolean contactLeft;
    public boolean contactRight;
    public boolean contactBottom;
    public boolean contactTop;

}
