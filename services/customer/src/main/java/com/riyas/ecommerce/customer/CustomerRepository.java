package com.riyas.ecommerce.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
  
  // Additional query methods can be defined here if needed
  // For example, to find a customer by email:
  // Optional<Customer> findByEmail(String email);  

}
