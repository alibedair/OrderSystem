package com.example.demo.model;

import java.util.*;

public abstract class Notification implements NotificationI {
    protected String language;
    protected Placeholder placeholdersValues;
    protected String content;
    protected String subject;
    protected List<Observer> observers;

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public Placeholder getPlaceholdersValues() {
        return placeholdersValues;
    }

    public void setPlaceholdersValues(Placeholder placeholdersValues) {
        this.placeholdersValues = placeholdersValues;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public abstract void CreateMessage();

    @Override
    public void unsubscribe(Channels channels) {
        observers.remove(channels);
    }

    @Override
    public void subscribe(Channels channels) {
        observers.add(channels);
    }

    @Override
    public void Notify() {
        for (Observer observer : observers) {
            observer.update();
 }
}
}