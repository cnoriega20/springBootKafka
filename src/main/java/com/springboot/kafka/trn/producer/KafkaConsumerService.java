package com.springboot.kafka.trn.producer;

import com.springboot.kafka.trn.consumer.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private static Logger logger =
            LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "${springBootKafka.kafka.topic}", groupId ="kafka001" )
    public void consume(String message) {
        logger.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
    }

}
