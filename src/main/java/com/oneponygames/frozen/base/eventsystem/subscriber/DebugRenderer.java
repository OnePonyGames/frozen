package com.oneponygames.frozen.base.eventsystem.subscriber;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.oneponygames.frozen.base.data.debug.DebugInfo;
import com.oneponygames.frozen.base.eventsystem.EventConsumer;
import com.oneponygames.frozen.base.eventsystem.EventSubscriber;
import com.oneponygames.frozen.base.eventsystem.EventService;
import com.oneponygames.frozen.base.eventsystem.events.debug.AddDebugInfoEvent;
import com.oneponygames.frozen.base.eventsystem.events.lifecycle.ScreenRenderEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Icewind on 24.01.2017.
 */
public class DebugRenderer implements EventSubscriber, EventConsumer<ScreenRenderEvent> {

    private static final float X_OFFSET = 12;
    private static final float Y_OFFSET = 10;

    private final List<DebugInfo> debug = new ArrayList<>();
    private final SpriteBatch batch;
    private final BitmapFont font;

    public DebugRenderer(SpriteBatch batch, BitmapFont font) {
        this.batch = batch;
        this.font = font;
    }

    @Override
    public void subscribeTo(EventService system) {
        system.addConsumer(this, ScreenRenderEvent.class);
        system.addConsumer(e -> this.addDebugInfo(e.getInfo()), AddDebugInfoEvent.class);
    }

    @Override
    public void event(ScreenRenderEvent event) {
        this.batch.begin();
        this.batch.setColor(Color.WHITE);

        for(int i=0;i<debug.size();i++) {
            String string = debug.get(i).getLabel() + ": " + debug.get(i).getValue();
            float y = Gdx.graphics.getHeight() - Y_OFFSET;
            font.draw(this.batch, string, X_OFFSET, y - i * 15);
        }

        this.batch.end();
    }

    public void addDebugInfo(DebugInfo info) {
        this.debug.add(info);
    }
}
