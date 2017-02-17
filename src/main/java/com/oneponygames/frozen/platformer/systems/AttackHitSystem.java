package com.oneponygames.frozen.platformer.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.math.Intersector;
import com.oneponygames.frozen.base.ashley.component.HitBoxComponent;
import com.oneponygames.frozen.base.ashley.system.HookedIteratingSystem;
import com.oneponygames.frozen.base.data.hitbox.Hitbox;
import com.oneponygames.frozen.base.eventsystem.EventSink;
import com.oneponygames.frozen.base.eventsystem.EventSource;
import com.oneponygames.frozen.platformer.components.AttackComponent;
import com.oneponygames.frozen.platformer.data.Attack;
import com.oneponygames.frozen.platformer.events.combat.AttackCollisionEvent;
import com.oneponygames.frozen.utils.BaseMappers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Icewind on 17.02.2017.
 */
public class AttackHitSystem extends HookedIteratingSystem implements EventSource {

    private static final Family targets = Family.all(HitBoxComponent.class).get();

    private final List<AttackCollisionEvent> hitEvents = new ArrayList<>();
    private EventSink sink;

    public AttackHitSystem() {
        super(Family.all(AttackComponent.class).get());
    }

    @Override
    protected void afterUpdate() {
        for(AttackCollisionEvent event : this.hitEvents)
            this.sink.reportEvent(event);
    }

    @Override
    protected void beforeUpdate(float delta) {
        this.hitEvents.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        AttackComponent att = BaseMappers.attackMap.get(entity);

        if(att.hasActiveAttack()) {
            Attack a = att.getActiveAttack();

            if (a.isLive()) {
                Hitbox hb = a.getHitbox();

                for(Entity e : this.getEngine().getEntitiesFor(targets)) {
                    HitBoxComponent hbcomp = BaseMappers.hitboxMap.get(e);

                    if (Intersector.overlapConvexPolygons(hb.getHitboxArea(), hbcomp.getHitbox().getHitboxArea())) {
                        this.hitEvents.add(new AttackCollisionEvent(e, a));
                    }
                }
            }
        }
    }

    @Override
    public void setEventSink(EventSink sink) {
        this.sink = sink;
    }
}
