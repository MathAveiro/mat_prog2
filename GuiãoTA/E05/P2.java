import static java.lang.System.*;

public class P2
{
   public static void main(String[] args) {

   	if (args.length == 0) return;

   	for (int i = 0; i < args.length; i++) {

	   	int a = consecutive (args[i], 0, 0);

	   	out.println(args[i] + " contains " + a + " pairs of consecutive equal charactres");
   		
   	}

   }

   public static int consecutive (String analisar, int index, int cont) {

 		if (index+1 >= analisar.length()) return cont;

   		if (analisar.charAt(index) == analisar.charAt(index+1)) {

   			cont+=1;
   			
   			return consecutive (analisar, index+1, cont);

   		} else return consecutive (analisar, index+1, cont);

   }
}

