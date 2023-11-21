package DistributoreProdotti_COMPLETO;

public class Test
{
	public static void main(String[] args) throws InterruptedException
	{
		//int i = 1;		// Sincronizzazione diretta/indiretta -> COMPLETO
		//int i = 2;		// Semafori -> COMPLETO
		int i = 3;			// Lock e variabili condizione -> COMPLETO
		
		if(i == 1)
		{
			DistributoreProdotti_SynchroDI p1 = new DistributoreProdotti_SynchroDI("Mele", 10, 15);
			DistributoreProdotti_SynchroDI p2 = new DistributoreProdotti_SynchroDI("Pere", 20, 25);
			
			Cliente_SynchroDI u1 = new Cliente_SynchroDI("Fabio", 1000, 0, 2, p1);
			Cliente_SynchroDI u2 = new Cliente_SynchroDI("Marco", 1000, 5, 1, p1);
			Cliente_SynchroDI u3 = new Cliente_SynchroDI("Anton", 1000, 3, 3, p2);
			
			Thread t1 = new Thread(u1, u1.nome);
			Thread t2 = new Thread(u2, u2.nome);
			Thread t3 = new Thread(u3, u3.nome);
			
			t1.start();
			t2.start();
			t3.start();
			
			t1.join();
			t2.join();
			t3.join();

			System.out.println("\n" + u1.nome + " ha " + u1.contoResiduo);
			System.out.println(u2.nome + " ha " + u2.contoResiduo);
			System.out.println(u3.nome + " ha " + u3.contoResiduo);
		}
		else if(i == 2)
		{
			DistributoreProdotti_Semaphore p1 = new DistributoreProdotti_Semaphore("Mele", 20, 25);
			DistributoreProdotti_Semaphore p2 = new DistributoreProdotti_Semaphore("Pere", 30, 35);
			
			Cliente_Semaphore u1 = new Cliente_Semaphore("Fabio", 1000, 0, 2, p1);
			Cliente_Semaphore u2 = new Cliente_Semaphore("Marco", 1000, 5, 1, p1);
			Cliente_Semaphore u3 = new Cliente_Semaphore("Anton", 1000, 3, 3, p2);
			
			Thread t1 = new Thread(u1, u1.nome);
			Thread t2 = new Thread(u2, u2.nome);
			Thread t3 = new Thread(u3, u3.nome);
			
			t1.start();
			t2.start();
			t3.start();
			
			t1.join();
			t2.join();
			t3.join();

			System.out.println("\n" + u1.nome + " ha " + u1.contoResiduo);
			System.out.println(u2.nome + " ha " + u2.contoResiduo);
			System.out.println(u3.nome + " ha " + u3.contoResiduo);
		}
		else
		{
			DistributoreProdotti_LockVarCond p1 = new DistributoreProdotti_LockVarCond("Mele", 30, 35);
			DistributoreProdotti_LockVarCond p2 = new DistributoreProdotti_LockVarCond("Pere", 40, 45);
			
			Cliente_LockVarCond u1 = new Cliente_LockVarCond("Fabio", 1000, 0, 2, p1);
			Cliente_LockVarCond u2 = new Cliente_LockVarCond("Marco", 1000, 5, 1, p1);
			Cliente_LockVarCond u3 = new Cliente_LockVarCond("Anton", 1000, 3, 3, p2);
			
			Thread t1 = new Thread(u1, u1.nome);
			Thread t2 = new Thread(u2, u2.nome);
			Thread t3 = new Thread(u3, u3.nome);
			
			t1.start();
			t2.start();
			t3.start();
			
			t1.join();
			t2.join();
			t3.join();

			System.out.println("\n" + u1.nome + " ha " + u1.contoResiduo);
			System.out.println(u2.nome + " ha " + u2.contoResiduo);
			System.out.println(u3.nome + " ha " + u3.contoResiduo);
		}
	}
}
