package com.nasaclient;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasaclient.model.ApiKey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	public ApiKey apiKey() {
		try {
			byte[] configs = Files.readAllBytes(Paths.get("configs.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			ApiKey apiKey = objectMapper.readValue(configs, ApiKey.class);
			return apiKey;
		} catch (Exception e) {
			ApiKey apiKey = new ApiKey(); // default api key
			System.out.println("Using demo key: " + apiKey.getKey());
			return apiKey;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
