import java.util.*;

public class Exercicio1
{

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);

		int n, i, num;

		int numeros[] = new int[100];

		System.out.print("Quantidade de números a serem introduzidos: ");
		n = sc.nextInt();

		for ( i = 0 ; i <= n-1 ; i++ ) 
		{
		
			System.out.print("Introduza um número: ");
			num = sc.nextInt();

			numeros[i] = num;

		}

		for ( i=n-1 ; i>=0 ; i-- ) 
		{

			System.out.print(numeros[i] + "  ");

		}

	}

}