package com.riyas.ecommerce.payment;

import java.math.BigDecimal;

import com.riyas.ecommerce.customer.Customer;

public record PaymentRequest(

    Integer id,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderRefrence,
    Customer customer

) {

}
