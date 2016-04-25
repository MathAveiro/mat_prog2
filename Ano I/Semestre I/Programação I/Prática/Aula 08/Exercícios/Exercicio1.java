import java.util.*;

public class Exercicio1 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int i, maiuscula=0, minuscula=0, numerico=0, vogal=0, consoante=0;

		String frase = new String();

		System.out.print("Introduza uma frase: ");
		frase = sc.nextLine();

		for (i = 0;i < frase.length();i++) {
			
			 Character letra = frase.charAt(i);

			 if (Character.isUpperCase(letra)) maiuscula++;

			 if (Character.isLowerCase(letra)) minuscula++;

			 if (Character.isDigit(letra)) numerico++;

			 if (isVowel(letra)) vogal++;

			 consoante = (minuscula + maiuscula) - vogal;


		}

		System.out.println("Número de caracteres minusculos: " + minuscula);

		System.out.println("Número de caracteres maiusculos: " + maiuscula);

		System.out.println("Número de caracteres numéricos: " + numerico);

		System.out.println("Número de vogais: " + vogal);

		System.out.println("Número de consoantes: " + consoante);

	}

	public static boolean isVowel(char c) {

		if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') return true;   
    	
    	else return false;

    }

}