package Veicoli;

public abstract class Veicolo
{
	String targa;

	public Veicolo(String targa)
	{
		this.targa = targa;
	}

	public String getTarga()
	{
		return targa;
	}

	public abstract int getPeso();
	public abstract String getTipo();
	public abstract String getMarca();
	public abstract String getModello();
}
