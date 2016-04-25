import java.util.*;

public class Exem3 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		Complexo n = new Complexo();

		Complexo m = new Complexo();

		char opr;

		do {

			System.out.print("Operação: ");
			opr = sc.next(".").charAt(0);

			if (opr == '+') {

				n = LerNUm();

				m = LerNUm();

				Soma(n, m); 

			}
			
			if (opr == '-') {

				n = LerNUm();

				m = LerNUm();

				Subtracao(n, m); 

			}

			if (opr == '*') {

				n = LerNUm();

				m = LerNUm();

				Multi(n, m); 

			}

			if (opr == '/') {

				n = LerNUm();

				m = LerNUm();

				Divisao(n, m); 

			}

			if (opr != '+' && opr != '-' && opr != '*' && opr != '/' && opr != '=') System.out.println("Operação não permitida!");

			if (opr == '=') System.out.printf("O programa vai terminar...");

		} while (opr != '=');

	}


	public static Complexo LerNUm () {

		Complexo p = new Complexo();

		System.out.println("Introduza um número complexo:");

		System.out.print("Parte real: ");
		p.r = sc.nextDouble();

		System.out.print("Parte imaginária: ");
		p.i = sc.nextDouble();

		return p;

	}

	public static void ImprNum (Complexo p) {

		if (p.i >= 0) System.out.printf("(%.1f + %.1fi)", p.r, p.i);

		else System.out.printf("(%.1f %.1fi)", p.r, p.i);

	}

	public static void Soma (Complexo p1, Complexo p2) {

		Complexo fim = new Complexo();

		fim.r = p1.r + p2.r;

		fim.i = p1.i + p2.i;

		ImprNum(p1); System.out.print(" + "); ImprNum(p2); System.out.print(" = "); ImprNum(fim); System.out.println();
		
	}

	public static void Subtracao (Complexo p1, Complexo p2) {

		Complexo fim = new Complexo();

		fim.r = p1.r - p2.r;

		fim.i = p1.i - p2.i;

		ImprNum(p1); System.out.print(" - "); ImprNum(p2); System.out.print(" = "); ImprNum(fim); System.out.println();
		
	}

	public static void Multi (Complexo p1, Complexo p2) {

		Complexo fim = new Complexo();

		fim.r = (p1.r * p2.r) - (p1.i * p2.i);

		fim.i = (p1.i * p2.r) + (p1.r * p2.i);

		ImprNum(p1); System.out.print(" * "); ImprNum(p2); System.out.print(" = "); ImprNum(fim); System.out.println();

	}

	public static void Divisao (Complexo p1, Complexo p2) {

		Complexo fim = new Complexo();

		fim.r = ((p1.r * p2.r) + (p1.i * p2.i)) / (Math.pow(p2.r,2) + Math.pow(p2.i,2));

		fim.i = (p1.i * p2.r) - (p1.r * p2.i) / (Math.pow(p2.r,2) + Math.pow(p2.i,2));

		ImprNum(p1); System.out.print(" / "); ImprNum(p2); System.out.print(" = "); ImprNum(fim); System.out.println();

	}

}

class Complexo {

	double r, i;

}