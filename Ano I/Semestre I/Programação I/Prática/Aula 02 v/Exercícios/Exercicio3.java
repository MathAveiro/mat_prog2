import java.util.*;

public class Exercicio3
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	
	double idade;
	
	System.out.print("Introduza a idade: ");
	idade = sc.nextDouble();
	
		if (idade <= 6)
		{
		System.out.println("Isento de pagamento");
		}
		else if (idade > 6 && idade <= 12)
			{
			System.out.println("Bilhete de criança");
			}
			else if (idade >= 13 && idade <= 65)
				{
				System.out.println("Bilhete normal");
				}
				else
				{
				System.out.println("Bilhete de 3ª idade");
				}
	}
}
