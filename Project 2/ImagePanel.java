//////////////////////////////////////////////////////////////////////
///
/// Contents: Image panel for Mandelbrot Set
/// Author:   Reggie Barnett
/// Date:     September 2012
///
//////////////////////////////////////////////////////////////////////

import java.awt.* ;
import javax.swing.* ;

public class ImagePanel extends JPanel {

  private int xSize, ySize, dotSize = 5 ;
  private double minX, maxX, minY, maxY ;
  private float[][] image ;
  private Color background = Color.white, foreground = Color.blue ;

  public ImagePanel(int xSize, int ySize, double minX, double maxX, double minY, double maxY) {
    this.xSize = xSize ;
    this.ySize = ySize ;
    this.minX = minX ;
    this.maxX = maxX ;
    this.minY = minY ;
    this.maxY = maxY ;
    image = new float[xSize][ySize] ;
    setPreferredSize( new Dimension(xSize,ySize) ) ;
  }

  public void color(double x, double y, int z) {
    image[(int)(((x-minX)/(maxX-minX))*(double)xSize)][(int)(((y-minY)/(maxY-minY))*(double)ySize)] = (((float)z)/100) ;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g) ;
    g.setColor(background) ;
    g.fillRect(0,0,xSize,ySize) ;
    for (int x = 0 ; x < xSize ; x++) { for (int y = 0 ; y < ySize ; y++) {
	 
        g.setColor(Color.getHSBColor(image[x][y], (float).9,(float).9)) ;
        g.fillRect(x,y,dotSize,dotSize) ;
      
    }}
  }

}

