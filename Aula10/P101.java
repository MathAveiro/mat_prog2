import static java.lang.System.*;
import java.util.Scanner;
import p2utils.*;

public class P101 {
   
   static Scanner sc = new Scanner (System.in);

   public static void main(String[] args) {
              
      String frase = "";

      String frase1 = "";

      for (int i = 0; i < args.length; i++) {
 
         frase += args[i];

         frase1 += args[i];

         if (i != args.length - 1) frase1 += " ";
      
      }
           
      Queue<Character> queue = new Queue<Character> ();

      Stack<Character> stack = new Stack<Character> ();

      for (int i = 0; i < frase.length() ; i++) {

         if (Character.isDigit(frase.charAt(i)) || Character.isLetter(frase.charAt(i))) {

            Character k = Character.toLowerCase(frase.charAt(i));

            queue.in(k);

            stack.push(k);
         
         }

      }
         
      String final1 = null;

      String final2 = null;
      
      int cont = 0;
      
      int size = queue.size();

      do {

         final1 += queue.peek();
         queue.out();
         final2 += stack.top();
         stack.pop();
         cont++;

      } while ( cont < size/2);


      if (final1.equals(final2)) out.printf("Text %s is a polindrome!", frase1);
      else out.printf("Text %s is not a polindrome!", frase1);

   }

}

