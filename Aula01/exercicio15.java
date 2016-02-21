import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio15 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		int n, soma=0, cont=0;
		double media;

		do {
			out.printf("Introduza uma lista de inteiros: ");
			n = sc.nextInt();
			soma += n;
			if(n!=0)cont++;
		} while (n!=0);

		if(soma!=0) {
			media = soma/cont;
			out.printf("Soma: %d\tMédia: %.2f", soma, media);
		}
		else out.printf("Soma: %d", soma);
	}

}