package com.oneponygames.frozen.base.eventsystem.events.debug;

import com.oneponygames.frozen.base.data.debug.DebugInfo;

/**
 * Created by Icewind on 24.01.2017.
 */
public class AddDebugInfoEvent implements DebugEvent {

    private final DebugInfo info;

    public AddDebugInfoEvent(DebugInfo info) {
        this.info = info;
    }

    public DebugInfo getInfo() {
        return info;
    }
}
