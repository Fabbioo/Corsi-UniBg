package Multithreading;

public class JoinableWorker implements Runnable
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + ": I'm working");
	}
}
