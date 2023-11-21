package Telecamere;

public class TelecameraNormale extends Telecamera
{
	public TelecameraNormale(String descrizione, StatoTelecamera statoTelecamera, int posizione)
	{
		super(descrizione, posizione);
		this.statoTelecamera = statoTelecamera;
	}

	public String getTipo()
	{
		return "Normale";
	}
	
	public void accendiTelecamera()
	{
		if(statoTelecamera == StatoTelecamera.SPENTA || statoTelecamera == StatoTelecamera.BLOCCO)
			statoTelecamera = StatoTelecamera.ACCESA;
	}

	public void spegniTelecamera()
	{
		if(statoTelecamera == StatoTelecamera.ACCESA || statoTelecamera == StatoTelecamera.BLOCCO)
			statoTelecamera = StatoTelecamera.SPENTA;
	}

	public void bloccoImmagineTelecamera()
	{
		if(statoTelecamera == StatoTelecamera.ACCESA || statoTelecamera == StatoTelecamera.SPENTA)
			statoTelecamera = StatoTelecamera.BLOCCO;
	}
}
