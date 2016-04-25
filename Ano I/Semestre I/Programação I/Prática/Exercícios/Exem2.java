import java.util.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Exem2 {


	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		Circulo ref = new Circulo();

		Circulo circ = new Circulo();

		int n=0, ns=0;

		double area, a=0;

		ref = LerCirculo();

		do {

			circ = LerCirculo();

			n++;

			area = area(circ);

			a+=area;

			if (!sobrepoe(circ,ref)) {

				ns++;

			}

		} while ((circ.c.x != ref.c.x) || (circ.c.y != ref.c.y));

			System.out.printf("Circulos introduzidos: %d\n",n);

			System.out.printf("Circulos fora do circulo de referência: %d\n",ns);
			
			System.out.printf("Area total de circulos: %3.1f\n",a);
		
	}

	public static Circulo LerCirculo () {

		Circulo c = new Circulo();

		Ponto2D p = new Ponto2D();

		System.out.println("Introduza a coordenada x: ");
		p.x = sc.nextDouble();

		System.out.println("Introduza a coordenada y: ");
		p.y = sc.nextDouble();

		do {

			System.out.println("Introduza um raio válido: ");
			c.r = sc.nextDouble();
 
			if (c.r <= 0) {

				System.out.println("Raio inválido.");

				System.out.println("Introduza um novo raio: ");
				c.r = sc.nextDouble();

			}

		} while (c.r <= 0);

		c.c = p;

		return c;

	}

	public static double dist (Ponto2D p1, Ponto2D p2) {

		return sqrt(pow((p1.x - p2.x),2) + pow((p1.y - p2.y),2));

	}

	public static double area (Circulo c) {

		return PI*pow(c.r,2);

	}

	public static boolean sobrepoe (Circulo c1, Circulo c2) {

		if (dist(c1.c, c2.c) <= (c1.r - c2.r)) {

			return true;

		}

		else {
			
			return false;			

		}

	}

}

class Ponto2D {

	double x, y;

}


class Circulo {

	Ponto2D c;
	double r;

}