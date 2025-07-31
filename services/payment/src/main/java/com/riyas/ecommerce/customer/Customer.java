package com.riyas.ecommerce.customer;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Validated
public record Customer(String id, @NotNull(message = "Firstname is required") String firstName,
    @NotNull(message = "Lastname is required") String lastName,
    @NotNull(message = "Email is required") @Email(message = "The Customer is not correctly formatted") String email) {

}
