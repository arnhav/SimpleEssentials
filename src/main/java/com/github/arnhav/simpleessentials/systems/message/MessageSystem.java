package com.github.arnhav.simpleessentials.systems.message;

import com.github.arnhav.simpleessentials.objects.System;

public class MessageSystem extends System {
    @Override
    public void enable() {
        MessageManager messageManager = new MessageManager();

        new ReplyCommand("r", messageManager);

        new MessageListener(messageManager);
    }

    @Override
    public void disable() {

    }
}
