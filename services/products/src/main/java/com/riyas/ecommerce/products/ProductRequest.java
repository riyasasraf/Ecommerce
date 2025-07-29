package com.riyas.ecommerce.products;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(

    int id,
    @NotNull(message = "Name cannot be null")
    String name,
    @NotNull(message = "Description cannot be null")
    String description,
    @Positive(message = "Available quantity must be positive")
    double availableQuantity,
    @Positive(message = "Price must be positive")
    BigDecimal price,
    @NotNull(message = "Category ID cannot be null")
    Integer categoryId) {

}
