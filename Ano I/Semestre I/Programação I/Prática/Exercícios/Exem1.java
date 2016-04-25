import java.util.*;

public class Exem1 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		Ponto2D n = new Ponto2D();

		Ponto2D max = new Ponto2D();

		int i=0;

		double dist, distmax=0, d=0;

		do {

			n = LerPonto();

			if (n.x != 0 || n.y != 0) {

				i++;

			}

			dist = DistanciaPonto(n);

			d += dist;

			if (DistanciaPonto(n) > distmax) {

				distmax = DistanciaPonto(n);

				max.x = n.x;

				max.y = n.y;

			}

		} while (n.x != 0 || n.y != 0);

		System.out.printf("A soma das distâncias dos %d pontos à origem é: %3.1f.\n", i, d);

		System.out.print("O ponto mais afastado foi: "); EscreverPonto(max);

	}

	public static Ponto2D LerPonto () {

		Ponto2D p = new Ponto2D();

		System.out.println("Introduza a coordenada x: ");
		p.x = sc.nextDouble();

		System.out.println("Introduza a coordenada y: ");
		p.y = sc.nextDouble();

		return p;
		
	}	

	public static void EscreverPonto (Ponto2D p) {

		System.out.printf("(%.0f,%.0f)", p.x, p.y);

	}

	public static double DistanciaPonto (Ponto2D p) {

		double i = Math.pow((p.x - 0),2) + Math.pow((p.y - 0),2); 

		return Math.sqrt(i);
		
	}

}

class Ponto2D {

	double x, y;

}