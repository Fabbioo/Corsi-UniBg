package TerrazzaPanoramica_COMPLETO;

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		TerrazzaPanoramicaIF m = new TerrazzaPanoramica_LockVarCond();

		for(int i = 0; i < 50; i++)
			new Visitatore(m, new Random().nextInt(2), "\nVisitatore " + (i + 1)).start();
			//new Random().nextInt(2); // Restituisce un intero compreso tra 0 e 1 (di fatto restituisce o 0 o 1).
	}
}
