package com.oneponygames.frozen.base.eventsystem.subscriber;

import com.oneponygames.frozen.base.eventsystem.BasicEventSource;
import com.oneponygames.frozen.base.eventsystem.EventConsumer;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.base.eventsystem.EventSystem;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;
import com.oneponygames.frozen.base.eventsystem.events.physics.PhysicsUpdateEvent;

/**
 * Created by Icewind on 24.01.2017.
 */
public class FixedPhysicsStepSource extends BasicEventSource  implements EventSubscriber, EventConsumer<ScreenRenderEvent> {

    private final float physicsTickRate;
    private float accumulator;

    public FixedPhysicsStepSource(float physicsTickRate) {
        this.physicsTickRate = physicsTickRate;
    }

    public FixedPhysicsStepSource() {
        this( 1 / 300f);
    }

    @Override
    public void subscribeTo(EventSystem system) {
        system.addConsumer(ScreenRenderEvent.class, this);
    }

    @Override
    public void event(ScreenRenderEvent event) {
        this.accumulator += event.getDelta();

        while(this.accumulator >= this.physicsTickRate) {
            this.getEventSystem().reportEvent(new PhysicsUpdateEvent(this.physicsTickRate));
            this.accumulator-=this.physicsTickRate;
        }
    }
}
