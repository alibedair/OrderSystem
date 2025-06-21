package com.example.demo.model;

import com.example.demo.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrder extends Order  {
    private List<Order> orders;
    private static int  Id_Generator=99;
    private List<Account> friends;
    private int numberofproducts;
    public CompoundOrder() {
        orders = new ArrayList<>();
        totalDue = 0;
        friends = new ArrayList<>();
        details = new ArrayList<>();
        listOfProducts = new ArrayList<>();
        Id_Generator++;
        ID = Id_Generator;
    }

    public List<Account> getFriends() {
        return friends;
    }

    public void setFriends(List<Account> friends) {
        this.friends = friends;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void removeOrder(Order order) {
     orders.remove(order);
    }
    public List<Order> getChild() {
        return orders;
    }
    public void setnumberofproducts(int n)
    {
        this.numberofproducts=n;

    }

    public int getNumberofproducts() {
        return numberofproducts;
    }
}
