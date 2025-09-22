package com.riyas.ecommerce.minio;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@RequiredArgsConstructor
public class ImageService {
  
  @Value("${minio.bucket}")
  private String bucketName;
  private final S3Client s3Client;

  public String uploadImage(MultipartFile file) throws IOException {
    String key = UUID.randomUUID() + "-" + file.getOriginalFilename();

    s3Client.putObject(
        PutObjectRequest.builder().bucket(bucketName).key(key).contentType(file.getContentType()).build(),
        RequestBody.fromBytes((file.getBytes())));
        
    return getPublicUrl(key);
  }

  public String getPublicUrl(String key) {
    return String.format("http://localhost:9000/%s/%s", bucketName, key);
  }


}
