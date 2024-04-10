package com.example.orderprocessor.presentation;

import com.example.orderprocessor.presentation.dtos.OrderPlacementRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderPlacementConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "ORDERS", groupId = "order-processor")
    @SneakyThrows
    public void consumeOrderPlacement(final String message) {

        var obj = objectMapper.readValue(message, OrderPlacementRequestDTO.class);

        log.info("Consumer consume Kafka message -> {}", obj);
    }
}
