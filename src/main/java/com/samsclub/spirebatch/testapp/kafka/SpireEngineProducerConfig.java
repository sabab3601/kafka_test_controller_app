package com.samsclub.spirebatch.testapp.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class SpireEngineProducerConfig {

    @Bean
    public KafkaTemplate<String, Object> spireEngineTemplate() {
        return new KafkaTemplate<>(spireEngineProducerFactory());
    }


    @Bean
    public ProducerFactory<String, Object> spireEngineProducerFactory() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-1301504412-1-1325512945.scus.kafka-v2-shared6-stg.ms-df-messaging.stg-az-southcentralus-10.prod.us.walmart.net:9092");
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<String, Object>(configMap);
    }
}
