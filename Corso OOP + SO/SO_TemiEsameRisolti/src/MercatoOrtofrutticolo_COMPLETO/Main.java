package MercatoOrtofrutticolo_COMPLETO;

public class Main
{
	public static void main(String[] args)
	{
		Mercato_Semaphore mercato = new Mercato_Semaphore(1000,1000); // Arbitrariamente decido che il mercato ha una quantità iniziale di merce pari a 1000 e una cassa pari a 1000
		
		for(int i = 0; i < 5; i++)
		{
			Produttore prod = new Produttore(mercato, (int)(Math.random() * 4) + 1);
			prod.setName("PROD - " + (i + 1));
			prod.start();
		}
		
		for(int i = 0; i < 5; i++)
		{
			Grossista gros = new Grossista(mercato, (int)(Math.random() * 3) + 1, 1000); // Arbitrariamente decido che il grossista ha un budget iniziale di 1000
			gros.setName("GROS - " + (i + 1));
			gros.start();
		}
	}
}
