import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio16 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		int random = (int)(Math.random()*(100+1));
		int n, cont=0;

		do {
			out.printf("Introduza um número: ");
			n = sc.nextInt();
			if(n>random){
				out.printf("O número a descobrir é menor do que o número introduzido\n");
				cont++;
			}
			if(n<random){
				out.printf("O número a descobrir é maior do que o número introduzido\n");
				cont++;
			}
			if(n==random){
				out.printf("O número a descobrir é igual do que o número introduzido\n");
				cont++;
			}
		} while (n!=random);

		out.printf("Pontuação: %d", cont);

	}

}