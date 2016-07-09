import java.awt.*;
import javax.swing.* ;

public class Map extends JPanel
{
	private
		Tour t;
		int width, height;
		int BOX_SIDE = 3;
	public
		Color BACKGROUND = Color.white;
		Color FOREGROUND = Color.blue;
	
	public Map(int w, int h) 
	{
		if (w > 0 && h > 0)
		{	
			width = w;
			height = h;
			this.setPreferredSize(new Dimension(width,height));
			this.setBackground(BACKGROUND);
		}
	}
	public void updateTour(Tour tour) 
	{ 
		if (tour != null) 
		{
			t = tour;
			repaint();
		}
	}
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.setColor(FOREGROUND);
			for (int i = 0; i < t.size(); i++)
			{
				g.fillRect( t.get(i).getX(), t.get(i).getY(), BOX_SIDE, BOX_SIDE);
				if (i > 0) g.drawLine( t.get(i-1).getX(), t.get(i-1).getY(), t.get(i).getX(), t.get(i).getY() );
			}
	}	
}


	