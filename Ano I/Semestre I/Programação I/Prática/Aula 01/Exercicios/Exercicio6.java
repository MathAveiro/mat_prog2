import java.util.Scanner;

public class Exercicio6
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	double cata, catb;
	double hip, ang;
	
	System.out.print("Insira a medida do cateto a: ");
	cata = sc.nextDouble();
	System.out.print("Insira a medida do cateto b: ");
	catb = sc.nextDouble();
	
	hip = Math.sqrt(Math.pow(cata,2) + Math.pow(catb,2));
	ang = Math.toDegrees(Math.cos((cata / hip)));
	
	System.out.printf("O valor da hipotenusa é de %4.0f e o ângulo formado entre o cateto a e a hipotenusa é de %4.1fº\n", hip, ang);
	}
}
