package com.riyas.ecommerce.category;

import java.util.List;

import com.riyas.ecommerce.products.ProductResponse;

public record CategoryResponse(
  Integer id,
   String name,
   String description,
   List<ProductResponse> products
) {

}
