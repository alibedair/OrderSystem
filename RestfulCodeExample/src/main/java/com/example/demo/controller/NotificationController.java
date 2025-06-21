package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Notification;
import com.example.demo.model.NotificationsQueue;
import com.example.demo.service.NotificationService;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/notification/")

public class NotificationController {
    @Autowired
    NotificationService notificationservice;

    @GetMapping("/getUnsentNotifications")
    public Queue<Notification> getNotifications() {
        NotificationsQueue notificationsQueue = NotificationsQueue.getInstance();
        if (notificationsQueue.getQueue().isEmpty()) {
            System.out.println("ALL notifications are sent");
            return null;
        } else {
            return notificationservice.getNotifications();
  }
}

}