import java.util.ArrayList;
public class Tour
{
	private ArrayList<City> t;
	private int total; //Keeps track of distance between cities on x,y plane.
	
	public Tour() 
	{ 
		t = new ArrayList<City>(); 
		this.setTotal(0);
	}
	public int getTotal() 			
	{ 								    
		int get = 0;
		for (int i = 0; i < t.size() - 1; i++)
			get += t.get(i).compareTo(t.get(i+1));
		this.setTotal(get);
		return get; 
	}
	public void add (City c) 
	{ 
		if (c == null) return;
		else t.add(c);
		if (t.size() > 1) total += t.get(t.size() - 1).compareTo(t.get(t.size() - 2));
	}
	public City get(int i) { return t.get(i); }
	public int size() { return t.size(); }
	public boolean twoOpt() //Implementation of 2-Optimal Algorithm.
	{
		int edgeA, edgeB, edgeAa, edgeBb = 0;
		for (int i = 0; i < t.size() - 1; i++)
		{
			for (int j = i+2; j < t.size() - 1; j++)
			{
				edgeA = t.get(i).compareTo(t.get(i+1)); 
				edgeB = t.get(j).compareTo(t.get(j+1));
				edgeAa = t.get(i).compareTo(t.get(j));
				edgeBb = t.get(i+1).compareTo(t.get(j+1));
				int testTotal = total - edgeA - edgeB + edgeAa + edgeBb; //Removes the two old edges and adds two new ones,
				if (testTotal < total)									 //then checks for difference against old total.
				{
					this.flip(i+2, j-1);
					this.setTotal(testTotal);
					this.swap(i+1, j);
					return true;
				}
			}
		}
		return false;
	}

	private void swap(int i, int j) //Swaps position of two nodes.
	{
		City temp = t.get(i);
		t.set(i, t.get(j));
		t.set(j, temp);
	}
	private void flip(int i, int j) //Reverses direction of edges between the two swapped nodes.
	{
		for (i = i; i<=j; i++)
		{
			City temp = t.get(i);
			t.set(i, t.get(j));
			t.set(j, temp);
			j--;
		}
	}
	private void setTotal(int x) 
	{ 
		this.total = x; 
	}
}
	