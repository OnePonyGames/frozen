package com.oneponygames.frozen.base.data.stats;

/**
 * Created by Icewind on 06.03.2017.
 */
public class AdditiveStatModifier extends BasicStatModifier {

    private final float modifier;

    public AdditiveStatModifier(String stat, float modifier) {
        super(stat);
        this.modifier = modifier;
    }

    @Override
    public StatModifierType getType() {
        return StatModifierType.ADDITIVE;
    }

    @Override
    public float modifyValue(float value) {
        return value + this.modifier;
    }

    @Override
    public int modifyValue(int value) {
        return (int) (value + this.modifier);
    }
}
