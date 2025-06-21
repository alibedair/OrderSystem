package com.example.demo.model;

import com.example.demo.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder extends Order  {
    private static int  Id_Generator=0;

    public static int getId_Generator() {
        return Id_Generator;
    }
    public SimpleOrder() {
        details = new ArrayList<>();
        listOfProducts = new ArrayList<>();
        totalDue = 0;
       Id_Generator++;
       ID = Id_Generator;
    }
}
