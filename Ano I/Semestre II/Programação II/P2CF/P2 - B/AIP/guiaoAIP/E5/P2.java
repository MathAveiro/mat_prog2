import static java.lang.System.*;

public class P2{
	
	public static void main(String [] args){
		
		if(args.length == 0){
			err.println("Uso: java -ea P2 <string1> ...");
			exit(99);
		}
		
		for(int i=0; i<args.length; i++)
			out.printf("%s -> %s\n", args[i], invertDigits(args[i], ""));
		
		//nao é preciso exit
		exit(0);
		
	}// fim da main
	
	public static String invertDigits(String a, String num){
		assert a != null: "Argumento introduzido é inválido!";
	  //assert a.length() != 0;
		assert num != null;
		
		String s = num;
		
		if(a.length()>0){
			//se o primeiro caracter da string nao for um numero...
			if(!Character.isDigit(a.charAt(0)))
				s += Character.toString(a.charAt(0)) + invertDigits(a.substring(1), "");
				// A String auxiliar s é igual ao primeiro caracter da String a mais os carateres ordenados da funcao recursiva
				
				
				//e quando aparecerem numeros... sao invertidos em baixo e adicionados mais tarde no if que está acima
			else
				s = invertDigits(a.substring(1), Character.toString(a.charAt(0)) + num);
				//só devolve a string (já invertida) dos numeros
		}
		
		return s;
	}// fim da funcao invertDigits
	
} // fim do programa
