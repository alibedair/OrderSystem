package com.example.demo.controller;

import com.example.demo.Common;
import com.example.demo.SearchEngine;
import com.example.demo.model.*;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/compoundorder")
public class CompoundOrderController {
    @Autowired
    private OrderService orderService;

    public CompoundOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public List<Response> addorder(@RequestBody Map<String, Object> requestBody) {
        String un = (String) requestBody.get("username");
        int n = 0;
        List<String> friends = (List<String>) requestBody.get("friends");
        CompoundOrder compoundOrder = new CompoundOrder();
        compoundOrder.setAccountUsername(un);
        List<Response> responseList = new ArrayList<>();
        if (requestBody.containsKey("items")) {
            Object itemsObject = requestBody.get("items");
            int z = 0;
            if (itemsObject instanceof List) {
                List<List<String>> items = (List<List<String>>) itemsObject;
                for (int i = 0; i < items.size(); i++) {
                    SimpleOrder simpleOrder = new SimpleOrder();
                    if (i == 0) {
                        simpleOrder.setAccountUsername(un);
                    } else {
                        simpleOrder.setAccountUsername(friends.get(z));
                        z++;
                    }
                    for (int j = 0; j < items.get(i).size(); j++) {
                        boolean res = orderService.addProduct(items.get(i).get(j), simpleOrder);
                        n++;
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
                    compoundOrder.addOrder(simpleOrder);
                }

            }
        }
        Common.Orders.put(compoundOrder.getID(), compoundOrder);
        SearchEngine searchEngine = new SearchEngine();
        Account account = searchEngine.getAccount(un);
        List<Account> Friends = new ArrayList<>();
        for (int k = 0; k < friends.size(); k++) {
            Account account1 = searchEngine.getAccount(friends.get(k));
            Friends.add(account1);
        }
        compoundOrder.setFriends(Friends);
        compoundOrder.setnumberofproducts(n);

        CompoundOrderpayment compoundOrderpayment = new CompoundOrderpayment();
        compoundOrderpayment.payperorder(account, Friends, compoundOrder);
        return responseList;
    }

    @DeleteMapping("/delete/{ID}")
    public Response cancelorder(@PathVariable("ID") int ID) {
        System.out.println("in cancel  Compound order with ID:" + ID);
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
        System.out.println("in get Compound order with id:" + ID);
        return orderService.getOrder(ID);
    }
}
