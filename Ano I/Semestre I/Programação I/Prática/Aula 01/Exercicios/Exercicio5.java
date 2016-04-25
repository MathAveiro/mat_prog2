import java.util.Scanner;

public class Exercicio5
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	double x1, y1, x2, y2;
	double dis;
	
	System.out.print("Insira a coordenada x da localidade A: ");
	x1 = sc.nextDouble();
	System.out.print("Insira a coordenada y da localidade A: ");
	y1= sc.nextDouble();
	System.out.print("Insira a coordenada x da localidade B: ");
	x2 = sc.nextDouble();
	System.out.print("Insira a coordenada y da localidade B: ");
	y2 = sc.nextDouble();
	
	dis = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
	
	System.out.printf("A distância entre a localidade A e a localidade B é de: %4.1f\n", dis*100);
	}
}
	
