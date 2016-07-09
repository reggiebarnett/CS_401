import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GameofLife{
	public static void main(String[] args){
	int size = 25;
	int WIDTH = 500, HEIGHT = 500, PAUSE = 500 ;
	
	JFrame frame = new JFrame("Game of Life") ;
	frame.setSize(WIDTH,HEIGHT);
    PaintPanel p = new PaintPanel(WIDTH,HEIGHT) ;
    frame.getContentPane().add(p) ;
    frame.setVisible(true) ;
	 
	int[][] map = GenMap(size);
	
	p.setArray(map);
	p.repaint();
	
	while(true){
		int[][] newmap = Scan(map,size);
		map = newmap;	
		p.setArray(map);
		p.repaint();
					
	sleep(PAUSE) ;
	}
	}//End main
	
	public static int[][] GenMap(int size){ //generates initial game of life map
		int[][] map = new int[size][size];
		for(int r=0;r<size;r++){
			for(int c = 0; c < size; c++){
			Random rand = new Random();
			int state = rand.nextInt(2);
				map[r][c] = state;
			}
		}
		return map;
	}//End GenMap
	
	public static int[][] Scan(int[][] map,int size){
		int[][] temp = new int[size][size];
		for(int r=0;r<size;r++){
			for(int c=0;c<size;c++){
				int count = countneighbors(map,r,c,size);
				if(map[r][c]==1){
					if(count<2||count>3){
						temp[r][c]=0;
					}
					else{
						temp[r][c]=1;
					}
				}
				else{
					if(count==3){
						temp[r][c]=1;
					}
					else{
						temp[r][c]=0;
					}
				}
		
			}
		}
		return temp;
	}//End Scan
	
	public static int countneighbors(int[][] map,int r, int c,int size){//counts neighboring cells that are alive  
		int count = 0;
    	if((r-1>=0)&&(c-1>=0)){
      	if(map[r-1][c-1]==1){
         	count++;
         }
    	}
    	if(r-1>=0){
         if(map[r-1][c]==1){
            count++;
         }
    	}
   	if((r-1>=0)&&(c+1<size)){
         if(map[r-1][c+1]==1){
            count++;
         }
    	}
    	if(c-1>=0){
         if(map[r][c-1]==1){
            count++;
         }
    	}
    	if(c+1<size){
         if(map[r][c+1]==1){
            count++;
         }
    	}
    	if((r+1<size)&&(c-1>=0)){
         if(map[r+1][c-1]==1){
            count++;
         }
    	}
    	if(r+1<size){
         if(map[r+1][c]==1){
            count++;
         }
    	}
    	if((r+1<size)&&(c+1<size)){
         if(map[r+1][c+1]==1){
            count++;
         }
    	}
   	 return count; 
	}//End countneighbors
	
	 public static void sleep(long milliseconds) {
    Date d ;
    long start, now ;
    d = new Date() ;
    start = d.getTime() ;
    do { d = new Date() ; now = d.getTime() ; } while ( (now - start) < milliseconds ) ;
  }
	
}//End