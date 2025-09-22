package com.riyas.ecommerce.category;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(


    Integer id,
    @NotNull(message = "The name Should not be null or empty") @NotEmpty(message = "The name Should not be null or empty") String name,
    @NotNull(message = "The description Should not be null or empty") @NotEmpty(message = "The description Should not be null or empty") String description) {

}
