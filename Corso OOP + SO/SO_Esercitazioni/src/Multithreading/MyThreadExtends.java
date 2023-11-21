package Multithreading;

public class MyThreadExtends extends Thread
{
	// Override del metodo run():
	public void run()
	{
		System.out.println(getName() + ": Ciao mondo! (extends)");

		/*
		 * ATTENZIONE:
		 * Poichè la classe MyThreadExtends estende la classe Thread (quindi è come se stessi usando direttamente la classe Thread),
		 * non c'è bisogno di richiamare il metodo statico currentThread() per poi risalire al metodo getName():
		 * sfrutto direttamente il metodo getName().
		 */
	}
}
