package com.example.ordertaker.application.requesthandlers.commands;

import com.example.ordertaker.application.requesthandlers.RequestHandler;
import com.example.ordertaker.application.requesthandlers.requests.PlaceOrderRequest;
import com.example.ordertaker.application.requesthandlers.responses.PlaceOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaceOrderRequestHandler implements RequestHandler<PlaceOrderRequest, PlaceOrderResponse> {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public PlaceOrderResponse handle(PlaceOrderRequest request) {

        // produce order
        kafkaTemplate.send("ORDERS", request);

        return new PlaceOrderResponse(true);
    }
}
