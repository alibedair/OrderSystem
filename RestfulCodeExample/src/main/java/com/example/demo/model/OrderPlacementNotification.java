package com.example.demo.model;

import java.util.*;

public class OrderPlacementNotification extends Notification {
    public static int numberofSending = 0;

    public OrderPlacementNotification(Placeholder placeholdersValues) {
        numberofSending++;
        this.placeholdersValues = placeholdersValues;
    }

    public static int numberofSending() {
        return numberofSending;
    }

    @Override
    public void CreateMessage() {
        int ID = getPlaceholdersValues().orderid;
        language = "English";
        subject = "Order Placement Notification";
        content = String.format("Dear %s, your order for %s has been placed. Thank you for choosing our store.",
                getPlaceholdersValues().account.getusername(), ID);
    }
}