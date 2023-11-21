package Audio;

public class Utente
{
	String email;
	Audio[] generiPreferiti;

	Utente(String email, Audio[] generiPreferiti)
	{
		this.email = email;
		this.generiPreferiti = new Audio[8];
	}

	public Audio[] getGeneriPreferiti()
	{
		return this.generiPreferiti;
	}
}
