import java.awt.*;
import javax.swing.*;
import java.util.*;
public class TSP
{
	public static int WIDTH = 500, HEIGHT = 500, CITIES = 100, PAUSE = 50 ;
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Traveling Salesman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Map mapTSP = new Map(WIDTH,HEIGHT);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(mapTSP);
		frame.pack();
		frame.setVisible(true);
		
		Tour tourTSP = new Tour();
		Random r = new Random();
		
		City start = new City(0,0) ;
		
		tourTSP.add(start) ;
		for (int c = 0 ; c < CITIES; c++) 
			tourTSP.add(new City(r.nextInt(WIDTH),r.nextInt(HEIGHT)));
		tourTSP.add(start) ;
		
		mapTSP.updateTour(tourTSP);
		
		while (tourTSP.twoOpt()) 
		{ 
			mapTSP.updateTour(tourTSP); 
			sleep(PAUSE);		
		}
	}
	public static void sleep(long milliseconds) 
	{
		Date d ;
		long start, now ;
		d = new Date() ;
		start = d.getTime() ;
		do { d = new Date() ; now = d.getTime() ; } while ( (now - start) < milliseconds ) ;
	}
}
		