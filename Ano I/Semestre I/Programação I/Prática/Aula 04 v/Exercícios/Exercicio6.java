import java.util.*;

public class Exercicio6
{
	
	public static void main (String []args)
	{

		Scanner sc = new Scanner (System.in);

		int h, l, n, m;

		System.out.print("Introduza a altura do rectângulo: ");
		h = sc.nextInt();

		System.out.print("Introduza a largura do rectângulo: ");
		l = sc.nextInt();

		for(n=1;n<=h;n++)
		{

			for(m=1;m<=l;m++)
			{

			System.out.print("*");

			}

		System.out.println("");

		}

	}

}