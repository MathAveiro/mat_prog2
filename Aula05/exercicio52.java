import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio52 {

	static Scanner scc = new Scanner (System.in);

	public static void main (String[] args) throws IOException {

		int line = 0;

		String text1, text2;

		text1 = args[0];
		text2 = args[1];

		File fin=new File(text1);

		if (!fin.exists())
		{
			out.println("ERROR: input file " + text1 + " does not exist!");
			exit(0);
		}
		if (fin.isDirectory())
		{
			out.println("ERROR: input file " + text1 + " is a directory!");
			exit(1);
		}
		if (!fin.canRead())
		{
			out.println("ERROR: cannot read from input file " + text1 + "!");
			exit(2);
		}

		Scanner sc = new Scanner(fin);

		while(sc.hasNextLine()) {

			sc.nextLine();

			line++;

		}

		String [] gravar = new String [line];
					
		sc.close();

		Scanner scg = new Scanner (fin);

		int lineg = 0;

		do {

			gravar [lineg] = scg.nextLine();

			lineg++;

		} while (scg.hasNextLine());

		scg.close();

		File escrever = new File(text2);

		if (escrever.isDirectory())
		{
			out.println("ERROR: input file " + text2 + " is a directory!");
			exit(4);
		}
		
		if (escrever.exists()) {

			out.println("ERROR: input file " + text2 + " exist!");
			out.println("Substituir o ficheiro no destino? (Y/n)");
			String opcao = scc.nextLine();

			if (opcao.equals("y") || opcao.equals("Y")) {

				PrintWriter pw = new PrintWriter(escrever);

				for (int i = 0 ; i < gravar.length ; i++ ) {
					
					pw.printf(gravar[i]);
					pw.println();

				}

				pw.close();

			} else exit(3);

		} else {

			PrintWriter pw = new PrintWriter(escrever);

			for (int i = 0 ; i < gravar.length ; i++ ) {
				
				pw.printf(gravar[i]);
				pw.println();

			}

			pw.close();

		}

	}

}