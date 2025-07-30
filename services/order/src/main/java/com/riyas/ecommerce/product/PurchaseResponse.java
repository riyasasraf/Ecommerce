package com.riyas.ecommerce.product;

import java.math.BigDecimal;

public record PurchaseResponse(

    Integer productId,
    String name,
    String descreption,
    BigDecimal price,
    double quantity

) {

}
