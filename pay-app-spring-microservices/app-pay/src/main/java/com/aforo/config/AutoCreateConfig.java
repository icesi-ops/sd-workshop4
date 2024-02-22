package com.aforo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AutoCreateConfig {

    @Bean
    public NewTopic depositEvent() {
        return TopicBuilder
                .name("trasaction-events")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
