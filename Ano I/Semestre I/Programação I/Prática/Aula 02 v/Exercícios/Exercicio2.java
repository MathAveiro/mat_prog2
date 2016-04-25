import java.util.*;

public class Exercicio2
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	
	int real1, real2;
	int maior;
	
	System.out.print("Introduza o valor do primeiro número real: ");
	real1 = sc.nextInt();
	
	System.out.print("Introduza o valor do segundo número real: ");
	real2 = sc.nextInt();
	
	maior = real1 - real2;

		if (maior != 0)
		{
			if (maior < 0)
			{
			System.out.println("O valor " + real2 + " é o maior");
			}
			else
			{
			System.out.println("O valor " + real1 + " é o maior");
			}
		}
		else
		{
		System.out.println("Ambos os valores são iguais");
		}
	}
}
