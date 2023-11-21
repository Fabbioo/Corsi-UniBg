
public class Square extends Rectangle
{
	double l;
	
	public Square(double l)
	{
		super(l,l);
	}
	
	public double getLato()
	{
		return this.getBase();
	}
	
	// Overriding del metodo getArea della superclasse Rectangle
	public double getArea(double l)
	{
		return l*l;
	}
	
	// Overriding del metodo getPerimetro della superclasse Rectangle
	public double getPerimetro(double l)
	{
		return 4*l;
	}
	
	public String toString()
	{
		return "lato: " + getBase();
	}
}
