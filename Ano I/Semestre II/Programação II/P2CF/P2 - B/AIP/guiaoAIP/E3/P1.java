import static java.lang.System.*;
import java.util.Scanner;
import game.BullsAndCowsGame;

public class P1
{
   static final Scanner scin = new Scanner(System.in);

   public static void main(String[] args)
   {
      if (args.length != 2){
         err.println("Usage: java -ea P1 <alphabet> <numSymbolsToGuess>");
         exit(1);
      }
      
      String alphabet = args[0];
      int numSymbolsToGuess = Integer.parseInt(args[1]);

      out.println();
      out.print("Player name: ");
      String name = scin.nextLine();

      BullsAndCowsGame game = new BullsAndCowsGame(alphabet, numSymbolsToGuess, name);
      while(!game.finished())
      {
         out.println();
         out.print("Guess (type \"end\" to terminate): ");
         String guess = scin.nextLine();
         if (guess.equalsIgnoreCase("end"))
         {
            err.println("Program terminated!");
            exit(0);
         }
         game.play(guess);
      }
      out.println();
      out.println("Game solved in "+game.numAttempts()+" moves!");
   }
}

