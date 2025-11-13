package com.example.backend;

import io.github.cdimascio.dotenv.Dotenv; // <-- ADD THIS IMPORT
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		// Only load .env if running locally (NOT on Heroku)
    if (System.getenv("DYNO") == null) {
        // Running locally
        try {
            Dotenv dotenv = Dotenv.load();
            System.setProperty("AWS_ACCESS_KEY_ID", dotenv.get("AWS_ACCESS_KEY_ID"));
            System.setProperty("AWS_SECRET_ACCESS_KEY", dotenv.get("AWS_SECRET_ACCESS_KEY"));
            System.setProperty("AWS_REGION", dotenv.get("AWS_REGION"));
            System.setProperty("AWS_BUCKET_NAME", dotenv.get("AWS_BUCKET_NAME"));
        } catch (Exception e) {
            System.out.println("Warning: Could not load .env file locally.");
        }
    }

    SpringApplication.run(BackendApplication.class, args);
	}
}