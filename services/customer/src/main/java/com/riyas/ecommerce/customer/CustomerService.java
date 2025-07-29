package com.riyas.ecommerce.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.riyas.ecommerce.exceptions.CustomerNotFoundException;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;
  private final CustomerMapper mapper;

  public String createCustomer(CustomerRequest request) {
    
    var customer = repository.save(mapper.toCustomer(request));
    return customer.getId(); 
  }

  public void updateCustomer(CustomerRequest request) {

    var customer = repository.findById(request.id())
        .orElseThrow(() -> new CustomerNotFoundException(
            String.format("Cannot Update customer:: no Customer found with the id :: %s", request.id())));
    mergeCustomer(customer, request);
    repository.save(customer);
  }

  private void mergeCustomer(Customer customer, CustomerRequest request) {
   
    if (StringUtils.isNotBlank(request.firstName())) {
      customer.setFirstName(request.firstName());
    }
    if (StringUtils.isNotBlank(request.lastName())) {
      customer.setLastName(request.lastName());
    }
    if (StringUtils.isNotBlank(request.email())) {
      customer.setEmail(request.email());
    }
    if (request.address() != null) {
      customer.setAddress(request.address());
    }
  }

  public List<CustomerResponse> findAllCustomers() {
    return repository.findAll().stream().map(mapper::fromCustomer).collect(Collectors.toList());
  }

  public boolean exsistsById(String customeId) {
   return repository.findById(customeId).isPresent();
  }

  public CustomerResponse findById(String customeId) {
    return repository.findById(customeId)
        .map(mapper::fromCustomer)
        .orElseThrow(() -> new CustomerNotFoundException(
            String.format("Cannot find customer:: no Customer found with the id :: %s", customeId)));
  }

  public void deleteById(String customeId) {
    repository.deleteById(customeId);
  }


}
