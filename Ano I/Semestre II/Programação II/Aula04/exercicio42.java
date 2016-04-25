import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio42 {

	static Scanner sc = new Scanner (System.in);

	public static void main (String[] args) {
		
	GuessGame42 nAdivinha;

		if (args.length != 0) {

			String sarg1 = args [0];
			String sarg2 = args [1];
	
			int arg1 = parseInt(sarg1);
			int arg2 = parseInt(sarg2);

			nAdivinha = new GuessGame42(arg1, arg2);
		
		} else nAdivinha = new GuessGame42();

		do {

			out.printf("Command: ");
			int op = sc.nextInt();
		
			nAdivinha.play(op);

			if (nAdivinha.finished()) { 

				out.printf("O número introduzido é o correto: %d\n", op);

				break;

			}

			if (nAdivinha.attemptIsLower()) {
			
				out.printf("O número introduzido é menor do que o número secreto\n");
			
				out.println("tentativas: " + nAdivinha.numAttempts());

			} else if (nAdivinha.attemptIsHigher()) {

				out.printf("O número introduzido é maior do que o número secreto\n");

				out.println("tentativas: " + nAdivinha.numAttempts());

			}

			else exit(0);

		} while (!nAdivinha.finished());

		out.printf("Número de tentativas: %d\n", nAdivinha.numAttempts());

	}

}