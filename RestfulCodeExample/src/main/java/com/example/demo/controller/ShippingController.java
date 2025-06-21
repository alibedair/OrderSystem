package com.example.demo.controller;

import com.example.demo.service.ShippingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.Account;
import com.example.demo.service.AccountServiceImpl;
import com.example.demo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/shipping")
public class ShippingController {
    @Autowired
    ShippingServiceImpl shippingService;

    @PostMapping("/shipSimpleOrder/{orderId}")
    public Response shipsimpleOrder(@PathVariable("orderId") int orderId) {
        boolean res = shippingService.shipSimpleOrder(orderId);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Failed to ship the order");
            return response;


        }

        response.setStatus(true);
        response.setMessage("Order " + orderId + " shipped successfully");
        return response;

    }

    @PostMapping("/shipCompoundOrder/{orderId}")
    public Response shipCompundOrder(@PathVariable("orderId") int orderId) {
        boolean res = shippingService.shipCompundOrder(orderId);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Failed to ship the order");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Order " + orderId + " shipped successfully");
        return response;

    }
}
