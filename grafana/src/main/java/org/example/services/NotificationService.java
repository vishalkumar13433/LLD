package org.example.services;

import org.example.dao.NotificationChannel;
import org.example.enums.ChannelType;

import java.util.*;

public class NotificationService implements INotifficationService{

    Map<String, List<String>> labelToEmailMap;
    Map<String, List<String>> labelToPhoneMap; // can be fetched from external service

    Map<Integer, List<NotificationChannel>> priorityToChannelMap;

    public NotificationService() {
        priorityToChannelMap = new HashMap<>();
        NotificationChannel channel = new NotificationChannel();
        channel.channelType = ChannelType.SMS;
        priorityToChannelMap.put(0, Arrays.asList(channel));
    }

    @Override
    public void notifyForAlert(int priority, String label, String message) throws Exception {
        List<NotificationChannel> channels =  priorityToChannelMap.get(priority);
        if (channels == null || channels.isEmpty()) {
            throw new Exception("Invalid config");
        }

        for (NotificationChannel channel: channels) {
            channel.notifyUsers();
        }
    }
}
