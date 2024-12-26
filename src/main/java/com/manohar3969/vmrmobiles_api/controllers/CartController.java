package com.manohar3969.vmrmobiles_api.controllers;

import com.manohar3969.vmrmobiles_api.models.Cart;
import com.manohar3969.vmrmobiles_api.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Get cart by user ID
    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    // Add item to cart
    @PostMapping("/{userId}/add")
    public ResponseEntity<Cart> addItemToCart(@PathVariable String userId, @RequestBody Cart.CartItem item) {
        return ResponseEntity.ok(cartService.addItemToCart(userId, item));
    }

    // Remove item from cart
    @DeleteMapping("/{userId}/remove/{productId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable String userId, @PathVariable String productId) {
        return ResponseEntity.ok(cartService.removeItemFromCart(userId, productId));
    }

    // Clear the cart
    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<Void> clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
        return ResponseEntity.noContent().build();
    }
}
