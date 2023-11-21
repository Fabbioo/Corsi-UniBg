package Piscina_COMPLETO;

public class Main
{
	public static void main(String[] args) 
	{
		int pazientiO = 5;
		int pazientiI = 5;
		Piscina_LockVarCond piscina = new Piscina_LockVarCond();
		for(int i = 0; i < pazientiO; i++)
			new PazienteOrtopedico(piscina, i + 1).start();
		for(int i = 0; i < pazientiI; i++)
			new PazienteInfettivo(piscina, i + 1).start();
	}
}
