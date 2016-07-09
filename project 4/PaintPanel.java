import java.awt.* ;
import javax.swing.* ;

public class PaintPanel extends JPanel {

  public Color BACKGROUND = Color.blue ;
  public Color FOREGROUND = Color.red ;

  public int width, height ;
  public int box_x, box_y, box_width, box_height ;
  int[][] myArray;

  public PaintPanel(int w, int h) {
    this.width = w ;
    this.height = h ;
    setPreferredSize(new Dimension(w,h)) ;
  }

	public void setArray(int[][] ar){
	myArray=ar;
	}
  
  public void paint(Graphics g){
  g.setColor(BACKGROUND);
  g.fillRect(0,0,width, height);
  	for(int i=0;i<myArray.length;i++){
				for(int j=0;j<myArray.length;j++){
					if(myArray[i][j]==1){
					g.setColor(FOREGROUND);
					g.fillRect(i*20,j*20,20,20);
					}
				}
			}	
  }

}

/// End-of-File