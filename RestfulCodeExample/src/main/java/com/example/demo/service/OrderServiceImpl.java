package com.example.demo.service;

import com.example.demo.Common;
import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public void  makeOrder(Order order) {
            Common.Orders.put(order.getID(), order);
    }
    public boolean addProduct(String id,Order order) {
        Product product = Common.Products.get(id);
        Common.Orders.put(order.getID(), order);
        if(product!=null) {
            order.listOfProducts.add(product);
            order.totalDue += product.getPrice();
            System.out.println(order.totalDue);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean CancelOrder(int id) {
        try {
            if(Common.Orders.get(id) == null){
                return false;
            }
            OrderCancellation orderCancellation= new OrderCancellation();
            orderCancellation.cancel(id, (Common.Accounts.get(Common.Orders.get(id).getAccountUsername())));
            Common.Orders.remove(id);
        } catch (Exception e) {
            System.out.println("Exception in Orders map as" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Order getOrder(int id) {
        try {
            return Common.Orders.get(id);
        } catch (Exception e) {
            System.out.println("Exception in getorder as" + e.getMessage());
        }
        return null;
    }

}
