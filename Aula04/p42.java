import java.util.*;
import static java.lang.System.*;
public class p42 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int option;
		int number;
		int min=0;
		int max=20;
		do {
			option = menu();
			switch(option) {
				case 1: 
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					exit(1);
					break;
				default:
					out.println("Invalid command!");
					break;
			}
		} while (option!=0);
	}
	public static int menu() {
		GuessGame game = new GuessGame();
		out.println();
		out.println("Avaliable commands:");
		out.println("  <number>   (new attempt to guess number in set [0,20])");
		out.println("  count      (show current number of attempts)");
		out.println("  help       (information on command usage)");
		out.println("  quit       (exits the program)");
		out.println();
		out.print("command: ");
		String temp=sc.nextLine();
		if(Character.isDigit(temp.charAt(0))) {
			int number = Integer.parseInt(temp);
			game.play(number);
			out.println();
			if(game.attemptIsLower()) {
				out.println("The secret number is higher than "+number);
			}
			else if(game.attemptIsHigher()) {
				out.println("The secret number is lower than "+number);
			}
			else if(game.finished()) {
				out.println("Game finished in "+game.numAttempts()+" attempts");
				return 4;
			}
			return 1;
		}
		else if(temp.equals("count")) {
			out.println();
			out.println(game.numAttempts());
			return 2;
		}
		else if(temp.equals("help")) {
			return 3;
		}
		else if(temp.equals("quit")) {
			return 4;
		}
		else return 0;
	}
}