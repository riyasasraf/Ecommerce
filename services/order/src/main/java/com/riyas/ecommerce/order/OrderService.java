package com.riyas.ecommerce.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.riyas.ecommerce.customer.CustomerClient;
import com.riyas.ecommerce.exceptions.BusinessException;
import com.riyas.ecommerce.kafka.OrderConfirmation;
import com.riyas.ecommerce.kafka.OrderProducer;
import com.riyas.ecommerce.orderLine.OrderLineRequest;
import com.riyas.ecommerce.orderLine.OrderLineService;
import com.riyas.ecommerce.payment.PaymentClient;
import com.riyas.ecommerce.payment.PaymentRequest;
import com.riyas.ecommerce.product.ProductClient;
import com.riyas.ecommerce.product.PurchaseRequest;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final CustomerClient customerClient;
  private final ProductClient productClient;
  private final OrderRepository repository;
  private final OrderMapper mapper;
  private final OrderLineService orderLineService;
  private final OrderProducer orderProducer;
  private final PaymentClient paymentClient;

  public Integer createOrder(OrderRequest request) {

    var customer = customerClient.findCustomerById(request.customerId())
        .orElseThrow(() -> new BusinessException("Cannot create order:: no Customer exsists with the provided Id"));

    var purchasedProduct = this.productClient.purchaseResponse(request.products());
    var order = this.repository.save(mapper.toOrder(request));

    for (PurchaseRequest purchaseRequest : request.products()) {
      orderLineService.saveOrderLine(
          new OrderLineRequest(null, order.getId(), purchaseRequest.productId(), purchaseRequest.quantity()));
    }

    var paymentRequest = new PaymentRequest(request.amount(),request.paymentMethod(),order.getId(),order.getRefrence(),customer);
    paymentClient.requestOrderPayment(paymentRequest);


    orderProducer.sendOrderConfirmation(new OrderConfirmation(
        request.refrence(),
        request.amount(),
        request.paymentMethod(),
        customer,
        purchasedProduct));


    return order.getId();
  }

  public List<OrderResponse> findAll() {
   return repository.findAll().stream().map(mapper::fromOrder).collect(Collectors.toList());
  }

  public OrderResponse findById(Integer orderId) {
    return repository.findById(orderId)
        .map(mapper::fromOrder)
        .orElseThrow(() -> new EntityNotFoundException(
            String.format("No order is found with the ID %d", orderId)));
  }

}
