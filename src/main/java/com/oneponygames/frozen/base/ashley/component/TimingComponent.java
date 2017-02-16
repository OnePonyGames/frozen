package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.oneponygames.frozen.base.data.timing.Timing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Icewind on 20.01.2017.
 */
public class TimingComponent implements Component {

    private final List<Timing> timings;

    public TimingComponent() {
        this.timings = new ArrayList<Timing>();
    }

    public TimingComponent(Timing... t) {
        this();
        for(Timing t1 : t)
            this.addTiming(t1);
    }

    public void addTiming(Timing t) {
        this.timings.add(t);
    }

    public void addTime(float deltaTime) {
        for(Timing t : timings) {
            t.addTime(deltaTime);
        }
    }
}
