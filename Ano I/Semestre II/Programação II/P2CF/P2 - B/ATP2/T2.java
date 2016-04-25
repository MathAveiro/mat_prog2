import java.util.*;

public class T2{

	public static void main (String [] args){
	
		double result = 0;
		int cont =0;
		
		Scanner sc = new Scanner (System.in);
		
		while(sc.hasNext()){
			
			try{
				result += sc.nextDouble();
				cont++;
			}catch(InputMismatchException e){
				String palavra = sc.next();
				System.err.println("Entrada " + palavra + " ignorada (não é um número)!");
				break;
			}
		}
		
		System.out.println("Media = " + result/cont);
	}
}
