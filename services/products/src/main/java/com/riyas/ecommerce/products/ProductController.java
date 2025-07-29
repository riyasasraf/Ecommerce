package com.riyas.ecommerce.products;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")

public class ProductController {


  public final ProductService service;


  @PostMapping
  public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest product) {
    return ResponseEntity.ok(service.createProduct(product));
  }

  @PostMapping("/purchase")
  public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(
      @RequestBody List<ProductPurchaseRequest> purchaseRequest) {
    return ResponseEntity.ok(service.purchaseProducts(purchaseRequest));
  }
  
  @GetMapping("/{product-id}")
  public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId) {
    return ResponseEntity.ok(service.findById(productId));
  }
  
  @GetMapping
  public ResponseEntity<List<ProductResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }


  

}
