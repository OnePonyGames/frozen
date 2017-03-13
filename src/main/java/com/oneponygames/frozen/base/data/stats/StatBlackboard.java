package com.oneponygames.frozen.base.data.stats;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import com.oneponygames.frozen.base.data.Blackboard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Icewind on 06.03.2017.
 */
public class StatBlackboard implements Comparator<StatModifier> {

    private final Multimap<String, StatModifier> modifierMultimap = TreeMultimap.create(String::compareTo, this);
    private Blackboard baseBlackboard;

    public void setBaseBlackboard(Blackboard baseBlackboard) {
        this.baseBlackboard = baseBlackboard;
    }

    public float getFloatValue(String stat) {
        return this.getModifiedFloatValue(stat);
    }

    public int getIntValue(String stat) {
        return this.getModifiedIntValue(stat);
    }

    private Float getValue(String stat) {
        if(!this.baseBlackboard.contains(stat))
            throw new StatNotDefinedException(stat);

        return this.baseBlackboard.get(stat, Float.class);
    }

    private Integer getModifiedIntValue(String stat) {
        return this.applyIntModifiers(stat, this.getValue(stat).intValue());
    }

    private Float getModifiedFloatValue(String stat) {
        return this.applyFloatModifiers(stat, this.getValue(stat));
    }

    private Float applyFloatModifiers(String stat, Float value) {
        for(StatModifier mod : this.modifierMultimap.get(stat))
            value = mod.modifyValue(value);

        return value;
    }

    private Integer applyIntModifiers(String stat, Integer value) {
        for(StatModifier mod : this.modifierMultimap.get(stat))
            value = mod.modifyValue(value);

        return value;
    }

    public void addModifier(StatModifier mod) {
        this.modifierMultimap.put(mod.getModifiedStat(), mod);
    }

    public void removeModifier(StatModifier mod) {
        this.modifierMultimap.remove(mod.getModifiedStat(), mod);
    }

    public void addToBaseValue(String stat, float addition) {
        float value = this.getValue(stat);
        this.setBaseValue(stat, value + addition);
    }

    public void setBaseValue(String stat, float newBaseValue) {
        this.baseBlackboard.put(stat, newBaseValue);
    }

    @Override
    public int compare(StatModifier o1, StatModifier o2) {
        if(o1.getType().equals(o2.getType()))
            return 0;
        if(o1.getType().equals(StatModifier.StatModifierType.ADDITIVE))
            return 1;

        return -1;
    }
}
