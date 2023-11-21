
public class Circle extends Shape
{
	double r;
	
	public Circle(double r)
	{
		this.r = r;
	}
	
	public double getArea() 
	{
		return Math.PI * r * r;
	}	 
	
	public double getPerimetro()
	{ 
		return 2 * r * r * Math.PI;
	}
	
	public double getRaggio()
	{ 
		return r;
	}
}