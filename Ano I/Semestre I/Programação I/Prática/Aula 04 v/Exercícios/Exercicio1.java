import java.util.*;

public class Exercicio1
{
	public static void main(String[] args) {
		
		int x=0;
		int n;

		Scanner sc = new Scanner (System.in);

		System.out.print("Número de vezes que deseja que a mensagem seja repetida: ");
		n = sc.nextInt();

		do {

			System.out.println("P1 é fixe!");
			x++;

		} while (x<n);
	}
}