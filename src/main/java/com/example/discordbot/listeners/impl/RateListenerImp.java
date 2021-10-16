package com.example.discordbot.listeners.impl;

import java.util.regex.Pattern;

import com.example.discordbot.listeners.RateListener;
import com.example.discordbot.services.impl.BotService;


import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.regex.Matcher;

@Component
public class RateListenerImp implements RateListener {
    @Autowired
    private BotService botServicie;
    private final static Pattern pattern = Pattern.compile("!rate (\\w+)");
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!rate")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            if (matcher.matches()) {

                int rating = (int) Math.floor(Math.random() * 100) + 1;
                botServicie.sendMessage(
                    messageCreateEvent.getMessageAuthor(),
                    "Rate Calculator",
                    messageCreateEvent.getMessageAuthor().getDisplayName() + " is " + rating + 
                     "% " + matcher.group(1),
                    "Rate Again?",
                    "https://as2.ftcdn.net/v2/jpg/01/04/93/67/500_F_104936774_oDVc6MCEGatduShrgQkYlHilq8lZiPKN.jpg",
                    messageCreateEvent.getChannel());
               

            } else {
                // Tell them wrong syntax.

                botServicie.sendMessage(
                    messageCreateEvent.getMessageAuthor(),
                    "Rate Calculator",
                    "Are you trying to use the !rate command? " +
                "Please use the syntax `!rate [word]`. Thanks!",
                    "Rate Again?",
                    null,
                    messageCreateEvent.getChannel());
               
            }
        }
        
    }
    
}
