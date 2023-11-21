package CokeMachine_COMPLETO;

// Interfaccia dell'oggetto condiviso -> oggetto condiviso = distributore di lattine.
// Definisco il contratto dell'oggetto condiviso.
// Nel contratto vi è la firma dei metodi messi a disposizione dall'oggetto condiviso.
public interface CokeMachineIF
{
	public void remove() throws InterruptedException;  // Azione effettuata dagli utenti -> gli utenti rimuovono lattine dal distributore.
	public void deposit() throws InterruptedException; // Azione effettuata dal rifornitore -> il rifornitore aggiunge lattine al distributore.
}
