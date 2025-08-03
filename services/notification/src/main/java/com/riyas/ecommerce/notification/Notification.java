package com.riyas.ecommerce.notification;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.riyas.ecommerce.kafka.order.OrderConfirmation;
import com.riyas.ecommerce.kafka.payment.PaymentConfirmation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Notification {

  @Id
  private String id;
  private NotificationType type;
  private LocalDateTime notificationDate;
  private OrderConfirmation orderCnfirmation;
  private PaymentConfirmation paymentConfirmation;
  
}

