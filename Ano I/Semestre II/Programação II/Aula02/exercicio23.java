import pt.ua.prog2.Contacto23;
import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio23 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		Contacto23[] cl = new Contacto23[4];

		cl[0] = new Contacto23("Ana", "978676760");
		cl[1] = new Contacto23("Rita", "867367834", "rita@gmail.com");
		cl[2] = new Contacto23("Paulo", "897476388", "paulo@hotmail.com");
		cl[3] = new Contacto23("Carlos", "674767867");

		for (int i = 0; i < cl.length; i++) out.println(cl[i].nome() + ": " + cl[i].telefone() + "; " + cl[i].eMail());

	}

}