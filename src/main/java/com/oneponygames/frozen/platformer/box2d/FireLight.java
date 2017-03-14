package com.oneponygames.frozen.platformer.box2d;

import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.google.common.primitives.Doubles;
import com.oneponygames.frozen.utils.EndlessIterator;
import com.oneponygames.frozen.utils.OctaveNoise;
import com.oneponygames.frozen.utils.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Icewind on 14.03.2017.
 */
public class FireLight extends PointLight {

    private final EndlessIterator<Double> iterator;
    private float distanceVariation = 0.5f;
    private final float baseDistance;
    private float accumulator = 0;

    public FireLight(RayHandler rayHandler, int rays, Color color, float distance, float x, float y) {
        super(rayHandler, rays, color, distance, x, y);
        this.baseDistance = distance;
        OctaveNoise noise = new OctaveNoise(4, 0.75, RandomUtil.nextLong());
        List<Double> data = new ArrayList<>(Doubles.asList(noise.generateLine(100)));
        List<Double> inverse = new ArrayList<>(data);
        Collections.reverse(inverse);
        data.addAll(inverse);
        this.iterator = new EndlessIterator<Double>(data);
    }

    @Override
    public void update() {
        super.update();
        this.accumulator += Gdx.graphics.getDeltaTime();
        if(this.accumulator >= 0.05) {
            float newDist = (float) ((1 + (this.iterator.next() - 0.5f) * this.distanceVariation) * this.baseDistance);
            super.setDistance(newDist);
            this.accumulator = 0;
        }
    }
}
