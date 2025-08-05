package com.riyas.ecommerce.kafka.order;

import java.math.BigDecimal;

public record Product(

    Integer productId,
    String name,
    String productDescription,
    BigDecimal price,
    double quantityPurchased

) {

}
