package Sincronizzazione;

public interface Buffer
{
	// Buffer è l'interfaccia che spiega quali saranno i metodi invocati sull'oggetto condiviso.

	// Dichiaro un metodo per inserire un oggetto nel buffer -> verrà invocato dal produttore.
	public abstract void insert(Object item) throws InterruptedException; 
		// In genere si sfrutta Object come tipo per gli oggetti che si vanno ad inserire nel buffer.

	// Dichiaro un metodo per rimuovere un oggetto dal buffer -> verrà invocato dal consumatore.
	public abstract Object remove() throws InterruptedException;
}
