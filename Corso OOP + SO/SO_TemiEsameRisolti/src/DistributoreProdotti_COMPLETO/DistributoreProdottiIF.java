package DistributoreProdotti_COMPLETO;

public interface DistributoreProdottiIF
{
	public abstract void preleva(int qtaDaPrelevare) throws InterruptedException;
	public abstract void restituisci(int qtaDaRestituire);
}
