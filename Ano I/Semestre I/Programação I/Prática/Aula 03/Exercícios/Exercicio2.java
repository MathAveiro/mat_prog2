import java.util.*;

public class Exercicio2
{
	public static void main(String[] args)
	{
	
	int num;
	int qnt=0, prod=1;
	
	Scanner sc = new Scanner(System.in);
	
	do
	{
	qnt = qnt + 1;
	System.out.println("Introduza uma lista de números (terminada com 0): ");
	num = sc.nextInt();
		if (num != 0)
		{
			prod = prod * num;
		 }
	}
	while (num != 0);
	
	System.out.printf("O produto dos números introduzidos é de: %d",prod);
	}
}
