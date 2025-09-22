package com.riyas.ecommerce.products;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.riyas.ecommerce.exceptions.ProductNotFoundException;
import com.riyas.ecommerce.minio.ImageService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.var;


@Service
@RequiredArgsConstructor
public class ProductService {

  public final ProductRepository repository;
  public final ProductMapper mapper;
  public final ImageService imageService;

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

  public Integer createProduct(ProductRequest request , MultipartFile file) {
    Products product = mapper.toProduct(request);
    String productImageUrl;
    try {
      productImageUrl = imageService.uploadImage(file);
      product.setProductImageUrl(productImageUrl);
    } catch (IOException e) {
      throw new RuntimeException("Failed to upload product image", e);
    }
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
