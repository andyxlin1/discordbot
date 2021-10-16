package com.example.discordbot.services;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;

public interface BotServiceInterface {
    
    void sendMessage (MessageAuthor author, String title, String description, String footer, String thumbnail, TextChannel channel); 
    
}