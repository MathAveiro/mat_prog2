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
      out.print("Number of players: ");
      int n=input.nextInt();
      int j=0;
      String[] jogador = new String[n];
      input.nextLine();
      do {
         out.print("Name: ");
         jogador[j]=input.nextLine();
         j++;
      } while(j<n);
      Board game[] = new Board[n];
      j=0;
      do {
         game[j] = new Board(jogador[j], numLines, numColumns);
         j++;
      } while(j<n);
      j=0;
      int count = 0;
      do {
         game[j].print();
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
         if(game[j].tryUncover(word, pos2))
         {
            out.println("Success!");
            if (game[j].finished())
            {
               out.println();
               out.println("================ Player's "+jogador[j]+" game completed! ================");
               out.println();
               count++;
            }
         }
         else
            out.println("Wrong!");
         j++;
         if(game[j].finished()) j++;
         if(j==n) j=0;
      } while(count<n);
      /*while (!game.finished())
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
      }*/
      out.println();
      out.println("That's all folks!");
   }
}

