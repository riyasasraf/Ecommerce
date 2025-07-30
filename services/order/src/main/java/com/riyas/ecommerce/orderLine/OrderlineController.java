package com.riyas.ecommerce.orderLine;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1//order-line")
@RequiredArgsConstructor
public class OrderlineController {
  
  private final OrderLineService service;

  @GetMapping("/order/{order-id}")
  public ResponseEntity<List<OrderLineResponse>> findByOrderId(
    @PathVariable("order-id") Integer orderId
  ) {
    return ResponseEntity.ok(service.findAllByOrderId(orderId));    
  }


}
