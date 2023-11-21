
public class Eroe implements Umano
{
	int forza;
	
	public Eroe()
	{
		forza = 10;
	}
	
	public void combatti()
	{
		forza = forza - 3;
	}
	
	public String getForza()
	{
		return "Forza rimanente all'eroe: " + forza;
	}
}
