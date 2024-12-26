package com.manohar3969.vmrmobiles_api.repository;

import com.manohar3969.vmrmobiles_api.models.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Optional<Cart> findByUserId(String userId); // Find cart by user ID
}
