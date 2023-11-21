package com.example.demo;

import org.springframework.stereotype.Service;

// Creo il servizio.
@Service
public class OperationService {
	
	// Creo il metodo che offre il servizio vero e proprio.
	public Result moltiplica(int num1, int num2) {
		return new Moltiplicatore(num1, num2).getProduct();
	}
	
	public Result somma(int num1, int num2) {
		return new Sommatore(num1, num2).getSum();
	}
}
