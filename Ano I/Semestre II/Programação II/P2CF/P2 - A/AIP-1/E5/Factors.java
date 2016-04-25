import static java.lang.System.*;
import static java.lang.String.*;

public class Factors
{
   public static void main(String[] args)
   {
      for(int i = 0; i < args.length; i++)
         out.println(args[i]+" = "+factors(Integer.parseInt(args[i])));
   }
   
   public static String factors(int num)
   {
     String result="";
     
     if(numPrimo(num)==true)
     {
       result=valueOf(num); // result assume o valor do inteiro num       
       return result;
     }
     else
     {
       for(int i=2; i<=num/2; i++)
       {
         if(numPrimo(i)&&(num%i)==0)
         {
           result=i+" * "+factors(num/i);
           return result;
         }
       }
     }
     
     return result;
   }
   
   public static boolean numPrimo(int n)
   {
     for(int i=2; i<n; i++)
     {
       if(n % i==0)
         return false;
     }
     return true;
   }
}

