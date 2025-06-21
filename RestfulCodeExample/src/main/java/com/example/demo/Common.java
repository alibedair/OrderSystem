package com.example.demo;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.example.demo.model.Account;
import com.example.demo.model.Order;
import com.example.demo.model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 
 */
public class Common {
    public static Map<String, Account> Accounts = new HashMap<String, Account>();
    public static Map<String, Product> Products = new HashMap<String, Product>();
    public static Map<Integer, Order> Orders = new HashMap<>();
}
