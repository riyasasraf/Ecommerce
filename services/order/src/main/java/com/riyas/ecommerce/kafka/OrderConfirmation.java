package com.riyas.ecommerce.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.riyas.ecommerce.customer.CustomerResponse;
import com.riyas.ecommerce.order.PaymentMethod;
import com.riyas.ecommerce.product.PurchaseResponse;

public record OrderConfirmation(
    String orderRefrence,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    CustomerResponse customer,
    List<PurchaseResponse> products

) {

}
