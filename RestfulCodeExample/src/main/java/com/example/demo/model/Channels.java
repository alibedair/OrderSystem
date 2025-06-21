package com.example.demo.model;

import com.example.demo.Common;

public abstract class Channels implements Observer {
    protected int counter;
    protected Account account;
    protected String name;

    public void update() {
        NotificationSender notificationSender = new NotificationSender();
        counter++;
        NotificationsQueue notificationsQueue = NotificationsQueue.getInstance();
        notificationSender.sendMessage(account.getusername(), notificationsQueue);
}
}