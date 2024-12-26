package com.manohar3969.vmrmobiles_api.repository;

import com.manohar3969.vmrmobiles_api.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId); // Find orders by user ID
}

