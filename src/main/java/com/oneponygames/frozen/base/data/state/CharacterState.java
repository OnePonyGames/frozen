package com.oneponygames.frozen.base.data.state;


import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class CharacterState extends EntityState<CharacterState>  {

    private final boolean attackState;

    public CharacterState(String label, boolean attackState, Entity entity) {
        super(label, entity);
        this.attackState = attackState;
    }

    public boolean isAttackState() {
        return this.attackState;
    }

    public abstract void update(float deltaTime, float accumulator);

    @Override
    public String toString() {
        return "CharacterState{" +
                "entity=" + this.getEntity() +
                ", label='" + this.getLabel() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterState)) return false;

        CharacterState that = (CharacterState) o;

        if (!this.getEntity().equals(that.getEntity())) return false;
        return this.getLabel().equals(that.getLabel());
    }

    @Override
    public int hashCode() {
        int result = this.getEntity().hashCode();
        result = 31 * result + this.getLabel().hashCode();
        return result;
    }
}
