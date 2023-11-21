package DistributoreProdotti_COMPLETO;

public class Cliente_LockVarCond extends Thread
{	
	String nome;
	float contoResiduo;
	int qtaDaPrelevare;
	int qtaDaRestituire;
	DistributoreProdotti_LockVarCond p;

	Cliente_LockVarCond(String nome, float contoResiduo, int qtaDaPrelevare, int qtaDaRestituire, DistributoreProdotti_LockVarCond p)
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
		
		if((p.prezzo * qtaDaPrelevare) > contoResiduo)
			throw new RuntimeException("Il cliente " + nome + " non ha credito sufficiente.");
		
		try {
			p.preleva(qtaDaPrelevare);
		} catch(InterruptedException e) { }
		
		contoResiduo = contoResiduo - (p.prezzo * qtaDaPrelevare);
		
		System.out.println(Thread.currentThread().getName() + " -> Conto residuo dopo l'acquisto: " + contoResiduo + ".");
		
		System.out.println(Thread.currentThread().getName() + ": ho preso troppo prodotto. Restituisco.");
		
		try {
			p.restituisci(qtaDaRestituire);
		} catch(InterruptedException e) { }
		
		contoResiduo = contoResiduo + (p.prezzo * qtaDaRestituire);
		
		System.out.println(Thread.currentThread().getName() + " -> Conto residuo dopo la restituzione: " + contoResiduo);
	}
}
