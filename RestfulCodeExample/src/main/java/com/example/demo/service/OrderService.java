package com.example.demo.service;

import com.example.demo.Common;
import com.example.demo.model.Order;
import com.example.demo.model.Product;

public interface OrderService {
    public void makeOrder(Order order);
    public boolean CancelOrder(int id);
    public Order getOrder(int id);
    public boolean addProduct(String id,Order order);
}
