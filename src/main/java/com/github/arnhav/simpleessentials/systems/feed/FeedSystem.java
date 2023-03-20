package com.github.arnhav.simpleessentials.systems.feed;

import com.github.arnhav.simpleessentials.objects.System;

public class FeedSystem extends System {
    @Override
    public void enable() {
        new Feed("feed");
    }

    @Override
    public void disable() {

    }
}
