package com.springboot.kafka.trn.controller;

import com.springboot.kafka.trn.consumer.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProducerController {
    private final KafkaProducerService producerService;

    public KafkaProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping(value = "/publishToTopic")
    public void sendToKafkaTopic(@RequestParam("message") String message){
        producerService.sendMessage(message);
    }
}
