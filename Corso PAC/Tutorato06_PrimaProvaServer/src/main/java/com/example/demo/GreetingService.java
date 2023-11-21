package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
	// La classe AtomicLong serve per gestire dei contatori in processi che potrebbero essere concorrenti.
	// Essendo in fase di sviluppo di un server non so a priori quanti client gli andranno a mandare
	// richieste contemporaneamente.

import org.springframework.stereotype.Service;

/*
 * Una volta definita la classe del Presentation Model bisogna definire il servizio vero e proprio, ovvero
 * il cosiddetto Domain Model. Il Domain Model è l'interfaccia.
 * Quindi: chiamo il servizio, il servizio crea un nuovo oggetto di tipo Greeting e lo ritorna.
 * 
 * Riassumendo:
 * _ la classe Greeting definisce l'oggetto che deve essere ritornato;
 * _ la classe GreetingService definisce il servizio che implementa il metodo che deve essere chiamato
 *   per ricevere l'oggetto ritornato.
 */

// Per specificare che la classe GreetingService è effettivamente un servizio REST devo utilizzare la
// notazione @Service.
@Service
public class GreetingService {
	public Greeting sayHello(String name, AtomicLong counter) {
		return new Greeting(counter.incrementAndGet(), "Hello " + name);
	}
}
