import java.util.Scanner;

public class Exercicio7
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	double TP1, TP2, API, EP;
	double fin;
	
	System.out.print("Insira o valor do TP1: ");
	TP1 = sc.nextDouble();
	System.out.print("Insira o valor do TP2: ");
	TP2 = sc.nextDouble();
	System.out.print("Insira o valor do API: ");
	API = sc.nextDouble();
	System.out.print("Insira o valor do EP: ");
	EP = sc.nextDouble();
	
	fin = (TP1*0.15 + TP2*0.15 + API*0.3 + EP*0.4);
	
	System.out.printf("O valor final é de: %4.1f\n", fin);
	}
}
