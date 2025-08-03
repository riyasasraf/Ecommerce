package com.riyas.ecommerce.kafka.order;

import java.math.BigDecimal;
import java.util.List;

import com.riyas.ecommerce.kafka.payment.PaymentMethod;

public record OrderConfirmation(

    String orderRefrence,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    Customer customer,
    List<Product> products

) {

}
