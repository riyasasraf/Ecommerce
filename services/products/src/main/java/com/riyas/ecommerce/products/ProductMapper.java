package com.riyas.ecommerce.products;

import org.springframework.stereotype.Service;

import com.riyas.ecommerce.category.Category;

@Service
public class ProductMapper {

  public Products toProduct(ProductRequest request) {
    return Products.builder()
        .name(request.name())
        .description(request.description())
        .price(request.price())
        .availableQuantity(request.availableQuantity())
        .category(Category.builder().id(request.categoryId()).build())
        .build();
  }

  public ProductResponse toProductResponse(Products product) {
    return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
        product.getAvailableQuantity(), product.getCategory().getId(), product.getCategory().getName(),
        product.getCategory().getDescription());
  }

  public ProductPurchaseResponse toProductPurchaseResponse(Products product,
      Double quantity) {
    return new ProductPurchaseResponse(
        product.getId(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        quantity

    );
  }

}
