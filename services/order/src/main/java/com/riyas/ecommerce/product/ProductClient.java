package com.riyas.ecommerce.product;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.riyas.ecommerce.exceptions.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductClient {


  @Value("${application.config.product-url}")
  private String productUrl;
  private final RestTemplate restTemplate;

  public List<PurchaseResponse> purchaseResponse(List<PurchaseRequest> requestBody) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);

    ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<List<PurchaseResponse>>() {
    };

    ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
        productUrl + "/purchase",
        HttpMethod.POST,
        requestEntity,
        responseType);

    if (responseEntity.getStatusCode().isError()) {
      throw new BusinessException(
          "An error occurred while processing the Product Purchase: " + responseEntity.getStatusCode());
    }

    return responseEntity.getBody();
  }


}
