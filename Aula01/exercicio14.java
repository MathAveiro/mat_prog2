import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio14 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		out.printf("Introduza a frase a ser traduzida: ");
		String frase = sc.nextLine();

		String frase1 = frase.replaceAll("l","u");
		String frase2 = frase1.replaceAll("L","U");
		String frase3 = frase2.replaceAll("r","");
		String frase4 = frase3.replaceAll("R","");

		out.printf(frase4);

	}

}