
public class City implements Comparable<City>
{
	private int x, y;
	public City(int a, int b)
	{
		if (a < 0 || b < 0)
		{
			a = 0;
			b = 0;
		}
		this.x = a;
		this.y = b;
	}
	public int getX()
	{ 
		return x ; 
	}
	public int getY()
	{ 
		return y ;
	}
	public int compareTo(City other) //Returns distance between cities on the x,y plane.
	{
		int deltaX = other.getX() - this.getX();
		int deltaY = other.getY() - this.getY();
		double dist = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		return (int)dist;
	}
	public boolean equals(Object o) 
	{
		if (!(o instanceof City))
			return false;
		else 
		{
			City c = (City)o;
			return (this.compareTo(c) == 0);
		}
	}
}
	