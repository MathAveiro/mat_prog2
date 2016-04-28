import static java.lang.System.*;

public class alterarString {
   public static void main(String[] args) {

   	if (args.length == 0) return;

   	for (int i = 0; i < args.length; i++) {

         String vazia = "";

	   	String fin = substituir (args[i], 0, vazia);

         out.println(fin);

   	}

   }

   public static String substituir (String analisar, int index, String vazia) {

      if (index + 1 > analisar.length()) return vazia;

      else if (analisar.charAt(index) == 'l') vazia += 'u';

      else if (analisar.charAt(index) == 'L') vazia += 'U';

      else if (analisar.charAt(index) == 'r' || analisar.charAt(index) == 'R') vazia += "";

      else vazia += analisar.charAt(index);

      return substituir (analisar, index+1, vazia);

   }

}