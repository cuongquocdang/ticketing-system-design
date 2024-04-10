package com.example.ordertaker.presentation;

import com.example.ordertaker.application.requesthandlers.RequestHandler;
import com.example.ordertaker.application.requesthandlers.requests.PlaceOrderRequest;
import com.example.ordertaker.application.requesthandlers.responses.PlaceOrderResponse;
import com.example.ordertaker.presentation.dtos.OrderPlacementRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderRestController {

    private final RequestHandler<PlaceOrderRequest, PlaceOrderResponse> placeOrderRequestHandler;

    @PostMapping("/placement")
    @SuppressWarnings("rawtypes")
    public ResponseEntity placeOrder(@RequestBody final OrderPlacementRequestDTO requestDTO) {

        var placedOrder = placeOrderRequestHandler.handle(new PlaceOrderRequest(requestDTO.productId()));

        return placedOrder.success()
                ? ResponseEntity.accepted().build()
                : ResponseEntity.unprocessableEntity().build();
    }
}
