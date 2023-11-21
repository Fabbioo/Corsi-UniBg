package Pratiche;

// Enumerativo che rappresenta i diversi gradi delle pratiche civile e penale.
public enum GradoGiudizio
{
	PRIMO(1), SECONDO(2), CASSAZIONE(3);

	int fattoreCosto;

	GradoGiudizio(int i)
	{
		this.fattoreCosto = i;
	}
}
