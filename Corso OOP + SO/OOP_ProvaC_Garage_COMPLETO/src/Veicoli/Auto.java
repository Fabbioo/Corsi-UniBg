package Veicoli;

public class Auto extends Veicolo
{
	String marca;
	String modello;

	public Auto(String targa, String marca, String modello)
	{
		super(targa);
		this.marca = marca;
		this.modello = modello;
	}

	public String getTipo()
	{
		return "Autoooo";
	}

	public int getPeso()
	{
		return 0;
	}

	public String getMarca()
	{
		return marca;
	}

	public String getModello()
	{
		return modello;
	}
}
