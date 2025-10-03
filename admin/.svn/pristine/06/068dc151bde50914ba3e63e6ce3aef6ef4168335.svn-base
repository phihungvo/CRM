package com.base.admin.config;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.PropertyAccessor.*;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    //  @Bean
    //  public ObjectMapper objectMapper() {
    //    ObjectMapper mapper = new ObjectMapper();
    //    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //    return mapper;
    //  }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .findAndRegisterModules()
                .setVisibility(ALL, NONE)
                .setVisibility(FIELD, ANY)
                .setVisibility(IS_GETTER, ANY)
                .setVisibility(GETTER, ANY)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .disable(WRITE_DATES_AS_TIMESTAMPS);
    }
    // StateData myMessage = mapper.readValue(rawData, StateData.class);
    // mqtGateway.senToMqtt(objectMapper.writeValueAsString(mqttMessage), mqttMessage.getTopic());
}
