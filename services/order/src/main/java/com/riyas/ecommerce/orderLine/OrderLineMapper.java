package com.riyas.ecommerce.orderLine;

import org.springframework.stereotype.Service;

import com.riyas.ecommerce.order.Order;

@Service
public class OrderLineMapper {

  public OrderLine toOrderLine(OrderLineRequest request) {

    return OrderLine.builder()
        .id(request.id())
        .quantity(request.quantity())
        .order(Order.builder().id(request.orderId()).build())
        .productId(request.productId()).build();
  }

  public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
    return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
  }

}
