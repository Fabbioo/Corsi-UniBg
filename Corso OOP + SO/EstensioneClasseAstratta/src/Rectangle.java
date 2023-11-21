
public class Rectangle extends Shape
{ 
	double b,h;
	
	public Rectangle(double b, double h) 
	{
		this.b = b;
		this.h = h;
	}
	
	public double getArea()
	{
		return b * h;
	}
	
	public double getPerimetro()
	{
		return 2 * (b + h);
	}
	
	public double getBase()
	{
		return b;
	}
	
	public double getAltezza()
	{
		return h;
	} 
	
}