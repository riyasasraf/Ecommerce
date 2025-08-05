package com.riyas.ecommerce.product;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PurchaseResponse(


    Integer productId,

    @JsonProperty("productName")
    String name,
    String productDescription,

    BigDecimal price,


    double quantityPurchased

) {

}
