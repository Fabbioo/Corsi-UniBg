package DistributoreProdotti_COMPLETO;

import java.util.concurrent.Semaphore;

public class DistributoreProdotti_Semaphore
{
	String nome; // Nome del prodotto.
	int qta; 	 // Quantità residua del prodotto.
	float prezzo; // Prezzo del prodotto.

	Semaphore mutex; 	// Semaforo che regola la mutua esclusione (semaforo binario).

	DistributoreProdotti_Semaphore(String nome, int qta, float prezzo)
	{
		this.nome = nome;
		this.qta = qta;
		this.prezzo = prezzo;

		this.mutex = new Semaphore(1);
	}

	public void preleva(int qtaDaPrelevare) throws InterruptedException
	{
		try {
			mutex.acquire();

			qta = qta - qtaDaPrelevare;

			System.out.println("Quantita residua del prodotto " + nome + ": " + qta);
		} finally {
			mutex.release();
		}
	}

	public void restituisci(int qtaDaRestituire) throws InterruptedException
	{
		try {
			mutex.acquire();

			qta = qta + qtaDaRestituire;

			System.out.println("Quantita residua del prodotto " + nome + ": " + qta);
		} finally {
			mutex.release();
		}
	}
}
