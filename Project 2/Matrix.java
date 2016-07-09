import java.util.*;

public class Matrix{

	public static void main(String[] args){
		int height = 4, width = 2;
		int[][] matrix = createMatrix(height,width);
		printMatrix(matrix);
		System.out.println();
		printMatrix(flip(matrix));
		printPrimes(100);
		
	}
	public static int[][] createMatrix(int height,int width){
		Random rand = new Random(new Date().getTime());
		
		int[][] matrix = new int[height][width];
		
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
			matrix[i][j] = rand.nextInt(11);
			}
		}
		return matrix;
	}
	public static void printMatrix(int[][] M){
		int height = M.length, width = M[0].length;
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
			System.out.print(M[i][j]+" ");
			}System.out.println();
		}
	}
	public static int[][] flip(int[][] M){
		int fheight = M[0].length, fwidth = M.length;
		
		int[][] fmatrix = new int[fheight][fwidth];
			for(int i=0;i<fheight;i++){
				for(int j=0;j<fwidth;j++){
				fmatrix[i][j] = M[j][i];
			}
		}
		return fmatrix;
	}
	
	public static void printPrimes(int n){
		boolean[] candidate = new boolean[n];
		candidate[0] = false; 
		candidate[1] = false;
		for(int i=2; i < n; i++){
		candidate[i] = true;
		}
		int prime = 2;
		boolean done = false;
		while(!done){
			for(int i = 2*prime;i<n;i += prime){
				candidate[i] = false;
			}
			int scan = prime + 1;
			while( scan < n && !candidate[scan]){
				scan++;
			}
		
			if(scan < n){
				prime = scan;
			}
			else{
				done = true;
			}
		}
		for (int i = 0; i < n; i++) {
			if (candidate[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}


}//end