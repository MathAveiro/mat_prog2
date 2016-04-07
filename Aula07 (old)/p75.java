import static java.lang.System.*;

public class p75
{
   public static void main(String[] args)
   {
      double number = 0.0, epsilon=0.0, init=1.0;

      try {
         number = Double.parseDouble(args[0]);
         epsilon = Double.parseDouble(args[1]);
         init = Double.parseDouble(args[2]);
      }
      catch (ArrayIndexOutOfBoundsException e) {
         out.println("ERRO: número de argumentos insuficiente");
         out.println("Uso: java -ea p75 <number> <epsilon> <init>");
         exit(1);
      }
      catch (NumberFormatException e) {
         out.println("ERRO: formato inválido");
         out.println("Uso: java -ea p75 <number> <epsilon> <init>");
         exit(1);
      }

      double root = squareRoot(number,epsilon,init);

      out.println("Raiz quadrada de "+number+": "+root);

   }

   static double squareRoot(double number, double epsilon, double initRoot)
   {

      assert initRoot >= 0;
  
      double ri = 0;
        
       //if ()    
    
    
   }

} 


