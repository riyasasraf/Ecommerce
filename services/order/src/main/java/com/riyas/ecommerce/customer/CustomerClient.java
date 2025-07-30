package com.riyas.ecommerce.customer;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.ws.rs.PathParam;
import lombok.experimental.FieldNameConstants;

@FeignClient(name = "customer-service", url = "${application.config.customer-url}")
public interface CustomerClient {

  @GetMapping("/{customerId}")
  Optional<CustomerResponse> findCustomerById(@PathVariable("customerId") String customerId);
  

}