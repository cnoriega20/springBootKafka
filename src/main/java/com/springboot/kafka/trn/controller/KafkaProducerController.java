package com.springboot.kafka.trn.controller;

import com.springboot.kafka.trn.consumer.KafkaProducerService;
import com.springboot.kafka.trn.model.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProducerController {
    private final KafkaProducerService producerService;

    public KafkaProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/publishToTopic")
    public void sendToKafkaTopic(@RequestBody Employee employee){
        producerService.sendMessage(employee);
    }
}
