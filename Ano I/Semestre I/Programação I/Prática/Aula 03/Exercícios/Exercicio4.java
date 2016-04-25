import java.util.*;

public class Exercicio4
{
	public static void main(String[] args) 
	{
			int secret = (int)(100.0*Math.random()) + 1;
			int valor, qnt=1;

			Scanner sc = new Scanner(System.in);

			System.out.print("Introduza um valor");
			valor = sc.nextInt();

			do 
			{

				System.out.print("Introuza um valor");
				valor = sc.nextInt();

				qnt = qnt + 1;
			}
			while (valor != secret);

			System.out.println("O valor secreto é: "+secret+" e foram feitas "+qnt+" tentativas."); 
	}	
}