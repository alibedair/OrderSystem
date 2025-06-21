package com.example.demo.model;

import java.util.*;

public class OrderShipmentNotification extends Notification {
    public static int numberofSending = 0;

    public OrderShipmentNotification() {
        numberofSending++;
    }

    public static int numberofSending() {
        return numberofSending;
    }

    @Override
    public void CreateMessage() {
        language = "English";
        subject = "Order Shipment Notification";
        int order = getPlaceholdersValues().orderid;
        String userName = getPlaceholdersValues().account.getusername();
        System.out.println("first val: " + userName);
        content = String.format("Dear %s, your order with id " + order + " has been shipped.", userName);
        NotificationsQueue notificationsQueue = NotificationsQueue.getInstance();
        notificationsQueue.enqueueNotification(this);
}
}