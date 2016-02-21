import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio13 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		out.printf("Introduza um número: ");
		int numero = sc.nextInt();

		boolean primo = true;

		if(numero==1) primo = false;

		else {

			for (int i=2; i<=i/numero; i++) {
				
				if(numero%i==0) primo = false;

			}

		}

		if(primo) out.printf("O número é primo");
		else out.printf("O número não é primo");

	}

}