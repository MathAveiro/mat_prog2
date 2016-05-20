import static java.lang.System.*;
import java.util.Scanner;

public class P74
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
      // completar
      return false;
   }

   public static int getFeedback() {
      // completar
      return 0;
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

