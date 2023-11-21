
public class Main
{
	public static void main(String[] args)
	{
		Eroe e = new Eroe();
		Licantropo l = new Licantropo(true);
		Vampiro v = new Vampiro();
		
		e.combatti();
		e.combatti();
		e.combatti();
		l.azzanna();
		l.azzanna();
		v.azzanna();
		
		System.out.println(e.getForza());
	    System.out.println(v.getForza());
	    System.out.println(l.getForza());
	}
}
