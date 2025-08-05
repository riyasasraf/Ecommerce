  package com.riyas.ecommerce.config;

  import java.util.HashMap;
  import java.util.List;
  import java.util.Map;

  import org.apache.kafka.clients.producer.ProducerConfig;
  import org.apache.kafka.common.serialization.StringSerializer;
  import org.springframework.beans.factory.annotation.Value;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.kafka.core.DefaultKafkaProducerFactory;
  import org.springframework.kafka.core.KafkaTemplate;
  import org.springframework.kafka.core.ProducerFactory;
  import org.springframework.kafka.support.serializer.JsonSerializer;

  import com.riyas.ecommerce.kafka.OrderConfirmation;

  @Configuration
  public class KafkaProducerConfig {

    @Value("${kafka.producer.bootstrap-servers}")
    private List<String> bootstrapServers;

    @Bean
    public ProducerFactory<String, OrderConfirmation> producerFactory() {
      Map<String, Object> configProps = new HashMap<>();
      configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
      configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
      configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
      configProps.put(JsonSerializer.TYPE_MAPPINGS,
          "orderConfirmation:com.riyas.ecommerce.kafka.OrderConfirmation");
      return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, OrderConfirmation> kafkaTemplate() {
      return new KafkaTemplate<>(producerFactory());
    }
  }