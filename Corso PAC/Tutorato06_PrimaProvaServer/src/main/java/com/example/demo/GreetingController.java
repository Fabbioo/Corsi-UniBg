package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Passi seguiti fino a questo punto:
 * _ ho creato l'applicazione (annotata con @SpringBootApplication);
 * _ ho creato l'oggetto che deve essere ritornato (classe Greeting);
 * _ ho creato il servizio che crea l'oggetto che deve essere ritornato (classe GreetingService).
 * 
 * Ciò che rimane da implementare è ciò che collega il servizio all'applicazione.
 */

// La classe GreetingController, che deve essere annotata con @RestController, è quella che deve essere
// utilizzata da REST quando si devono gestire delle richieste.

@RestController
public class GreetingController {
	
	// Innanzitutto bisogna dire al RestController qual è il servizio che è stato implementato:
	@Autowired
	private GreetingService service = new GreetingService();
		// Autowired permette di fare due cose:
		// 1) collegare correttamente il controller al servizio che deve essere chiamato;
		// 2) appena creo il controller, ancora prima di poter gestire le chiamate (ovvero tutte quelle
		// operazioni per cui il controller è stato creato), deve caricare il servizio -> se c'è il
		// controller, ma non il servizio da chiamare, il controller non può fare niente. Questa situazione
		// viene risolta dalla notazione @Autowired.
	
	private AtomicLong counter = new AtomicLong();
	
	// Implemento il metodo che viene chiamato nel controller, il quale a sua volta deve chiamare il
	// servizio, il quale a sua volta ritorna la risorsa creata nella classe Greeting.
	@GetMapping("/greeting")
	public Greeting sayHello(@RequestParam(defaultValue = "World") String name) {
		return service.sayHello(name, counter);
	}
		// REST lavora con delle richieste HTTP, quindi ciò che si deve fare è specificare l'url che si
		// vuole chiamare affinchè REST stesso chiami il metodo sayHello(). A tal fine si deve specificare
		// sul metodo sayHello() l'annotazione @GetMapping("/greeting"), dove "/greeting" è l'url da chiamare.
	
		// Opzionale: specificare il valore di default per il parametro name. Questo può essere utile nel
		// caso in cui chi utilizza la mia API non sappia che si deve passare anche un nome all'API.
		// Per specificare il valore di default per il parametro name si utilizza l'annotazione
		// @RequestParam.
}
