import java.util.*;

public class Exercicio2{

	public static void main(String[] args) {
	
	Scanner sc = new Scanner (System.in);

	
	int n;
	int i;

	do{

	System.out.print("Introduza um valor entre 0 e 100: ");
	n = sc.nextInt();

	} while(n<0 || n>100);

	for (i=1 ; i<=10 ; i++)
	{
		System.out.printf("%2d * %2d = %3d\n", i, n, i*n);
	}

	}
}