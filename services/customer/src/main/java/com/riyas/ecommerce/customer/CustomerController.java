package com.riyas.ecommerce.customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

  public final CustomerService service;

  @PostMapping
  public ResponseEntity<String> createCustomer(
      @RequestBody @Valid CustomerRequest request) {

    return ResponseEntity.ok(service.createCustomer(request));
  }

  @PutMapping
  public ResponseEntity<Void> updateCustomer(
      @RequestBody @Valid CustomerRequest request) {
    service.updateCustomer(request);
    return ResponseEntity.accepted().build();
  }

  @GetMapping
  public ResponseEntity<List<CustomerResponse>> findAll() {
    return ResponseEntity.ok(service.findAllCustomers());
  }

  @GetMapping("exists/{customerId}")
  public boolean exsistsById(@PathVariable("customerId") String customeId) {
    return service.exsistsById(customeId);
  }
  
  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable("customerId") String customeId) {
    return ResponseEntity.ok(service.findById(customeId));
  }

  @DeleteMapping("/{customerId}")
  public ResponseEntity<Void> deleteById(@PathVariable("customerId") String customeId) {
    service.deleteById(customeId);
    return ResponseEntity.accepted().build();
  }
  

}
