import static java.lang.System.*;

public class P2 {
  
 public static void main(String[] args) {

   	if (args.length == 0) return;

   	for (int i = 0; i < args.length; i++) {

         String vazia = new String();

         String numInv = new String();

	   	String nova = substituir (args[i], 0, vazia, numInv);

         out.println(nova);

   	}

   }

   public static String substituir (String analisar, int index, String vazia, String numInv) {

      if (analisar.length() == index) return vazia;
      
      if (!Character.isLetter(analisar.charAt(index))) {

         numInv = analisar.charAt(index) + numInv;

      }

      else {

         vazia += numInv;

         numInv = "";

         vazia += analisar.charAt(index);

      }

      return substituir (analisar, index+1, vazia, numInv);

   }

}