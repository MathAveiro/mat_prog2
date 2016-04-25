import java.util.*;

public class Exercicio4
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	
	int a, m;
	
	System.out.print("Introduza o ano: ");
	a = sc.nextInt();
	System.out.print("Introduza o mês: ");
	m = sc.nextInt();
	
		if (m==2)
		{
			if (a%100==0)
			{
				if (a%400==0)
				{
					System.out.println("O mês 2 do ano " + a + " tem 29 dias");
				}
				else
				{
					System.out.println("O mês 2 do ano " + a + " tem 28 dias");
				}
			}
			else
			{
				if (a%4==0)
				{
					System.out.println("O mês 2 do ano " + a + " tem 29 dias");
				}
				else
				{
					System.out.println("O mês 2 do ano " + a + " tem 28 dias");
				}
			}
		}
		else
		{
			if (m==4 || m==6 || m==9 || m==11)
			{
			System.out.println("O mês " + m + " do ano " + a + " tem 30 dias");
			}
			else
			{
			System.out.println("O mês " + m + " do ano " + a + " tem 31 dias");
			}
		}
	}
}
		
