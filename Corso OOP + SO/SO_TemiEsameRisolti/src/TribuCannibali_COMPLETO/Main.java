package TribuCannibali_COMPLETO;

public class Main
{
	public static void main(String[] args)
	{
		Pentola_LockVarCond pentola = new Pentola_LockVarCond();
		
		new Cuoco(pentola).start();
		
		for(int i = 0; i < 10; i++)
			new Cannibale(pentola, i + 1).start();
	}
}
