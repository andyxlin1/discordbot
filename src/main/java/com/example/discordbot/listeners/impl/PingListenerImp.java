package com.example.discordbot.listeners.impl;

import com.example.discordbot.listeners.PingListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class PingListenerImp implements PingListener{
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().equals("!ping")) {
            messageCreateEvent.getChannel().sendMessage("pong");
        }
    }
}
