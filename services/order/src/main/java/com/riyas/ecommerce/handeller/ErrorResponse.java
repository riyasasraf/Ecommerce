package com.riyas.ecommerce.handeller;

import java.util.Map;

public record ErrorResponse(
  Map<String, String> errors
) {
} 