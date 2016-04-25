import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class P19 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		out.print("Introduzir dimensão 1: ");
		int d1 = sc.nextInt();

		out.print("Introduzir dimensão 2: ");
		int d2 = sc.nextInt();

		int area = d1 * d2;
		int per = 2*d1 + 2*d2;

		out.printf("Area: %d\nPerímetro: %d", area, per);

	}

}