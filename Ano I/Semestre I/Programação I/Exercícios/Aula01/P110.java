import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class P110 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		out.print("Temperatura em Celsius: ");
		double temp = sc.nextDouble();

		double tempF = 1.8 * temp + 32;

		out.printf("Temperatura em Fahrenheit: %.2f", tempF);

	}

}