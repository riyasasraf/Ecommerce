package com.riyas.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
  
    String id,
    @NotNull(message = "First name cannot be null") String firstName,
    @NotNull(message = "Last name cannot be null") String lastName,
    @NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,
    CustomerAddress address
) {

}
