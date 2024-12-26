package com.manohar3969.vmrmobiles_api.repository;

import com.manohar3969.vmrmobiles_api.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email); // Find user by email
}

