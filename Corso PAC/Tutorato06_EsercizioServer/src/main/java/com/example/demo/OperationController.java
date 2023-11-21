package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
	
	// Specifico il servizio che deve essere utilizzato dal controller:
	@Autowired
	private OperationService service = new OperationService();
	
	// Dichiaro quale sia il metodo che consente di effettuare la moltiplicazione:
	@GetMapping("/moltiplica")
	public Result moltiplica(int num1, int num2) {
		// All'interno del servizio chiamo il metodo che effettua la moltiplicazione:
		return service.moltiplica(num1, num2);
	}
	
	@GetMapping("/somma")
	public Result somma(int num1, int num2) {
		// All'interno del servizio chiamo il metodo che effettua la somma:
		return service.somma(num1, num2);
	}
}
