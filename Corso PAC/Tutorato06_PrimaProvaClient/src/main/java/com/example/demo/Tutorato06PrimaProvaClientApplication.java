package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Tutorato06PrimaProvaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tutorato06PrimaProvaClientApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Il template è il modo che REST utilizza per gestire le chiamate.
		return builder.build(); // Costruisco un RestTemplate vuoto.
	}
	
	// Definisco il metodo da utilizzare.
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		// Questo metodo run() sovrascrive il run() presente nel metodo main().
		// Utilizzo una funzione lambda.
		return args -> {
			Greeting returnedGreeting = restTemplate.getForObject("http://localhost:8080/greeting?name=FFaabbiioo", Greeting.class);
			System.out.println(returnedGreeting.toString());
		};
	}
}
