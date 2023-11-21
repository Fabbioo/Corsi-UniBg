package Piscina_COMPLETO;

import java.util.concurrent.locks.*;

public class Piscina_LockVarCond implements PiscinaIF
{
	private int MAXP = 5;
	private int nO;
	private int nI;
	private int waitO;
	private int waitI;
	private Lock lock;
	private Condition codaO;
	private Condition codaI;

	Piscina_LockVarCond()
	{
		this.nO = 0;
		this.nI = 0;
		this.waitO = 0;
		this.waitI = 0;
		this.lock = new ReentrantLock();
		this.codaO = lock.newCondition();
		this.codaI = lock.newCondition();
	}

	public void entraO() throws InterruptedException
	{
		lock.lock();
		try {
			while(nO + nI > MAXP || nI > 0)
			{
				waitO++;
				codaO.await();
				waitO--;
			}
			nO++;
			System.out.println(Thread.currentThread().getName() + " entra -> O: " + nO + "; I: " + nI);
		} finally {
			lock.unlock();
		}
	}

	public void esceO() throws InterruptedException
	{
		lock.lock();
		try {
			nO--;
			if(nO == 0 && waitO > 0)
				codaO.signal();
			else if(nO == 0 && waitO == 0)
				codaI.signalAll();
			System.out.println(Thread.currentThread().getName() + " esce  -> O: " + nO + "; I: " + nI);
		} finally {
			lock.unlock();
		}
	}

	public void entraI() throws InterruptedException
	{
		lock.lock();
		try {
			while(nO + nI > MAXP || nO > 0 || waitO > 0)
			{
				waitI++;
				codaI.await();
				waitI--;
			}
			nI++;
			System.out.println(Thread.currentThread().getName() + " entra -> O: " + nO + "; I: " + nI);
		} finally {
			lock.unlock();
		}
	}

	public void esceI() throws InterruptedException
	{
		lock.lock();
		try {
			nI--;
			if(nI == 0 && waitI > 0)
				codaI.signal();
			else if(nI == 0 && waitI == 0)
				codaO.signalAll();
			System.out.println(Thread.currentThread().getName() + " esce  -> O: " + nO + "; I: " + nI);
		} finally {
			lock.unlock();
		}
	}
}
