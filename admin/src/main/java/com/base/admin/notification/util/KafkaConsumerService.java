package com.base.admin.notification.util;


import com.base.admin.notification.contants.kafka.GroupIdConstants;
import com.base.admin.notification.contants.kafka.TopicConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumerService {

    @KafkaListener(topics = TopicConstants.TOPIC_1, groupId = GroupIdConstants.GROUP_ID_CONSUMER_V1)
    public void consume(Object message) {
        System.out.println(message);
    }


}
