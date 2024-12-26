package com.manohar3969.vmrmobiles_api.repository;

import com.manohar3969.vmrmobiles_api.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category); // Find products by category
}
