package com.example.demo.model;

import com.example.demo.Common;

public class OrderPayment {
    public boolean payOrder(Order order,Account account){
        System.out.println("order due = "+order.totalDue);
        if(account.getBalance()<order.totalDue) {
            order.status = "unpaid";
            order.setDetails();
            return false;
        }
        else{
            double newBalance = account.getBalance();
            newBalance -=order.totalDue;
            order.Shipping_Status="not shipped";
            System.out.println(order.totalDue);
            account.setBalance(newBalance);
            order.status = "paid";
            order.setDetails();
            for (int i =0;i<Common.Orders.get(order.getID()).listOfProducts.size();i++) {
                int rp =Common.Orders.get(order.getID()).listOfProducts.get(i).getRemaining_parts() - 1;
                Common.Orders.get(order.getID()).listOfProducts.get(i).setRemaining_parts(rp);
            }
            return true;
            }
        }
    }

