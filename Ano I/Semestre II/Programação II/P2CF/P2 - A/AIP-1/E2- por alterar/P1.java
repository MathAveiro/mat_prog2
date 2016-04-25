import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
import game.*;

public class P1
{
   private static final Scanner input = new Scanner(in);

   public static void main(String[] args)
   {
      if (args.length != 0 && args.length != 2)
      {
         err.println("Uso: java -ea P1 [<NUM_LINES> <NUM_COLUMNS>]");
         exit(1);
      }
      int numLines = 3;
      int numColumns = 3;
      if (args.length == 2)
      {
         numLines = Integer.parseInt(args[0]);
         numColumns = Integer.parseInt(args[1]);
      }

      String player = "Smith";
      Board game = new Board(player, numLines, numColumns);
      while (!game.finished())
      {
         game.print();
         out.println();
         out.println("Commands:");
         out.println("   position1 position2 -> attempt to uncover a pair in two positions (ex: A1 A2)");
         out.println("   stop    -> stops game");
         out.println();
         out.print("Command: ");
         String word = input.next();
         if (word.equals("stop"))
         {
            err.println("Game stopped!");
            exit(2);
         }
         String pos2 = input.next();
         if(game.tryUncover(word, pos2))
         {
            out.println("Success!");
            if (game.finished())
            {
               out.println();
               out.println("================ Player's "+player+" game completed! ================");
               out.println();
            }
         }
         else
            out.println("Wrong!");
      }
      out.println();
      out.println("That's all folks!");
   }
}

