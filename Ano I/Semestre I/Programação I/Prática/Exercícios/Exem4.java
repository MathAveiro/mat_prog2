import java.util.*;

public class Exem4 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		Pessoa p = informacao ();

		tas (p);

	}

	public static Pessoa informacao () {

		Pessoa p = new Pessoa();

		System.out.println("Introduza o seu nome:");
		p.nome = sc.nextLine();

		do {
			
			System.out.println("Introduza o sexo:");
			p.sexo = sc.next().charAt(0);

		} while (p.sexo != 'M' && p.sexo != 'm' && p.sexo != 'F' && p.sexo != 'f');

		System.out.println("Introudza o seu peso:");
		p.peso = sc.nextDouble();

		System.out.println("Qual a quantidade de bebida ingerida:");
		p.bebida = sc.nextDouble();

		System.out.println("Introduza o teor de alcool da bebida:");
		p.teor = sc.nextDouble();

		do {

		System.out.println("A bebbida foi ingerida em jejum?");
		p.jejum = sc.next().charAt(0);

		} while (p.jejum != 'N' && p.jejum != 'n' && p.jejum != 'S' && p.jejum != 's');		

		return p;

	}

	public static void tas (Pessoa p) {

		if (p.sexo == 'F' || p.sexo == 'f') {

			if (p.jejum == 'S' || p.jejum == 's') {

				double tas = ((p.teor/100) * p.bebida * 0.8)/(p.peso * 0.6);

				System.out.printf("O valor de TAS é: %f", tas);

			}

			else {

				double tas = ((p.teor/100) * p.bebida * 0.8)/(p.peso * 1.1);

				System.out.printf("O valor de TAS é: %f", tas);

			}

		}

		else {

			if (p.jejum == 'S' || p.jejum == 's') {

				double tas = ((p.teor/100) * p.bebida * 0.8)/(p.peso * 0.7);

				System.out.printf("O valor de TAS é: %f", tas);

			}

			else {

				double tas = ((p.teor/100) * p.bebida * 0.8)/(p.peso * 1.1);
				
				System.out.printf("O valor de TAS é: %f", tas);

			}

		}

	}

}

class Pessoa {

	String nome;
	char sexo, jejum;
	double peso, bebida, teor;


}