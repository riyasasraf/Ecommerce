    package com.riyas.ecommerce.Notification;

    import java.math.BigDecimal;

    import com.riyas.ecommerce.payment.PaymentMethod;


    public record PaymentNotificationRequest(

        String orderRefrence,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail

    ) {

    }
