package com.riyas.ecommerce.orderLine;

public record OrderLineRequest(

    Integer id,
    Integer orderId,
    Integer productId,
    double quantity

) {

}
