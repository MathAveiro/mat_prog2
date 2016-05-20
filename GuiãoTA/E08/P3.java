import static java.lang.System.*;

public class P3 {

   public static void main(String[] args) {

   	if (args.length < 2 || args.length%2 != 0) exit(0);

	   	String [] palavra = new String [args.length];

	   	for (int i = 0; i < args.length; i++) {
	   		
	   		palavra [i] = args[i];

	   	}

	   	for (int i = 0; i < args.length; i+=2) {

		   	if (verificar(palavra[i], palavra[i+1], 0)) out.println ("\"" + palavra[i] + "\" is prefixed by \"" + palavra[i+1] + "\" -> true");
		   	else out.println ("\"" + palavra[i] + "\" is prefixed by \"" + palavra[i+1] + "\" -> false");

	   	}

   }

   public static boolean verificar (String palavra1, String palavra2, int index) {

   		if (palavra2.length() > palavra1.length() || palavra1.length() == 0) return false;

   		if (palavra2.length() == 0) return true;

		if (palavra2.charAt(index) == palavra1.charAt(index)) {

			if (index+1 == palavra2.length()) return true;

			else return verificar (palavra1, palavra2, index+1);   		

		}

		else return false;

   }

}

