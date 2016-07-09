//////////////////////////////////////////////////////////////////////
///
/// Contents: MandelbrotSet
/// Author:   Reggie Barnett
/// Date:     September 2012
///
//////////////////////////////////////////////////////////////////////


import java.awt.* ;
import javax.swing.* ;
import java.util.Scanner ;
import java.util.Date ;
import java.lang.Math;

public class MandelbrotSet {

	public static void main(String[] args) {
  	
		int xSize = Integer.parseInt(args[0]);
		int ySize = Integer.parseInt(args[0]);
		double xmin = Double.parseDouble(args[1]);
		double xmax = Double.parseDouble(args[2]);
		double ymin = Double.parseDouble(args[3]);
		double ymax = Double.parseDouble(args[4]);
		double xit = .0002;
		double yit = .0002;
		int i = 0;
		double X,Y,tempX;
	
  
  		JFrame frame = new JFrame("MandelbrotSet") ;
   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
   	ImagePanel image = new ImagePanel(xSize,ySize,xmin,xmax,ymin,ymax);
   	frame.getContentPane().add(image) ;
		frame.pack() ;
   	frame.setVisible(true) ;
	
		for(double x = xmin; x <= xmax; x=x+xit){
			for(double y = ymin; y <= ymax; y=y+yit){
			X=0;
			Y=0;
			for(i = 0; i <= 100; i++){
				tempX = (X*X) - (Y*Y) + x;
				Y = (2 * X * Y) + y; 
				X = tempX;
				
				if((X*X) + (Y *Y) > 4){
					image.color(x, y, i);
				break;
				}
				
			}
			}	
   	frame.repaint() ;
		}
	}
}

/// End-of-File