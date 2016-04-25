import java.util.Scanner;
import java.io.*;

public class exemplosFicheiros
{
	public static void main(String[] args) throws IOException
	{
		Scanner kb = new Scanner(System.in);

		// leitura do nome do ficheiro de entrada
		System.out.print("Ficheiro de entrada: ");
		String nameIn = kb.nextLine();

		// Associação do nome do ficheiro de entrada ao programa
		File fin = new File(nameIn);

		// verificações do ficheiro de entrada
		if (!fin.exists())
		{
			System.out.println("ERROR: input file " + nameIn + " does not exist!");
			System.exit(2);
		}
		if (fin.isDirectory())
		{
			System.out.println("ERROR: input file " + nameIn + " is a directory!");
			System.exit(3);
		}
		if (!fin.canRead())
		{
			System.out.println("ERROR: cannot read from input file " + nameIn+ "!");
			System.exit(4);
		}

		// Scanner associado ao ficheiro de entrada
		Scanner scf = new Scanner(fin);

		// leitura do nome do ficheiro de saída
		System.out.print("Ficheiro de saida: ");
		String nameOut = kb.nextLine();

		// Associação do nome do ficheiro de saída ao programa
		File fout = new File(nameOut);
		PrintWriter pw = new PrintWriter(fout);

		// contagen do número de linhas de texto do ficheiro de entrada
		int cont = 0;
		while(scf.hasNextLine())
		{
			scf.nextLine();
			cont++;
		}
		scf.close();

		System.out.println("O fich. tem " + cont + " linhas");

		// cópia do conteúdo do ficheiro de entrada para o ficheiro de saída
		scf = new Scanner(fin);
		while(scf.hasNextLine())
		{
			String s = scf.nextLine();
			pw.println(s);
		}

		// Fecho dos dois ficheiros
		scf.close();
		pw.close();
	}
}

