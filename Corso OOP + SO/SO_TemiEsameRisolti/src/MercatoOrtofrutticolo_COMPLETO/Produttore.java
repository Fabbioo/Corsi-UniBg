package MercatoOrtofrutticolo_COMPLETO;

public class Produttore extends Thread
{
	private Mercato_Semaphore mercato;
	private int quantita;
	
	Produttore(Mercato_Semaphore mercato, int quantita)
	{
		this.mercato = mercato;
		this.quantita = quantita;
	}

	public void run()
	{
		while(true)
		{
			try {
				mercato.vendi(quantita);
				sleep((int)(Math.random() * 5000));
			} catch(InterruptedException ie) { }
		}
	}
}
