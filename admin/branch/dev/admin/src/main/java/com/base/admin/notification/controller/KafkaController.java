package com.base.admin.notification.controller;

import com.base.admin.notification.contants.kafka.TopicConstants;
import com.base.admin.notification.contants.url.UrlKafka;
import com.base.admin.notification.contants.url.VersionUrl;
import com.base.admin.notification.dto.Email;
import com.base.admin.notification.util.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VersionUrl.URL_VERSION + UrlKafka.URL_KAFKA)
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/test")
    public String test() {
        Email email = Email.builder().subject("Test").body("123").build();
        kafkaProducerService.sendMessage(TopicConstants.TOPIC_1,email);
        return "ok";
    }

}
