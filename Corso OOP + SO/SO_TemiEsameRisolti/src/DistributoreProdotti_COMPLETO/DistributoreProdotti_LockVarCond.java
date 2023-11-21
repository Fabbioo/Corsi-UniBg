package DistributoreProdotti_COMPLETO;

import java.util.concurrent.locks.*;

public class DistributoreProdotti_LockVarCond
{	
	private String nome; 		// Nome del prodotto.
	private int qta; 	 		// Quantità residua del prodotto.
	float prezzo; 				// Prezzo del prodotto.
	private Lock lock;
	private Condition key;

	DistributoreProdotti_LockVarCond(String nome, int qta, float prezzo)
	{
		this.nome = nome;
		this.qta = qta;
		this.prezzo = prezzo;
		this.lock = new ReentrantLock();
		this.key = lock.newCondition();
	}

	public void preleva(int qtaDaPrelevare) throws InterruptedException
	{
		lock.lock();

		try {
			while(qtaDaPrelevare > qta) 
				key.await();

			System.out.println(Thread.currentThread().getName() + ": prelevo dallo scaffale");

			qta = qta - qtaDaPrelevare;

			System.out.println("Quantita residua di " + nome + ": " + qta);
		} finally {
			lock.unlock();
		}
	}

	public void restituisci(int qtaDaRestituire) throws InterruptedException
	{
		lock.lock();

		try {
			System.out.println(Thread.currentThread().getName() + ": carico lo scaffale");

			qta = qta + qtaDaRestituire;

			System.out.println("Quantita residua di " + nome + ": " + qta);

			key.signal();
		} finally {
			lock.unlock();
		}
	}
}
