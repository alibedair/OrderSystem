package com.example.demo.model;

import com.example.demo.Common;

import java.util.ArrayList;
import java.util.List;

public abstract class  Order {
    public List<Product> listOfProducts;
    public String Shipping_Status;
    protected List<String> details;
    public   float totalDue =0;
    protected String status;
    protected  int ID;
    protected String accountUsername;

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
    public List<String> getDetails() {
        return details;
    }

    public void setDetails() {
        int n = listOfProducts.size();
        float p = 0;
        for(Product product:listOfProducts){
            p += product.getPrice();
        }
        String s1 = "The number of all products purchases in the order is " +n;
        String s2 = "The total price of all order = "+p;
        details.add("status : "+status);
        details.add(s1);
        details.add(s2);
    }
}
