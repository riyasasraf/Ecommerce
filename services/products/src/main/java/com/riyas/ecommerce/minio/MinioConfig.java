package com.riyas.ecommerce.minio;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

@Configuration
@Slf4j
public class MinioConfig {

  @Value("${minio.url}")
  private String endPoint;
  @Value("${minio.accessKey}")
  private String accessKey;
  @Value("${minio.secretKey}")
  private String secretKey;
  @Bean
  public S3Client s3Client() {
    log.info("the enpoint is " + endPoint);
    log.info("the accessKey is " + accessKey);
    log.info("the secretKey is " + secretKey);

    return S3Client.builder().endpointOverride(URI.create(endPoint))
        .credentialsProvider(StaticCredentialsProvider
            .create(AwsBasicCredentials.create(accessKey, secretKey)))
        .region(Region.US_EAST_1)
        .serviceConfiguration(S3Configuration
            .builder()
            .pathStyleAccessEnabled(true).build())
            .httpClientBuilder(UrlConnectionHttpClient.builder())
        .build();
  }

}
