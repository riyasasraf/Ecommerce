package com.riyas.ecommerce.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

  
  private final OrderService service;



  @PostMapping
  public ResponseEntity<Integer> creteOrder(
    @RequestBody @Valid OrderRequest request
  ) {
    return ResponseEntity.ok(service.createOrder(request));

  }
  
  @GetMapping
  public ResponseEntity<List<OrderResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
  
  @GetMapping("/{order-id}")
  public ResponseEntity<OrderResponse> finById(
    @PathVariable ("order-id") Integer orderId
  ) {
    return ResponseEntity.ok(service.findById(orderId));
  }


}
