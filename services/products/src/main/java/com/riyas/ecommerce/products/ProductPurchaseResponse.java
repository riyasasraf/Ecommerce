package com.riyas.ecommerce.products;

import java.math.BigDecimal;

public record ProductPurchaseResponse(

    Integer productId,
    String productName,
    String productDescription,
    BigDecimal price,
    Double quantityPurchased

) {

}
