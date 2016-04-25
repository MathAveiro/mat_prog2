import static java.lang.System.*;

//
//exerício que em que a funcao contpairs é usada como backtraking para varias strings
//

public class p2_{
	public static void main(String []args){
		
		if(args.length == 0){
			out.println("Usage: java -ea E7 <string1> ...");
			exit(99);
		}
		
		for(int i=0; i<args.length ; i++){
			int numeroDEpares = contpairs(args[i]);
			out.printf("\"%s\" contains %d pairs of consecutive equal characters\n", args[i], numeroDEpares);
		}
		
		}//fim da main
		
	// a funçao conta o numero de pares de carateres seguidos, uma string de cada vez
	public static int contpairs(String Daniela){
		assert Daniela != null:"Arg invalid !";
		//assert Daniela.length()!=0;
		
		int bob=0;//conta o numero de vezes que o par de carateres sao iguais!!!!!!!!!!!!
		
		if(Daniela.length()==1)
			return bob;
		else{
			if(Daniela.charAt(0)==Daniela.charAt(1))
				bob= 1 + contpairs(Daniela.substring(1));
		}
		
		return bob;
		}
		
}// fim do programa
		
