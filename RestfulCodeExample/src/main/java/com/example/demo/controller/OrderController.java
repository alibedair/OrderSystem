package com.example.demo.controller;

import com.example.demo.Common;
import com.example.demo.model.*;
import com.example.demo.service.AccountServiceImpl;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/simpleOrder")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public List<Response> addorder(@RequestBody Map<String, Object> requestBody) {
        // List<String> ids = requestBody.get("ids");
        String un = (String) requestBody.get("username");
        List<String> ids = (List<String>) requestBody.get("ids");
        System.out.println("in add product with " + ids + " in orders");
        List<Response> responseList = new ArrayList<>();
        Order order = new SimpleOrder();
        order.setAccountUsername(un);
        for (int i = 0; i < ids.size(); i++) {
            boolean res = orderService.addProduct(ids.get(i), order);
            Response response = new Response();
            if (res) {
                response.setStatus(true);
                response.setMessage("com.example.demo.Product added successfully");
                responseList.add(response);
            } else {
                response.setStatus(false);
                response.setMessage("com.example.demo.Product doesn't exist successfully");
                responseList.add(response);
            }
        }
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.payOrder(order, Common.Accounts.get(un));
        return responseList;
    }

    @DeleteMapping("/delete/{ID}")
    public Response cancelorder(@PathVariable("ID") int ID) {
        System.out.println("in cancel order with ID:" + ID);
        boolean res = orderService.CancelOrder(ID);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("com.example.demo.Order Doesn't Exists");
            return response;
        }
        response.setStatus(true);
        response.setMessage("com.example.demo.Order deleted successfully");
        return response;
    }

    @GetMapping("/get/{ID}")
    public Order getorder(@PathVariable("ID") int ID) {
        System.out.println("in get Simple order with id:" + ID);
        return orderService.getOrder(ID);
}
}