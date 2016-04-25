import java.util.*;

public class Exercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);

		int nnotas, nota, i=0;

		System.out.print("Introduza a quantidade de notas a introduzir: ");
		nnotas = sc.nextInt();

		int notas [] = new int[nnotas];

		int hist [] = new int[22];

		do {

			System.out.print("Introduza um valor entre 0 e 20: ");
			nota = sc.nextInt();

			if (nota >=0 && nota <= 20){

				notas[i] = nota;

				i++;

			}
		
			else {

				System.out.print("Valor inválido!");

			}


		} while (i<nnotas);

		i=0;

		do {

			hist[notas[i]]++;

			i++;

		} while (i<nnotas);			

		System.out.println();
		System.out.println("Histórico de notas:");
		System.out.println("---------------------------------------------");

		i=20;

		do {

			System.out.printf("%2d | ", i);
			
			nnotas=0;

			do {

				if (nnotas<hist[i]) {

					System.out.print("*");

					nnotas++;

				}

			} while (nnotas<hist[i]);

		System.out.println();

		i--;

		} while (i>=0);
		
	}

}