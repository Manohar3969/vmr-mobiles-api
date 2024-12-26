package com.manohar3969.vmrmobiles_api.controllers;

import com.manohar3969.vmrmobiles_api.models.Order;
import com.manohar3969.vmrmobiles_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place an order
    @PostMapping("/{userId}")
    public ResponseEntity<Order> placeOrder(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.placeOrder(userId));
    }

    // Get orders by user ID
    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }
}

