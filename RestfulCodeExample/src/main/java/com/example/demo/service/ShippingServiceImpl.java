package com.example.demo.service;

import com.example.demo.SearchEngine;
import com.example.demo.model.CompoundOrder;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Common;
import com.example.demo.model.Account;
import com.example.demo.SearchEngine;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Override
    public boolean shipSimpleOrder(int OrderId) {
        try {
            Order order = Common.Orders.get(OrderId);
            if (order == null) {
                return false;
            }
            float ShippingFees = calculateShippingFees(order);
            deductShippingFeesFromCustomer(order, ShippingFees);
            order.Shipping_Status="Shipped";
            // Common.shipping.put(order,new Shipping(ShippingFees,"Dokki"));
            return true;
        }catch (Exception e) {
                System.out.println("Exception while shipping order: " + e.getMessage());
                return false;
            }

        }

    @Override
    public boolean shipCompundOrder(int OrderId) {

        CompoundOrder compoundOrder = (CompoundOrder) Common.Orders.get(OrderId);

        SearchEngine searchEngine=new SearchEngine();
        Account useraccount=searchEngine.getAccount(compoundOrder.getAccountUsername());
        float tshippingfees=compoundOrder.getNumberofproducts()*5;
        float shippingfeesperperson=tshippingfees/(compoundOrder.getFriends().size()+1);
        System.out.println("shipping fees per person will be "+shippingfeesperperson);
        useraccount.setBalance(useraccount.getBalance()-shippingfeesperperson);

        for (Account account : compoundOrder.getFriends()) {
            if (account.getBalance()>shippingfeesperperson)
            {
                account.setBalance(account.getBalance()-shippingfeesperperson);
            }

        }

            return true;

    }


    @Override
    public void deductShippingFeesFromCustomer(Order order, float shippingFees) {
        Common.Accounts.get(order.getAccountUsername()).deductBalance(shippingFees);

    }

    @Override
    public float calculateShippingFees(Order order) {
        return order.getListOfProducts().size()*10f;
    }




}