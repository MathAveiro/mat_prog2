import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio22 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		Contacto22[] cl = new Contacto22[4];

		cl[0] = new Contacto22("Ana", "978676760");
		cl[1] = new Contacto22("Rita", "867367834", "rita@gmail.com");
		cl[2] = new Contacto22("Paulo", "897476388", "paulo@hotmail.com");
		cl[3] = new Contacto22("Carlos", "674767867");

		for (int i = 0; i < cl.length; i++) out.println(cl[i].nome() + ": " + cl[i].telefone() + "; " + cl[i].eMail());

	}

}
