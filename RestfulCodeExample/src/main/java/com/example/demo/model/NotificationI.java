package com.example.demo.model;

public interface NotificationI {
    public void subscribe(Channels channels);

    public void unsubscribe(Channels channels);

    public void Notify();
}