import java.util.*;

public class Exem6 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		double notas [] = new double [12];

		int d=1, i=0, n=0;

		double num;

		for ( i = 0; i < 12 ; i++ ) {

			do {

				System.out.printf("Aluno %d: ",d);
				num = sc.nextDouble();

				d++;

			} while (num < 0 || num > 20);

			notas [i] = num;
			
			n = i;

		}

		for (i = 0 ; i <= n ; i++) {

			System.out.println("Nota introduzidas: ");

			for (i = 0; i <= n ; i++) {
			
				System.out.printf("A%d",i+1);
				System.out.printf("  ");

			}

			System.out.println();

			for (i = 0; i <= n ; i++) {

				System.out.printf(" %.0f",notas[i]);
				System.out.printf("  ");

			}
			
			
			
		}

			double max=0, min=20;

		for (i = 0 ; i <= n ; i++) {
			
			if (notas[i] > max) {

				max = notas[i];

			}

			if(notas[i] < min) {

				min = notas[i];

			}

		}

		System.out.println();

		System.out.printf("Nota máxima: %.2f\n", max);

		System.out.printf("Nota mínima: %.2f\n", min);

	}

}