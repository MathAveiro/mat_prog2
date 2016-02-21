import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio21 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
			
		String real = args [0];
		String imag = args [1];

		double realdouble = Double.parseDouble(real);
		double imagdouble = Double.parseDouble(imag);

		Complexo a = new Complexo(realdouble, imagdouble);

		out.println("(" + a.real() + " + " + a.imag() + "i)");
		out.println("  parte real = " + a.real());
		out.println("  parte imaginaria = " + a.imag());
		out.println("  modulo = " + a.abs());
		out.printf("  fase   =  %2.2f\n", a.phase());

	}

}

/*import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio21 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
			
		out.printf("Re: ");
		double realdouble = sc.nextInt();

		out.printf("Im: ");
		double imagdouble = sc.nextInt();

		Complexo a = new Complexo(realdouble, imagdouble);

		out.println("(" + a.real() + " + " + a.imag() + "i)");
		out.println("  parte real = " + a.real());
		out.println("  parte imaginaria = " + a.imag());
		out.println("  modulo = " + a.abs());
		out.printf("  fase   =  %2.2f\n", a.phase());

	}

}*/
