import java.util.*;

public class Exem7 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		Ponto2D p = new Ponto2D();

		Ponto2D pmax = new Ponto2D();

		int i = 0;

		double s = 0, max = 0;

		do {

			p = lerPonto();

			i++;

			s+=distanciaPonto(p);

			if (distanciaPonto(p) > max) {

				max = distanciaPonto(p);

				pmax.x = p.x;

				pmax.y = p.y;

			}

		} while (p.x != 0 && p.y != 0);

		System.out.printf("A soma das distâncias dos %d pontos à origem é de %.2f\n");

		System.out.print("O ponto mais afastado da origem foi: ");

		imprimirPonto(pmax);

	}

	public static Ponto2D lerPonto () {

		Ponto2D p = new Ponto2D();

		System.out.print("Introduza a coordenada x: ");
		p.x = sc.nextDouble();

		System.out.print("Introduza a coordenada y: ");
		p.y = sc.nextDouble();

		return p;

	}

	public static void imprimirPonto (Ponto2D p) {

		System.out.printf("%.1f,%.1f", p.x, p.y);

	}
	
	public static double distanciaPonto (Ponto2D p1) {

		return Math.sqrt(Math.pow((p1.x - 0),2) + Math.pow((p1.y - 0),2));

	}

}

class Ponto2D {

	double x, y;

}