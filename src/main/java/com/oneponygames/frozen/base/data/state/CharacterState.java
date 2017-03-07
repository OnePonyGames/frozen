package com.oneponygames.frozen.base.data.state;


import com.badlogic.ashley.core.Entity;

/**
 * Created by Icewind on 16.02.2017.
 */
public abstract class CharacterState extends EntityState<CharacterState>  {

    private float accumulator = 0;

    public CharacterState(String label, Entity entity) {
        super(label, entity);
    }

    /**
     *
     * @param deltaTime
     * @param globalTime Time alive for the Entity
     */
    public final void update(float deltaTime, float globalTime) {
        this.accumulator += deltaTime;
        this.update(deltaTime, accumulator, globalTime);
    }

    /**
     *
     * @param deltaTime Time since last render.
     * @param accumulator Time in this state.
     * @param globalTime Time alive for the Entity.
     */
    protected abstract void update(float deltaTime, float accumulator, float globalTime);

    @Override
    protected void onActivation() {
        this.accumulator = 0;
    }

    @Override
    public String toString() {
        return "CharacterState{" +
                "label='" + this.getLabel() + '\'' +
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
