package com.riyas.ecommerce.order;

import java.math.BigDecimal;
import java.util.List;

import com.riyas.ecommerce.product.PurchaseRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(
    Integer id,
    String refrence,
    @Positive(message = "order amount should be positive") BigDecimal amount,
    @NotNull(message = "payment method should be precised") PaymentMethod paymentMethod,
    @NotBlank(message = "Customer should be present") @NotNull(message = "Customer should be present") @NotEmpty(message = "Customer should be present") String customerId,
    @NotEmpty(message = "you should ateast purchase one products") List<PurchaseRequest> products) {

}
