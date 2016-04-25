import static java.lang.System.*;

public class Factors{
	public static void main (String [] args){
		
		if(args.length == 0){
			out.println("Usage: java -ea E6 <inteiro1> ...");
			exit(1);
		}
		
		int [] w = new int [args.length];
		
		for(int i=0; i<args.length; i++){
			//programaçao defensiva
			try{
				w[i] = Integer.parseInt(args[i]);
			}catch(NumberFormatException e){
				out.printf("Argumento (%s) não é valido!\n", args[i]);
				exit(99);
			}
			
			out.printf("%d = %s\n", w[i], factors(w[i]));
		}
		// não é necessario exit
		exit(100);
		
	}// fim da main
	
	public static String factors (int a){
		assert a>=0: "Número " + a + " inválido!";
		
		String s= "";
		
		if(a<=1)
			s= Integer.toString(a);
		else{
			int i;
			
			for(i = 2; i<a && a%i!=0; i++) {} // for com instruçoes vazias, ou seja, não vai acontecer nada no for
			
			// Integer.toString(umNumero)   --> Converte umNumero numa string que só contem esse numero
			s= Integer.toString(i);  /// o numero i vem do ciclo for
			if(a>i)
				s += " * " + factors(a/i);
			 // s= s + " * " + factors(a/i);
		}
		
		return s;
	}// fim da funçao factors
	
}// fim do programa
