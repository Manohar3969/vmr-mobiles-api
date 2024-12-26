package com.manohar3969.vmrmobiles_api.service;

import com.manohar3969.vmrmobiles_api.models.Cart;
import com.manohar3969.vmrmobiles_api.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    // Get cart by user ID
    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId).orElse(new Cart(userId, null));
    }

    // Add item to cart
    public Cart addItemToCart(String userId, Cart.CartItem item) {
        Cart cart = getCartByUserId(userId);
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    // Remove item from cart
    public Cart removeItemFromCart(String userId, String productId) {
        Cart cart = getCartByUserId(userId);
        cart.getItems().removeIf(item -> item.getProductId().equals(productId));
        return cartRepository.save(cart);
    }

    // Clear cart
    public void clearCart(String userId) {
        cartRepository.deleteById(getCartByUserId(userId).getId());
    }
}

