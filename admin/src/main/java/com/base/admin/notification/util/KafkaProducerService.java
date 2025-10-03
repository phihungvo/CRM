package com.base.admin.notification.util;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, Object message) {
        try {
            kafkaTemplate.send(topic, message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
