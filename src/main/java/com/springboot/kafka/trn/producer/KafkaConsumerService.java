package com.springboot.kafka.trn.producer;

import com.springboot.kafka.trn.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {


    @KafkaListener(topics = "${springBootKafka.kafka.topic}", groupId ="kafka001" )
    public void consume(Employee employee) {
        log.info("MESSAGE RECEIVED AT CONSUMER END -> " + employee);
    }

}
