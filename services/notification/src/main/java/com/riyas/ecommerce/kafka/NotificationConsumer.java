package com.riyas.ecommerce.kafka;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.riyas.ecommerce.email.EmailService;
import com.riyas.ecommerce.kafka.order.OrderConfirmation;
import com.riyas.ecommerce.kafka.payment.PaymentConfirmation;
import com.riyas.ecommerce.notification.Notification;
import com.riyas.ecommerce.notification.NotificationRepository;
import com.riyas.ecommerce.notification.NotificationType;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

  private final NotificationRepository repository;
  private final EmailService emailService;

  @KafkaListener(topics = "payment-topic")
  public void consumePaymentSuccesNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
    log.info("consuming the message from payment-topic :: %s ", paymentConfirmation);

    repository.save(Notification.builder()
        .type(NotificationType.PAYMENT_CONFIRMATION)
        .notificationDate(LocalDateTime.now())
        .paymentConfirmation(paymentConfirmation)
        .build());

    var customerName = paymentConfirmation.customerFirstName() + "" + paymentConfirmation.customerLastName();
    emailService.sendPayment(paymentConfirmation.customerEmail(), customerName,paymentConfirmation.amount(), paymentConfirmation.orderRefrence());
  }
  
  @KafkaListener(topics = "order-topic")
  public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
    log.info("consuming the message from order-topic :: %s ", orderConfirmation);

    repository.save(Notification.builder()
        .type(NotificationType.PAYMENT_CONFIRMATION)
        .notificationDate(LocalDateTime.now())
        .orderCnfirmation(orderConfirmation)
        .build());

        var customerName = orderConfirmation.customer().firstName() + "" + orderConfirmation.customer().lastName();
    emailService.sentOrderConfirmation(orderConfirmation.customer().email(), customerName, orderConfirmation.totalAmount(),
        orderConfirmation.orderRefrence(),orderConfirmation.products());
  }
  
}