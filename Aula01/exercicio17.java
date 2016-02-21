import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio17 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) throws IOException {

		String file1 = args[0];

		String file2 = args[1];

		File fin = new File(file1);
		if (!fin.exists())
		{
			System.out.println("ERROR: input file " + file1 + " does not exist!");
			System.exit(2);
		}
		if (fin.isDirectory())
		{
			System.out.println("ERROR: input file " + file1 + " is a directory!");
			System.exit(3);
		}
		if (!fin.canRead())
		{
			System.out.println("ERROR: cannot read from input file " + file1 + "!");
			System.exit(4);
		}

		Scanner scf = new Scanner(fin);
		File f = new File(file2);
		PrintWriter pw = new PrintWriter(f);
		int temp = 0;
		String detalhes = new String();
		do {
			detalhes = scf.nextLine();
			pw.println(detalhes);
		} while(scf.hasNextLine());
		scf.close();
		pw.close();

	}

}