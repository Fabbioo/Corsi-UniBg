package Multithreading;

class ThreadSimbolo extends Thread
{
	char s;

	ThreadSimbolo(char s)
	{
		this.s = s;
	}

	public void run()
	{
		for(int i = 1;;i++)
		{
			System.out.print(s);
			if(i == 50)
			{
				System.out.println(s);
				i = 1;
			}
		}
	}
}
public class Simboli
{
	public static void main(String[] args)
	{
		Thread t1 = new ThreadSimbolo('*');
		Thread t2 = new ThreadSimbolo('#');

		t1.start();
		t2.start();
	}
}
