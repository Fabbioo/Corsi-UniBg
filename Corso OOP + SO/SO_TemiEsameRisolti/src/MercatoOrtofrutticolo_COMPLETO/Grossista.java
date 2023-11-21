package MercatoOrtofrutticolo_COMPLETO;

public class Grossista extends Thread
{
	private Mercato_Semaphore mercato;
	private int quantita;
	private float budget;
	
	Grossista(Mercato_Semaphore mercato, int quantita, float budget)
	{
		this.mercato = mercato;
		this.quantita = quantita;
		this.budget = budget;
	}

	public void run()
	{
		while(true)
		{
			try {
				mercato.compra(quantita, budget);
				sleep((int)(Math.random() * 5000));
			} catch (InterruptedException e) { }
		}
	}
}
