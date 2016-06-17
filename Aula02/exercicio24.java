import pt.ua.prog2.Contacto;
import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio24 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		Contacto[] cl = new Contacto[4];

		int n;

		for (n = 0;n < 4;n++) {
			out.printf("Nome: ");
			String nome = sc.nextLine();

			out.printf("Telemóvel: ");
			String telemovel = sc.nextLine();

			out.printf("Email: ");
			String email = sc.nextLine();

			cl[n] = new Contacto(nome, telemovel, email);

		}

		out.println("Listagem: ");



		for (n = 0;n < 4;n++) {

			if (cl[n].eMail()==null) out.println(cl[n].nome() + ": " + cl[n].telefone());
			else out.println(cl[n].nome() + ": " + cl[n].telefone() + "; " + cl[n].eMail());

		}

		out.println("Número de contactos: "+cl[0].contador());

	}

}