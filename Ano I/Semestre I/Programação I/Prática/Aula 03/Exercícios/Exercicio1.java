import java.util.*;

public class Exercicio1
{
public static void main(String[] args) {
	
	int num;
	int qnt=0;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.printf("Introduza um número positivo ");
	num = sc.nextInt();

      while (num > 0) {
			System.out.printf("Introduza um número positivo ");
			num = sc.nextInt();
			qnt = qnt + 1;
	}

	System.out.printf("Foram introduzidos %d números\n", qnt);

	}
}	
