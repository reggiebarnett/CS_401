import java.util.Scanner;



public class nQueensexample{

public static void main(String args[]){
	int doAgain = 1;
	while(doAgain == 1){

	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the number of queens you want to use:");
	int N = scan.nextInt();
	
	nQueens nQueensObject = new nQueens(N);
	nQueensObject.queens();
	
	System.out.println("Enter 1 to run program again.");
	doAgain = scan.nextInt();
	}
}


}