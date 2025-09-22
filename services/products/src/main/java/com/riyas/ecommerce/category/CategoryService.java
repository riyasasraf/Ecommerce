package com.riyas.ecommerce.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository repository;
  private final CategoryMapper mapper;
  public List<CategoryResponse> findAll() {

    return repository.findAll().stream().map(mapper::toCategoryResponse).collect(Collectors.toList());
  }
  public String createCategory(CategoryRequest category) {
    return "The Product Created in Id:" + repository.save(mapper.toCategory(category)).getId() ;
  }

}
