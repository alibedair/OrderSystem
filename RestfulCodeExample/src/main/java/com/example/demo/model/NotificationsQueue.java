package com.example.demo.model;

import java.util.*;

public class NotificationsQueue {
    private Queue<Notification> queueof;

    public void enqueueNotification(Notification notification) {
        queueof.add(notification);
    }

    static NotificationsQueue notificationsQueue;

    public Notification dequeueNotification() {
        return queueof.poll();
    }

    public Queue<Notification> getQueue() {
        return queueof;
    }

    public static NotificationsQueue getInstance() {
        if (notificationsQueue == null) {
            return new NotificationsQueue();
        } else {
            return notificationsQueue;
        }
    }

    private NotificationsQueue() {
        queueof = new LinkedList<>();
}
}