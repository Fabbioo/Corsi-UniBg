package ContatoreSincronizzato_COMPLETO;

public class Main
{
	public static void main(String[] args)
	{
		Contatore_Synchro contatore = new Contatore_Synchro();

		Thread incrThread = new Thread(new Incrementatore(contatore), "Incrementatore");
		Thread decrThread = new Thread(new Decrementatore(contatore), "Decrementatore");

		incrThread.start();
		decrThread.start();
	}
}
