import static java.lang.System.*;

public class AllDivisors {

  public static void main(String[] args) {

     out.println(Integer.parseInt(args[0]));

     int b = Integer.parseInt(args[0]);

     factors(b);

	}

   public static void factors (int a) {

   		if (a <= 0) {

   			out.println("ERROR: argument 0 is not a positive number");
   		
   			return;

   		}
   		
   		else if (a == 1) {

   			out.println("1");

   			return;

   		}

   	  	else factorsR(a, a-1, 1); 

   }

   private static void factorsR (int numero, int a, int cont) {

   		if (numero == 1 || a == 0 || a == 1) return;

   		if (numero%a==0) {

   			for (int k = 0; k < cont ; k++ ) {
   			
   				out.printf("    ");	
   			
   			}

   			out.println(a);

   			factorsR (a, a-1, cont+1);

   			factorsR(numero, a-1, cont);

   		}

   		else factorsR (numero, a-1, cont); 


   }

}