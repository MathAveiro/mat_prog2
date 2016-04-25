import java.util.*;

public class Exercicio3
{
	public static void main(String[] args)
	{
	
	double num, prim, a, b, media, qnt=0, vlr;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Introduza o primeiro valor: ");
	prim = sc.nextDouble();
	
	vlr = prim;
	a = vlr;
	b = vlr;
	
	do
	{
	
		System.out.println("Introduza uma lista de números: ");
		num = sc.nextDouble();
	
		qnt = qnt + 1;
			
		if (num != prim)
		{

			if (num < a)
			{
				a = num;
			}
			if (num > b)
			{
				b = num;
			}
			
			vlr = vlr + num;
		}
	}
	while (num != prim);
	
	media = vlr / qnt;
	
	System.out.println("O número mais elevado é: "+b+", o número mais baixo é: "+a+", a média é de: "+media+" e o número de elementos da lista é de: "+qnt);
	}
}