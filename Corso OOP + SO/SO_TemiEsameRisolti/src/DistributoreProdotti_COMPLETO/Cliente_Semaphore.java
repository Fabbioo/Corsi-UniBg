package DistributoreProdotti_COMPLETO;

public class Cliente_Semaphore extends Thread
{
	String nome;
	float contoResiduo;
	int qtaDaPrelevare;
	int qtaDaRestituire;
	DistributoreProdotti_Semaphore p;

	Cliente_Semaphore(String nome, float contoResiduo, int qtaDaPrelevare, int qtaDaRestituire, DistributoreProdotti_Semaphore p)
	{
		this.nome = nome;
		this.contoResiduo = contoResiduo;
		this.qtaDaPrelevare = qtaDaPrelevare;
		this.qtaDaRestituire = qtaDaRestituire;
		this.p = p;
	}

	public void run()
	{
		System.out.println(Thread.currentThread().getName()	+ " -> Conto residuo prima dell'acquisto: " + contoResiduo + ".");

		if(((p.prezzo * p.qta) <= contoResiduo) && (p.qta - qtaDaPrelevare) >= 0)
		{
			try {
				p.preleva(qtaDaPrelevare);
			} catch (InterruptedException e) { }
			
			contoResiduo = contoResiduo - (p.prezzo * qtaDaPrelevare);
			
			System.out.println(Thread.currentThread().getName() + " -> Conto residuo dopo l'acquisto: " + contoResiduo + ".");
			
			System.out.println(Thread.currentThread().getName() + ": ho preso troppo prodotto. Restituisco.");
			
			try {
				p.restituisci(qtaDaRestituire);
			} catch (InterruptedException e) { }
			
			contoResiduo = contoResiduo + (p.prezzo * qtaDaRestituire);
			
			System.out.println(Thread.currentThread().getName() + " -> Conto residuo dopo la restituzione: " + contoResiduo);
		}
		else
			System.out.println("Prelievo non riuscito");
	}
}
