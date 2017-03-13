package com.oneponygames.frozen.base.data.state;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.oneponygames.frozen.base.ashley.component.EventSinkComponent;
import com.oneponygames.frozen.base.eventsystem.EventSink;
import com.oneponygames.frozen.base.eventsystem.EventSource;
import com.oneponygames.frozen.base.logic.AiContext;
import com.oneponygames.frozen.utils.BaseMappers;

/**
 * Created by Icewind on 17.02.2017.
 */
public abstract class AiState<C extends AiContext, S extends CharacterState> extends EntityState<AiState> {

    private final C context;
    private final EventSinkComponent eventSinkComponent;
    private float activeTime;

    public AiState(String label, Entity entity, C context) {
        super(label, entity);
        this.context = context;
        this.eventSinkComponent = BaseMappers.eventSink.get(entity);
    }

    protected final C getContext() {
        return context;
    }

    public S getCharacterState() {
        return (S) BaseMappers.stateMap.get(this.getEntity()).getStateMachine().peekCurrentState();
    }

    protected EventSink getEventSink() {
        return this.eventSinkComponent.getEventSink();
    }

    public final void update(float deltaTime) {
        this.activeTime += deltaTime;

        this.updateInternal(deltaTime, this.activeTime);
    }

    protected abstract void updateInternal(float deltaTime, float activeTime);

    protected void resetActive() {
        this.activeTime = 0;
    }
}
