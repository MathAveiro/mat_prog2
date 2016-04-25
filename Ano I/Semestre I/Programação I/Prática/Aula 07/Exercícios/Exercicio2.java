import java.util.*;

public class Exercicio2 {

	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		coord n = new coord();

		readPonto(n);
		

	}
	
	public static void readPonto(coord n) {

		int i=0;

		do {

		double coordx [] = new double [i];
		double coordy [] = new double [i];
		System.out.println("Introduza um ponto");
		System.out.println("Coordenada x: ");
		n.x = sc.nextDouble();
		coordx[i]=n.x;
		System.out.println("Coordenada y: ");
		n.y = sc.nextDouble();
		coordy[i]=n.y;

		i++;

		} while(n.x!=0 || n.y!=0);

	}

	public static void scPonto(coord n) {

		System.out.printf("(%d,%d)", n.x, n.y);

	}

}

class coord {

	double x, y;

}