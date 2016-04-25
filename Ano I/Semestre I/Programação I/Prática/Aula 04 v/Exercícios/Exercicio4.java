import java.util.*;

public class Exercicio4{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);

		int n;
		double soma=0;
		int i;
		int a=1;

		System.out.print("Introduza o valor de N: ");
		n = sc.nextInt();


		for (i=1; i<=n; i++) {
			soma = soma + (1.0/a)*(Math.pow(-1,i+1));
			a = a + 2;
		}

		System.out.printf("A soma é de: %.15f", soma);
	}
}