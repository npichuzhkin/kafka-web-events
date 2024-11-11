package com.npichuzhkin.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumerService.class);

    @KafkaListener(topics = "web-logs", groupId = "web-log-consumer-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeEvent(ConsumerRecord<String, String> record) {
        logger.info(String.format("Partition: %d, Offset: %d, Event: %s%n", record.partition(), record.offset(), record.value()));
    }
}

