import java.util.Scanner;

public class Exercicio8
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	
	double despesa1;
	double despesa2, despesa3, despesa4, despesafinal;
	
	System.out.print("Introduza a despesa do primeio dia: ");
	despesa1 = sc.nextDouble();
	
	despesa2 = (despesa1 + 0.2*despesa1);
	despesa3 = (despesa2 + 0.2*despesa2);
	despesa4 = (despesa3 + 0.2*despesa3);
	despesafinal = ((despesa1 + despesa2 + despesa3 + despesa4)/4);
	
	System.out.println("O valor da despesa méda diária é de: "+ despesafinal);
	}
}
