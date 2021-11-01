package com.springboot.kafka.trn.consumer;

import com.springboot.kafka.trn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static Logger logger =
            LoggerFactory.getLogger(KafkaProducerService.class);


    @Value("${springBootKafka.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, Object> kafkaTemplate;
    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Employee employee){
        logger.info("MESSAGE SENT FROM PRODUCER END -> " + employee);
        kafkaTemplate.send(topic, employee);
    }
}
