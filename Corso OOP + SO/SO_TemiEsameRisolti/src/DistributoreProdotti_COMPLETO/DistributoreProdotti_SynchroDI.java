package DistributoreProdotti_COMPLETO;

public class DistributoreProdotti_SynchroDI implements DistributoreProdottiIF
{
	String nome; // Nome del prodotto.
	int qta; 	 // Quantità residua del prodotto.
	float prezzo; // Prezzo del prodotto.

	DistributoreProdotti_SynchroDI(String nome, int qta, float prezzo)
	{
		this.nome = nome;
		this.qta = qta;
		this.prezzo = prezzo;
	}

	public synchronized void preleva(int qtaDaPrelevare) throws InterruptedException
	{
		while(qta == 0) // Se non c'è alcun elemento del prodotto da prelevare, l'utente deve essere messo in attesa.
			wait();

		if(qtaDaPrelevare > qta)
			throw new RuntimeException("Impossibile prelevare la quantita inserita");
		System.out.println(Thread.currentThread().getName() + ": prelevo dallo scaffale");
		qta = qta - qtaDaPrelevare;
		System.out.println("Quantita residua di " + nome + ": " + qta);
		
		notify();
	}

	public synchronized void restituisci(int qtaDaRestituire)
	{
		System.out.println(Thread.currentThread().getName() + ": carico lo scaffale");

		qta = qta + qtaDaRestituire;

		System.out.println("Quantita residua di " + nome + ": " + qta);

		notify();
	}
}
