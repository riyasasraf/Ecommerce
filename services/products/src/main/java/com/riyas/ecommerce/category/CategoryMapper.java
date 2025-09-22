package com.riyas.ecommerce.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.riyas.ecommerce.products.ProductMapper;
import com.riyas.ecommerce.products.ProductResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryMapper {
  private final ProductMapper productMapper;

  public CategoryResponse toCategoryResponse(Category category) {
    List<ProductResponse> productResponse = category.getProducts().stream().map(productMapper::toProductResponse)
        .collect(Collectors.toList());
    return new CategoryResponse(category.getId(), category.getName(), category.getDescription(), productResponse);
  }

  public Category toCategory(CategoryRequest category) {
    return Category.builder()
        .name(category.name())
        .description(category.description())
        .build();
  }

}
