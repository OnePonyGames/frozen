package com.oneponygames.frozen.base.data.stats;

/**
 * Created by Icewind on 06.03.2017.
 */
public class MultiplicativeStatModifier extends BasicStatModifier {

    private final float multiplier;

    public MultiplicativeStatModifier(String stat, float multiplier) {
        super(stat);
        this.multiplier = multiplier;
    }

    @Override
    public StatModifierType getType() {
        return StatModifierType.MULTIPLICATIVE;
    }

    @Override
    public float modifyValue(float value) {
        return value * this.multiplier;
    }

    @Override
    public int modifyValue(int value) {
        return (int) (value * this.multiplier);
    }
}
