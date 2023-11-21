package TribuCannibali_COMPLETO;

import java.util.concurrent.locks.*;

public class Pentola_LockVarCond implements PentolaIF
{
	final int M = 5;
	int cannibaliCheMangiano;
	int numPastiDisponibili;
	Lock mutex;
	Condition waitCannibali;
	Condition waitCuoco;

	Pentola_LockVarCond()
	{
		this.cannibaliCheMangiano = 0;
		this.numPastiDisponibili = 0;
		this.mutex = new ReentrantLock();
		this.waitCannibali = mutex.newCondition();
		this.waitCuoco = mutex.newCondition();
	}

	public void serviti() throws InterruptedException
	{
		mutex.lock();
		try {
			if(numPastiDisponibili > 0)
			{
				cannibaliCheMangiano++;
				numPastiDisponibili--;
				System.out.println(Thread.currentThread().getName() + ": pasto servito. Cannibali che mangiano: " + cannibaliCheMangiano + "; Pasti rimasti: " + numPastiDisponibili + ".");
			}
			else if(numPastiDisponibili == 0)
				waitCuoco.signal();
		} finally {
			mutex.unlock();
		}
	}

	public void riempi() throws InterruptedException
	{
		mutex.lock();
		try {
			while(numPastiDisponibili != 0)
				waitCuoco.await();
			numPastiDisponibili = M;
			System.out.println(Thread.currentThread().getName() + ": pentola riempita! Ora risveglio i porci!");
			waitCannibali.signalAll();
		} finally {
			mutex.unlock();
		}
	}
}
