package com.riyas.ecommerce.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaPaymentTopicConfig {

  public NewTopic newTopic() {
    return TopicBuilder.name("payment-topic").build();
  }

}