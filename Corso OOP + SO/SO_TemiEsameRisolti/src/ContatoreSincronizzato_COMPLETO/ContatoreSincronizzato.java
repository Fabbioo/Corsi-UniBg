package ContatoreSincronizzato_COMPLETO;

public interface ContatoreSincronizzato
{
	public abstract void increment() throws InterruptedException;
	public abstract void decrement() throws InterruptedException;
}
