package com.example.demo;

/*
 * L'idea è quella di creare una classe per ogni applicazione che si vuole realizzare e per ogni dato che
 * si vuole gestire una classe che rappresenta il cosiddetto Presentation Model, ovvero quello che è
 * l'oggetto che deve essere ritornato dal servizio nell'interazione client-server.
 */

public class Greeting {
	
	// Nella classe Greeting bisogna definire tutte le informazioni di interesse:
	
	private long id;
	private String contenuto;
	
	public Greeting(long id, String contenuto) {
		this.id = id;
		this.contenuto = contenuto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	
	public String toString() {
		return "[ID]: " + id + ", [Contenuto]: " + contenuto;
	}
}
