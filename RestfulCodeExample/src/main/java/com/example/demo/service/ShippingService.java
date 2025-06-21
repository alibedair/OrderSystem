package com.example.demo.service;
import com.example.demo.model.CompoundOrder;
import com.example.demo.model.Order;
public interface ShippingService
{
    public boolean shipSimpleOrder(int orderid);
    public boolean shipCompundOrder(int orderid);
    public void deductShippingFeesFromCustomer(Order order, float shippingFees);
    public float calculateShippingFees(Order order);





}
