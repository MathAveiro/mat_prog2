import static java.lang.System.*;

public class Factors
{
   public static void main(String[] args)
   {
      for(int i = 0; i < args.length; i++)
         out.println(args[i]+" = "+factors(Integer.parseInt(args[i])));
   }

   public static String factors (int a) {

   		String fin = "";

   		if (a == 0) return fin += a;

   		if (a == 1) return fin += a;

   	  	return factorsR(a, 2, fin); 

   }

   private static String factorsR (int numero, int a, String fin) {

   		if (numero == 1) return fin;

   		if (numero%a==0) {

   			if (numero != a) fin += a + " x ";

   			else return fin += a;

   			return factorsR (numero / a, 2, fin);

   		}

   		else return factorsR (numero, a+1, fin); 


   }

}

