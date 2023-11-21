package Veicoli;

public class Furgone extends Veicolo
{
	int peso;

	public Furgone(String targa, int peso)
	{
		super(targa);
		this.peso = peso;
	}

	public String getTipo()
	{
		return "Furgone";
	}

	public int getPeso()
	{
		return peso;
	}

	public String getMarca()
	{
		return "";
	}

	public String getModello()
	{
		return "";
	}
}
