import java.util.*;

public class Exercicio2 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
	
	int i, maiuscula=0, minuscula=0, numerico=0, vogal=0, consoante=0;

		String frase = new String();

		do {

			System.out.print("Introduza uma frase: ");
			frase = sc.nextLine();

			for (i = 0;i < frase.length();i++) {
			
				Character letra = frase.charAt(i);

			if (Character.isUpperCase(letra)) System.out.print(Character.toUpperCase(letra));

			}

			System.out.println();

		} while (frase.length() != 0);

		
	}

}

