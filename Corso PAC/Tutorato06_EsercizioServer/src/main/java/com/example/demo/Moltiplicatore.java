package com.example.demo;

// Successivamente alla definizione della struttura dell'oggetto da ritornare definisco la struttura che
// consente di effettuare la moltiplicazione. In altre parole, definisco il Domain Model.
public class Moltiplicatore {
	
	int num1;
	int num2;
	
	public Moltiplicatore(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	// Creo l'operazione che effettua la moltiplicazione:
	public Result getProduct() {
		return new Result(num1 * num2);
	}
	
}
