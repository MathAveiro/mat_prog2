import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class P104 {

   Scanner sc = new Scanner (System.in);

   public static void main(String[] args) throws IOException {

      Stack<Double> stack = new Stack<Double>();
      
      String frase = "";

      for (int i = 0; i < args.length; i++) {

         frase += args[i];

      }

      String stacks = "";
      
      for (int i = 0 ; i < frase.length() ; i++) {

         if (Character.isDigit(frase.charAt(i))) {

            String string = Character.toString(frase.charAt(i));

            stack.push(Double.parseDouble(string)); 

            stacks += " " + stack.top();

            out.println("Stack: " + stacks);

//            out.println(stack.top());

         } 
      }

      for (int i = 0; i < frase.length(); i++) {
       
         if (frase.charAt(i) == '*' || frase.charAt(i) == '+' || frase.charAt(i) == '-' || frase.charAt(i) == '/') {
         
            if((frase.charAt(i)) == '*') {

               Double parcial1 = stack.top();

               stack.pop();

               Double parcial2 = stack.top();

               stack.pop();

               Double total = parcial1 * parcial2;

               stack.push(total);

            }

            else if((frase.charAt(i)) == '+') {

               Double parcial1 = stack.top();

               stack.pop();
               
               Double parcial2 = stack.top();

               stack.pop();

               Double total = parcial1 + parcial2;

               stack.push(total);

            }

            else if((frase.charAt(i)) == '-') {

               Double parcial1 = stack.top();

               stack.pop();
               
               Double parcial2 = stack.top();

               stack.pop();

               Double total = parcial1 - parcial2;

               stack.push(total);

            }

            else if((frase.charAt(i)) == '/') {

               Double parcial1 = stack.top();

               stack.pop();
               
               Double parcial2 = stack.top();

               stack.pop();

               Double total = parcial1 / parcial2;

               stack.push(total);

            }

         }

      }

      out.println("Stack:  " + stack.top());

   }

}
