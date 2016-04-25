import java.util.*;

public class Exercicio3
{
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner (System.in);

	int m;
	int i;
	int fact=1;

	do{

	System.out.print("Introduza um valor válido entre 1 e 10: ");
	i = sc.nextInt();
	} while(i<0 || i>10);


	for(m=1; m<=i; m++)
		{
			fact = fact * m;
			System.out.printf("%2d! = %4d\n", m, fact);
		}
	}
}