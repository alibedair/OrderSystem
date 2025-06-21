package com.example.demo.model;

import java.util.List;

public class CompoundOrderpayment {
    public int payperorder (Account account,List<Account> accounts,CompoundOrder order){
        int counter = 0;
       Order orderUser =order.getOrders().get(0);
       OrderPayment orderPayment = new OrderPayment();
        boolean isPaid=orderPayment.payOrder(orderUser,account);
        if(isPaid)
        counter++;
        int j =0;
       for (int i =1;i<order.getOrders().size();i++){
         isPaid= orderPayment.payOrder(order.getOrders().get(i),accounts.get(j));
         j++;
         if(isPaid){
             counter++;
         }
       }
        return counter;
    }
}
