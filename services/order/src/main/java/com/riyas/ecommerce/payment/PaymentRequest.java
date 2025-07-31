package com.riyas.ecommerce.payment;

import java.math.BigDecimal;

import com.riyas.ecommerce.customer.CustomerResponse;
import com.riyas.ecommerce.order.PaymentMethod;

public record PaymentRequest(
   BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderRefrence,
    CustomerResponse  customer

) {

}
