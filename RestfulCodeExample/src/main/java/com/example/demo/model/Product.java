package com.example.demo.model;

public class Product {
    private String serialNumber;
    private String name;
    private String vendor;
    private String category;
    private double price;
    private int remaining_parts;

    public Product(String serialNumber,String name,String vendor,String category,double price,int remaining_parts) {
        this.serialNumber=serialNumber;
        this.name = name;
        this.vendor = vendor;
        this.category = category;
        this.price = price;
        this.remaining_parts = remaining_parts;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getVendor(){
        return vendor;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getRemaining_parts() {
        return remaining_parts;
    }

    public void setRemaining_parts(int remaining_parts) {
        this.remaining_parts = remaining_parts;
    }
    @Override
    public String toString() {
        return "Product" +"serialNumber=" + getSerialNumber()+", name=" + getName()+", vendor="+getVendor()+", category="+getCategory()+", remaining parts="+getRemaining_parts()+", price="+getPrice();
}
}