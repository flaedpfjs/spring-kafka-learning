package com.juzi.config;

import com.juzi.producer.SenderMsg;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhiWei.Yang2 on 2016/10/20.
 */
@Configuration
public class SenderMsgConfig {

    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;

    @Bean
    public Map producerConfigs() {
        Map props = new HashMap();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG,5000);

        return  props;
    }

    @Bean
    public ProducerFactory producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate kafkaTemplate() {
        return  new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public SenderMsg senderMsg() {
        return  new SenderMsg();
    }
}
