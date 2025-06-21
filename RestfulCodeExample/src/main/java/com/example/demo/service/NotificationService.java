package com.example.demo.service;

import com.example.demo.Common;
import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationService {
    NotificationsQueue notificationsQueue=NotificationsQueue.getInstance();
    public  Queue<Notification> getNotifications() {
        try {
            return notificationsQueue.getQueue();
        } catch (Exception e) {
            System.out.println("Exception as" + e.getMessage());
        }
       return null;}
}