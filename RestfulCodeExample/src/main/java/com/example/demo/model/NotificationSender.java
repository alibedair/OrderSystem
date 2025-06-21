package com.example.demo.model;

import com.example.demo.Common;
import com.example.demo.SearchEngine;

public class NotificationSender {
    public void sendMessage(String username, NotificationsQueue notificationsQueue) {
        Common.Accounts.get(username).inbox.add(notificationsQueue.dequeueNotification());
}
}