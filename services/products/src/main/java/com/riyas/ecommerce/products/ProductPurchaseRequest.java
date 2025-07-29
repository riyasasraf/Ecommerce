package com.riyas.ecommerce.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
  @NotNull(message = "Product ID cannot be null")
    Integer productId,
  @NotNull(message = "Quantity cannot be null")
  @Positive(message = "Quantity must be positive")
  Double quantity 
) {

}
