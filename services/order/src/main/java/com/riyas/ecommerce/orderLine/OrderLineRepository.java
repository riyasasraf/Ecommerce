package com.riyas.ecommerce.orderLine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

  List<OrderLine> findAllByOrderId(Integer orderId);

}
