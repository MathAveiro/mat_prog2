import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class p73
{
   static Scanner sc = new Scanner(System.in);
   
   public static void main(String[] args)
   {
      int min = 0, max = 0;

      try {
         min = Integer.parseInt(args[0]);
         max = Integer.parseInt(args[1]);
      }
      catch (ArrayIndexOutOfBoundsException e) {
         out.println("ERRO: número de argumentos insuficiente");
         exit(1);
      }
      catch (NumberFormatException e) {
         out.println("ERRO: formato inválido");
         exit(1);
      }

      boolean result = iGuessIt(min,max);    

      if (result) out.println("\nYES! Sou um programa mesmo inteligente ;-)");
      else out.println("\nQue pena :(");
   }
 
   public static boolean iGuessIt(int min, int max) 
   {
        
      int secretNumber;  
        
      do {

          secretNumber = (int)(Math.random()*(100));

      } while (secretNumber < min || secretNumber > max);
       
      out.printf("Será que o número secreto é %d?", secretNumber);
      
      int op = getFeedback();
      
      if (op == 2) {
          
         return iGuessIt (secretNumber + 1, max);
          
      }
      
      else if (op == 3) {
          
          return iGuessIt (min, secretNumber - 1);
          
      }
      
      else if (op == 1) return true;
      
      else return false;
      
   }

   public static int getFeedback() {
      
      int op;
      
      showOptions();
      
      op = sc.nextInt();
      
      switch (op) {
          
          case 0: return 0;
          
          case 1: return 1;
      
          case 2: return 2;
      
          case 3: return 3;
      
          default: {
          
              out.println("Erro: Comentário inválido");
   
              return getFeedback();
              
          }
          
      }
      
   }

   public static void showOptions() {

      out.println("\nQual o seu comentário?");
      out.println("  1 - Sucesso! O programa descobriu o meu número secreto");
      out.println("  2 - Número secreto é mais alto");
      out.println("  3 - Número secreto é mais baixo");
      out.println("  0 - Perdi a paciência e quero terminar o jogo");
      out.print("> ");
      
   }
   
}