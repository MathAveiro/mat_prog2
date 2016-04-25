import static java.lang.System.*;

//
//exercicio em que a funcao cont pairs é usada como recursividade normal e para varias strings
//

public class P2{
	public static void main(String [] args){
		
		if(args.length == 0){
			out.println("Usage: java -ea E7 <string1> ...");
			exit(99);
		}
		
		
		// o ciclo for vai fazer com a que a funcao contPairs seja feita para varias strings
		for(int i=0 ; i<args.length; i++){
			out.printf("\"%s\" contains ", args[i]);
			contPairs(args[i], 0);
			out.println(" pairs of consecutive equal characters");
		}
	}// fim da main
	
	// a funçao conta o numero de pares de carateres seguidos, uma string de cada vez
	public static void contPairs(String a, int valor){
		assert a!=null: "Argumento de entrada inválido!";
		
		int cont = valor; // vai contar o numero de repeticoes de pares
		
		if(a.length()!=1){
			if(a.charAt(0) == a.charAt(1))
				cont++;
				contPairs(a.substring(1), cont);
		}
		out.print(cont);
		
	}
}// fim do programa
