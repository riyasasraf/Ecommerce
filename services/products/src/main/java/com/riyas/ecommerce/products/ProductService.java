package com.riyas.ecommerce.products;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.riyas.ecommerce.exceptions.ProductNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.var;


@Service
@RequiredArgsConstructor
public class ProductService {

  public final ProductRepository repository;
  public final ProductMapper mapper;

  public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> purchaseRequest) {
    var productIds = purchaseRequest.stream().map(ProductPurchaseRequest::productId).toList();
    var storedProducts = repository.findByIdInOrderById(productIds);
    if (storedProducts.size() != productIds.size()) {
      throw new ProductNotFoundException("one or more products not found");
    }
    var storedRequest = purchaseRequest.stream().sorted(Comparator.comparing(ProductPurchaseRequest::productId))
        .toList();

    var purchasedProducts = new ArrayList<ProductPurchaseResponse>();

    for (int i = 0; i < storedProducts.size(); i++) {
      var product = storedProducts.get(i);
      var request = storedRequest.get(i);
      if (product.getAvailableQuantity() < request.quantity()) {
        throw new ProductNotFoundException("Product with id " + product.getId() + " has insufficient quantity");
      }
      var availQuantity = product.getAvailableQuantity() - request.quantity();
      product.setAvailableQuantity(availQuantity);
      repository.save(product);
      purchasedProducts.add(mapper.toProductPurchaseResponse(product, request.quantity()));
    }
    return purchasedProducts;

  }

  public Integer createProduct(ProductRequest request) {
    var product = mapper.toProduct(request);
    return repository.save(product).getId();
  }

  public ProductResponse findById(Integer productId) {
    return repository.findById(productId).map(mapper::toProductResponse)
        .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
  }

  public List<ProductResponse> findAll() {
    return repository.findAll().stream().map(mapper::toProductResponse).collect(Collectors.toList());
  }

}
