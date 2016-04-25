import java.util.*;

public class Exercicio5
{
	public static void main (String[] args)
	{
	Scanner sc = new Scanner(System.in);
	
	int x1, x2, x3, x4, y1, y2, y3, y4;
	
	System.out.print("Introduza as coordenadas dos pontos P1, P2, P3, P4, por ordem, seguindo o sentido horário: ");
	x1 = sc.nextInt();
	y1 = sc.nextInt();
	x2 = sc.nextInt();
	y2 = sc.nextInt();
	x3 = sc.nextInt();
	y3 = sc.nextInt();
	x4 = sc.nextInt();
	y4 = sc.nextInt();
	
		if (y1==y2 && y3==y4 && x1==x4 && x2==x3)
		{
		System.out.println("A figura forma um quadrado");
		}
		else
		{
		System.out.println("A figura não forma um quadrado");
		}
	}
}
