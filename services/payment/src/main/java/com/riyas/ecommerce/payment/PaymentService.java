package com.riyas.ecommerce.payment;

import org.springframework.stereotype.Service;

import com.riyas.ecommerce.Notification.NotificationProducer;
import com.riyas.ecommerce.Notification.PaymentNotificationRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

  private final PaymentRepository repository;
  private final PaymentMapper mapper;
  private final NotificationProducer producer; 
  public Integer createPayment(PaymentRequest request) {
    var payment = repository.save(mapper.toPayment(request));

    producer.sendNotification(new PaymentNotificationRequest(request.orderRefrence(), request.amount(), request.paymentMethod(), request.customer().firstName(), request.customer().lastName(), request.customer().email()));

    return payment.getId();
  }

}
