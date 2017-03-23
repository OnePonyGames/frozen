package com.oneponygames.frozen.base.eventsystem;

import com.oneponygames.frozen.base.eventsystem.events.GameEvent;
import com.oneponygames.frozen.base.gfx.AnimationDrawable;
import com.oneponygames.frozen.base.gfx.AnimationListener;

import java.util.HashMap;
import java.util.Map;

/**
 * This class will translate completed animations into events.
 *
 * Created by Icewind on 16.02.2017.
 */
public class AnimationEventSource extends BasicEventSource implements AnimationListener {

    private final Map<AnimationDrawable, GameEvent> animationEventMap = new HashMap<>();

    public <C extends GameEvent> void setAnimationEvent(AnimationDrawable animation, C event) {
        this.animationEventMap.put(animation, event);
        animation.addAnimationListener(this);
    }

    @Override
    public void animationFinished(AnimationDrawable finishedAnimation) {
        GameEvent event = this.animationEventMap.get(finishedAnimation);
        if(event!=null) {
            this.getEventSink().reportEvent(event);
        }
    }

    public void clear() {
        this.animationEventMap.clear();
    }
}
