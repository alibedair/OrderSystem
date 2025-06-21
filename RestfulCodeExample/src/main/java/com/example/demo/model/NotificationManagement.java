package com.example.demo.model;

import java.util.Map;

public interface NotificationManagement {
    String generateContent(Map<String, String> placeholderValues);

}
