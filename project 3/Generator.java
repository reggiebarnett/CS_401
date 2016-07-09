/////////////////////////////
//Created by Reggie Barnett//
//rdb26@pitt.edu           //
/////////////////////////////
import java.util.*;

public class Generator{
	public static void main(String[] args){
		for(int i=0;i<10;i++){
		String S = SentenceGen();
		System.out.println(S);
		}
	}//End Main
	
	public static String SentenceGen(){
		////////////////
		//S -> NAME VP
		//VP -> V NP
		//NP -> ART NN
		//NN -> ADJ NN,N
		////////////////
		String S = "";
		String[] NAME = {"reggie","john","brandon","harry","drew"};
		String[] V = {"is","looks like"};
		String[] ART = {"a","the"};
		String[] ADJ = {"smart","stupid","normal","strange","terrible","awesome","weird"};
		String[] N = {"student","person"};
		int[] NN = {0,1};
		
		Random rand = new Random(); 
		int a = rand.nextInt(NAME.length); //Random Name Choice
		S = NAME[a];
		
		int b = rand.nextInt(V.length); //Random Verb Choice
		S = S+" "+V[b];
		
		int c = rand.nextInt(ART.length); //Random Article Choice
		S = S+" "+ART[c];
		
		int d = rand.nextInt(NN.length); //Decides whether or not sentence will have adjectives
		while(d == 0){ //While loop adds adjectives
			int e = rand.nextInt(ADJ.length);
			S = S+" "+ADJ[e];
			d = rand.nextInt(NN.length);
		}
		
		int f = rand.nextInt(N.length); //Random Noun Choice
		S = S+" "+N[f];
		
	return S;
	} //End Sentence Gen
	
	
}//End