import static java.lang.System.*;
import java.util.*;

public class Recorrencia{

	static Scanner zz = new Scanner(System.in);

	public static void main(String [] args){
		
		out.print("Introduza a ordem do termo que pretende saber: ");
		
		int  num = zz.nextInt();
		
		// metodo recursivo
		out.println("Metodo Recursivo. Função = " + rec(num));
		//metodo iterativo
		out.println("Metodo Iterativo. Funçao = "+ it(num));
		
		exit(0);
	}
	
	//implementação recursiva
	public static int rec(int n){
		assert n>=0;
		
		int result = 0;
		
		if(n<=1)
			result = n+1;
		else
			result = rec(n-1)*rec(n-2);
		return result;
	}
	
	//implementação iterativa
	public static int it(int n){
		assert n>=0;
		
		int result = 0;
		int it [] = {1,2};
		
		if(n<=1)
			result = it[n];
		else{
			for(int k = 2; k<=n; k++){
				result = it[0]*it[1];
				it[0]=it[1];
				it[1]=result;
			}
		}
		return result;
	}	
}
