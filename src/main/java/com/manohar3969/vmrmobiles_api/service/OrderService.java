package com.manohar3969.vmrmobiles_api.service;


import com.manohar3969.vmrmobiles_api.models.Cart;
import com.manohar3969.vmrmobiles_api.models.Order;
import com.manohar3969.vmrmobiles_api.repository.CartRepository;
import com.manohar3969.vmrmobiles_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    // Place an order
    public Order placeOrder(String userId) {
        Cart cart = cartService.getCartByUserId(userId);
        if (cart.getItems() == null || cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty. Add items before placing an order.");
        }

        double totalAmount = cart.getItems().stream()
                .mapToDouble(item -> item.getQuantity() * 10.0) // Assume each item has a price of 10 for now
                .sum();

        Order order = new Order(userId, cart.getItems(), totalAmount, "PENDING", new Date());
        orderRepository.save(order);

        // Clear the cart after placing the order
        cartRepository.deleteById(cart.getId());

        return order;
    }

    // Get orders by user ID
    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
