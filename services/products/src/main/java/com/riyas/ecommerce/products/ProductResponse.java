package com.riyas.ecommerce.products;

import java.math.BigDecimal;

public record ProductResponse(
    Integer id,
    String name,
    String description,
    BigDecimal price,
    Double availableQuantity,
    Integer categoryId,
    String categoryName,
    String categoryDescription
) {

}
