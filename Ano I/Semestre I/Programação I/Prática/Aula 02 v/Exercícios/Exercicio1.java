import java.util.*;

public class Exercicio1
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	
	double tp1, tp2, api, ep;
	double fin;
	
	System.out.print("Introduza o valor da TP1: ");
	tp1 = sc.nextDouble();
	System.out.print("Introduza o valor da TP2: ");
	tp2 = sc.nextDouble();
	System.out.print("Introduza o valor da API: ");
	api = sc.nextDouble();
	System.out.print("Introduza o valor da EP: ");
	ep = sc.nextDouble();
	
	fin = (tp1*0.1 + tp2*0.1 + api*0.3 + ep*0.5);
	
		if (fin < 9.5)
		{
		System.out.println("O aluno reprovou");
		}
		else
		{
		System.out.println("O aluno foi aprovado com nota: "+fin);
		}
	}
}
