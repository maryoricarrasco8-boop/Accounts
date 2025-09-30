package com.bootcamp.accountms.events;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountProducer {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final String topic;

  public AccountProducer(KafkaTemplate<String, Object> kafkaTemplate,
                         @Value("${app.kafka.topic:account-events}") String topic) {
    this.kafkaTemplate = kafkaTemplate;
    this.topic = topic;
  }

  public void publish(Object event) {
    kafkaTemplate.send(topic, event);
  }
}
