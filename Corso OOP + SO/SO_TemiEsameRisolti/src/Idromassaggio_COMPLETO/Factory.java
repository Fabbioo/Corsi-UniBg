package Idromassaggio_COMPLETO;

public class Factory
{
	public static void main(String[] args)
	{
		Idromassaggio_LockVarCond idromassaggio = new Idromassaggio_LockVarCond(3);
		
		int nd = 5;
		int nu = 10;
		
		for(int i = 0; i < nu; i++)
			new Uomo(idromassaggio, i+1).start();

		for(int i = 0; i < nd; i++)
			new Donna(idromassaggio, i+1).start();
	}
}
