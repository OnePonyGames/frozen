package com.oneponygames.frozen.base.data.stats;

/**
 * Created by Icewind on 06.03.2017.
 */
public interface StatModifier {

    enum StatModifierType {
        ADDITIVE, MULTIPLICATIVE
    }

    public StatModifierType getType();

    public String getModifiedStat();

    public float modifyValue(float value);

    public int modifyValue(int value);
}
