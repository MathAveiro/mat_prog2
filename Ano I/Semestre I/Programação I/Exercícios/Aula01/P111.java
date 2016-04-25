import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class P111 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		out.print("Quantia em dólares: ");
		double dolar = sc.nextDouble();

		out.print("Taxa de conversão: ");
		double taxa = sc.nextDouble();

		double euro = dolar * taxa;

    	out.printf("%2.1f dolares corresponde a %2.1f euros\n", dolar, euro);

	}

}