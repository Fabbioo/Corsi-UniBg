
public class Licantropo implements Mostro, Umano
{
	boolean isUomo;
	int forzaUmano;
	int forzaMostro;

	public Licantropo(boolean luna)
	{
		isUomo = !luna;
		if(luna)
		{
			forzaMostro = 15;
			forzaUmano = 0;
		}
		else
		{
			forzaMostro = 0;
			forzaUmano = 10;
		}
	}
	
	public String getForza()
	{
		return "Forza rimanente al licantro come umano: " + forzaUmano + "\nForza rimanente al licantropo come mostro: " + forzaMostro;
	}
	
	public void azzanna()
	{
		if(!isUomo)
			forzaMostro = forzaMostro - 2;
	}
	
	public void combatti()
	{
		if(isUomo)
			forzaUmano = forzaUmano - 3;
	}
}

