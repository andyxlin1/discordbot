package com.example.discordbot.services.impl;

import java.awt.Color;

import com.example.discordbot.services.BotServiceInterface;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.springframework.stereotype.Component;

@Component
public class BotService implements BotServiceInterface{
    public void sendMessage (MessageAuthor author, String title, String description, String footer, String thumbnail, TextChannel channel) {
        int red = (int) Math.floor(Math.random() * 255);
        int green = (int) Math.floor(Math.random() * 255);
        int blue = (int) Math.floor(Math.random() * 255);

        new MessageBuilder().setEmbed(new EmbedBuilder()
                .setAuthor(author)
                .setTitle(title)
                .setDescription(description)
                .setFooter(footer)
                .setThumbnail(thumbnail)
                .setColor(new Color(red,green,blue)))
                .send(channel);
    }
}