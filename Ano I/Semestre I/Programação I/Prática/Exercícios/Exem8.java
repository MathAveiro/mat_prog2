import java.util.*;

public class Exem8 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		int sequencia [] = new int [49];

		int opcao = funcaomenu();

		switch (opcao) {

			case 1:

				funcaoler(sequencia);

				break;

			case 2: 

				funcaoimprimir(sequencia);

				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 6:

				break;

			case 10:

				break;

		}
		



	}

	public static int funcaomenu () {

		int opcao;

		System.out.println();

		System.out.println("1 - Ler a sequência");

		System.out.println("2 - Imprimir a sequência");

		System.out.println("3 - Máximo da sequência");

		System.out.println("4 - Mínimo da sequência");

		System.out.println("5 - Média da sequência");

		System.out.println("6 - Detetar se é uma sequência só constituída por números pares");

		System.out.println("10 - Terminar o programa");

		do {

			System.out.print("Opção -> ");

			opcao = sc.nextInt();

			if (opcao < 0 && opcao > 6 && opcao != 10) System.out.println("Opção inválida");

		} while (opcao < 0 && opcao > 6 && opcao != 10);

		return opcao;

	}

	public static int funcaoler (int sequencia []) {

		int i = 0;

		int seq;

		do {

			System.out.print("Introduza um número: ");

		 	seq = sc.nextInt();

			if (sequencia[i] != 0) {

				sequencia[i] = seq;

				i++;

			}

		}	while (i < sequencia.length && seq != 0);

		return i;

	}

	public static int funcaoimprimir (int sequencia []) {

		for (i = 0;i<;i++) {
			
		}

	}



}