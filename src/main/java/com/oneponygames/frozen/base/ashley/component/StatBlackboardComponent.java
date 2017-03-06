package com.oneponygames.frozen.base.ashley.component;

import com.badlogic.ashley.core.Component;
import com.oneponygames.frozen.base.data.stats.StatBlackboard;
import com.oneponygames.frozen.base.data.stats.StatModifier;

/**
 * Created by Icewind on 06.03.2017.
 */
public class StatBlackboardComponent implements Component {

    private final StatBlackboard blackboard;

    public StatBlackboardComponent() {
        this.blackboard = new StatBlackboard();
    }

    public void addModifier(StatModifier mod) {
        this.blackboard.addModifier(mod);
    }

    public void removeModifier(StatModifier mod) {
        this.blackboard.removeModifier(mod);
    }

    public float getFloatValue(String stat) {
        return this.blackboard.getFloatValue(stat);
    }

    public int getIntValue(String stat) {
        return this.blackboard.getIntValue(stat);
    }

    public void addBaseValue(String stat, float addition) {
        this.blackboard.addToBaseValue(stat, addition);
    }

    public void setBaseValue(String stat, float newBaseValue) {
        this.blackboard.setBaseValue(stat, newBaseValue);
    }
}
