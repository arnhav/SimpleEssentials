package com.github.arnhav.simpleessentials.systems.message;

import com.github.arnhav.simpleessentials.objects.System;

public class MessageSystem extends System {
    @Override
    public void enable() {
        MessageManager messageManager = new MessageManager();
        new MessageCommand("msg", messageManager);
        new ReplyCommand("r", messageManager);
    }

    @Override
    public void disable() {

    }
}
