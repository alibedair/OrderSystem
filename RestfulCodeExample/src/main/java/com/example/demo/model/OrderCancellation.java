package com.example.demo.model;

import com.example.demo.Common;

public class OrderCancellation {
    public boolean cancel(int id,Account account){
    if(Common.Orders.containsKey(id)){
        double refund = account.getBalance();
        refund += Common.Orders.get(id).totalDue;
        Common.Orders.get(id).status="cancelled";
        account.setBalance(refund);
        for (int i =0;i<Common.Orders.get(id).listOfProducts.size();i++) {
            int rp =Common.Orders.get(id).listOfProducts.get(i).getRemaining_parts() + 1;
            Common.Orders.get(id).listOfProducts.get(i).setRemaining_parts(rp);
        }
        return true;
    }
    return false;
    }
}
