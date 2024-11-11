package com.npichuzhkin.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventsProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC_NAME = "web-logs";

    public EventsProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sendEvent(@RequestBody String event) {
        kafkaTemplate.send(TOPIC_NAME, event);
        return "Event sent to Kafka topic";
    }
}

