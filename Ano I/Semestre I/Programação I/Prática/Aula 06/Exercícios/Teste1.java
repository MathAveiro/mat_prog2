import java.util.*;

public class Teste1 {

static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		int max, min, media, numValores=0, op=0;

		int num_array[] = new int[50];

		do {

			op=printMenu();

			switch (op) {

				case 1:

				numValores=readSeq(num_array);

				break;
				
				case 2:
				
				printSeq(num_array,numValores);
				
				break;
				
				case 3:
				
				printMax(num_array);
				
				break;

				case 4:
				
				printMin(num_array);
				
				break;
				
				case 5:
				
				printMed(num_array);
				
				break;
				
				case 6:
				
				printIfEven(num_array);
				
				break;

			}

		} while (op!=10);

		System.out.println("\nO programa vai terminar.");

	}

	public static int printMenu() {

		System.out.println();
		
		System.out.println("1 - Ler a sequência");
		
		System.out.println("2 - Escrever a sequência");
		
		System.out.println("3 - Calcular o máximo da sequência");
		
		System.out.println("4 - Calcular o mínimo da sequência");
		
		System.out.println("5 - Calcular a média da sequência");
		
		System.out.println("6 - Detetar se é uma sequência só constituída por número pares");
		
		System.out.println("10 - Terminar o programa");
		
		System.out.println();
		
		System.out.println("Introduza uma opção");
		
		int op = 0;

		do {
			
			System.out.print("Opção -> ");

			op = sc.nextInt();

			if(!((op>0 && op<7) || op==10)) {

				System.out.println("Opção inválida");

			}

		} while (!((op>0 && op<7) || op==10));

		return op;

	}

	public static int readSeq(int[] num_array) {

		int i=0, seq;
		
		System.out.println();

		do {

			System.out.print("Introduza um número: ");

			seq = sc.nextInt();

			if (seq > 0) {
				
				num_array[i] = seq;
				i++;

			}

		} while (seq!=0 && i<num_array.length);

		return i;
	}

	public static void printSeq (int[] num_array, int n) {

		System.out.println();

		for (int m=0; m<n; m++) {

			System.out.printf("lista[%d] = %d\n", m, num_array[m]);
			
		}

	}

	public static void printMax (int[] num_array) {
		
			char k;

			do {

			System.out.println("		CrashBossFind.java: cannot find boss");
			System.out.println("		boss: MARNOTO CUNHA, quer ser nosso patrão?");
			System.out.println("		location: Licenciatura em Matemática - Universidade de Aveiro");
			System.out.println("        		new Boss ( yes or no? )");

			System.out.print("OPTION: ");
			k = sc.next().charAt(0);

			if (k=='Y' || k=='y' || k=='s' || k=='S') {
				
				System.out.println();
				System.out.println("		CrashBossFind.java: It's now working... ");

				int i=0, referencia=0;

				System.out.println();

				do {

					if (num_array[i]>referencia) {

						referencia = num_array[i];
			
					}

					i++;

				} while (num_array[i]!=0);

				System.out.printf("Máximo: %d\n", referencia);

			}

			else {

				System.out.println();
				System.out.println("		Desculpa, mas essa é uma das respostas erradas. Aiai... Pensa melhor nisso.");
				System.out.println();
				
			}

		} while (k!='Y' && k!='y' && k!='s' && k!='S');

	}

	public static void printMin (int[] num_array) {

		int i=0, referencia=num_array[0];

		System.out.println();

		do {

			if (num_array[i]<referencia) {

				referencia = num_array[i];

			}

			i++;

		} while (num_array[i]!=0);

		System.out.printf("Mínimo: %d\n", referencia);

	}

	public static void printMed (int[] num_array) {

		int n=0, soma=0;

		System.out.println();

		do {

			if (num_array[n]>0) {

				soma += num_array[n];

				n++;

			}

		} while (num_array[n]!=0);

		soma/=n;

		System.out.printf("A média é de: %d\n", soma);

	}

	public static void printIfEven (int[] num_array) {

		int i=0;

		boolean ok = true;

		System.out.println();

		do {

		if (num_array[i]%2!=0) {

			ok = false;

		}

		i++;

		} while (num_array[i]!=0);

		if (ok) {

			System.out.println("A função só é constituída por números pares.");

		}

		else {
			
			System.out.println("A função não é constituída apenas por números pares.");

		}

	}

}