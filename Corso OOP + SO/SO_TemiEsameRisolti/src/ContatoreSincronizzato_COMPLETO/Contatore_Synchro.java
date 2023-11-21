package ContatoreSincronizzato_COMPLETO;

public class Contatore_Synchro implements ContatoreSincronizzato
{
	private static final int maxCapacity = 10;
	private static final int minCapacity = 0;
	private int count;

	Contatore_Synchro()
	{
		this.count = 0;
	}

	public synchronized void increment() throws InterruptedException
	{
		while(count >= maxCapacity)
			wait();

		count++;

		if(count == maxCapacity)
			System.out.println(Thread.currentThread().getName() + ": il contatore è ora pieno\n");
		else if(count == 1)
			System.out.println(Thread.currentThread().getName() + ": nel contatore c'è " + count + " elemento\n");
		else
			System.out.println(Thread.currentThread().getName() + ": nel contatore ci sono " + count + " elementi\n");

		notify();
	}

	public synchronized void decrement() throws InterruptedException
	{
		while(count <= minCapacity)
			wait();

		count--;

		if(count == minCapacity)
			System.out.println(Thread.currentThread().getName() + ": il contatore è ora vuoto\n");
		else if(count == 1)
			System.out.println(Thread.currentThread().getName() + ": nel contatore c'è " + count + " elemento\n");
		else
			System.out.println(Thread.currentThread().getName() + ": nel contatore ci sono " + count + " elementi\n");

		notify();
	}
}
