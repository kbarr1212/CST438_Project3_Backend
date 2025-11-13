package com.example.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {

  private final S3Client s3Client;
  private final String bucketName;

  public S3Service(
          @Value("${AWS_ACCESS_KEY_ID}") String accessKeyId,
          @Value("${AWS_SECRET_ACCESS_KEY}") String secretKey,
          @Value("${AWS_REGION}") String region,
          @Value("${AWS_BUCKET_NAME}") String bucketName) {

      this.bucketName = bucketName;

      this.s3Client = S3Client.builder()
              .region(Region.of(region))
              .credentialsProvider(
                      StaticCredentialsProvider.create(
                              AwsBasicCredentials.create(accessKeyId, secretKey)
                      )
              )
              .build();
  }

  public String uploadFile(MultipartFile file) throws IOException {
      String key = UUID.randomUUID() + "_" + file.getOriginalFilename();

      PutObjectRequest request = PutObjectRequest.builder()
              .bucket(bucketName)
              .key(key)
              .contentType(file.getContentType())
              .build();

      s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));

      return "https://" + bucketName + ".s3.amazonaws.com/" + key;
  }
}