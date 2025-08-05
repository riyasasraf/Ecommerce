package com.riyas.ecommerce.kafka.payment;

import java.math.BigDecimal;

public record PaymentConfirmation(

    String orderRefrence,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    String customerFirstName,
    String customerLastName,
    String customerEmail

) {

}
