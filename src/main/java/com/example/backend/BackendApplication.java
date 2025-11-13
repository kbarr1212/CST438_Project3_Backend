package com.example.backend;

import io.github.cdimascio.dotenv.Dotenv; // <-- ADD THIS IMPORT
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		// --- LOAD .env BEFORE SPRING STARTS ---
		Dotenv dotenv = Dotenv.load();
		System.setProperty("AWS_ACCESS_KEY_ID", dotenv.get("AWS_ACCESS_KEY_ID"));
		System.setProperty("AWS_SECRET_ACCESS_KEY", dotenv.get("AWS_SECRET_ACCESS_KEY"));
		System.setProperty("AWS_REGION", dotenv.get("AWS_REGION"));
		System.setProperty("AWS_BUCKET_NAME", dotenv.get("AWS_BUCKET_NAME"));
		// --------------------------------------

		SpringApplication.run(BackendApplication.class, args);
	}
}