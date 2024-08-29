package org.example.dao;

import org.example.enums.ChannelType;

public class NotificationChannel {
    public ChannelType channelType;

    public NotificationChannel() {
    }

    public void notifyUsers() {
        System.out.println("Notifiying using" + channelType.name());
    }
}
