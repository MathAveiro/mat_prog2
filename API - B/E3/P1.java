import static java.lang.System.*;
import java.util.Scanner;
import game.BullsAndCowsGame;

public class P1
{
   static final Scanner scin = new Scanner(System.in);

   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         err.println("Usage: java -ea P1 <alphabet> <numSymbolsToGuess>");
         exit(1);
      }
      String alphabet = args[0];

      for(int i=0; i<args[1].length(); i++){
      	char temp = args[1].charAt(i);
      	if(!Character.isDigit(temp)){
			out.println("ERROR: argument "+args[1]+" is not a number!");
			exit(2);
		}
      }	
      int numSymbolsToGuess = Integer.parseInt(args[1]);
      String r="n";
      String[] points = new String[1];
      int n=0;
      do {
	      out.println();
	      out.print("Player name: ");
	      String name = scin.nextLine();
	      while(name.equals("")){
	      	out.println();
	      	out.println("Invalid name!");
	      	out.println();
	      	out.print("Player name: ");
	      	name = scin.nextLine();
	      }
	      BullsAndCowsGame game = new BullsAndCowsGame(alphabet, numSymbolsToGuess, name);
	      while(!game.finished())
	      {
	         out.println();
	         String guess="";
	         do {
	         	out.print("Guess (type \"end\" to terminate): ");
	         	guess = scin.nextLine();
	         	if (guess.equalsIgnoreCase("end"))
	         	{
	            	err.println("Program terminated!");
	            	exit(0);
	         	}
	         	if (guess.length()<numSymbolsToGuess) out.println("ERROR: invalid guess "+guess+"!");
	         	else if (guess.length()>numSymbolsToGuess) out.println("ERROR: invalid guess "+guess+"!");
	         	else {
	         		for (int i=0; i<guess.length(); i++) {
	         			boolean diferente = true;
	         			for(int j=0; j<alphabet.length(); j++) {
	         				if(guess.charAt(i)==alphabet.charAt(j)) diferente = false;
	         			}
	         			if(diferente) {
	         				out.println("ERROR: invalid guess "+guess+"!");
	         				break;
	         			}
	         		}
	         	}
	         } while(guess.length()!=numSymbolsToGuess);
	         game.play(guess);
	      }
	      out.println();
	      out.println("Game solved in "+game.numAttempts()+" moves!");
	      out.print("New game (Y/n)?");
	      r=scin.nextLine();
	      points[n]="	"+(n+1)+": "+name+" - "+game.numAttempts()+" attempts";
	      if(r.equals("Y") || r.equals("y")){
	      	points=novoarray(points);
	      	n++;
	      } 
	  } while(r.equals("Y") || r.equals("y"));
	  for (int i=0; i<points.length; i++) {
	      out.println(points[i]);
	  }
   }
   public static String[] novoarray(String[] points) {
   		String novoarray[] = new String[points.length+1];
   		for(int i=0; i<points.length; i++) {
   			novoarray[i]=points[i];
   		}
   		return novoarray;
   }
}

