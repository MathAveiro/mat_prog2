import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;
public class CityTraveler
{
	public static void main(String[] args)throws IOException {
		HashTable<LinkedList<String>> visitas = new HashTable<LinkedList<String>>(100);
		for(int i = 0; i < args.length; i++) {
			addVisitas(visitas, args[i]);
		}

		String[] keys = visitas.keys();
		for(int i = 0; i < keys.length; i++) {
			out.printf("%-15s: %s\n", keys[i], visitas.get(keys[i]));
		}
	}

	public static void addVisitas(HashTable<LinkedList<String>> visitas, String cidade)throws IOException {
		File f = new File(cidade);
		Scanner scf = new Scanner(f);
		while(scf.hasNextLine()) {
			String nome = scf.nextLine();
			if(visitas.contains(nome)) {
				visitas.get(nome).addFirst(cidade);
				visitas.set(nome, visitas.get(nome));
			}
			else {
				LinkedList<String> temp = new LinkedList<String>();
				temp.addFirst(cidade);
				visitas.set(nome, temp);
			}
		}
	}
}
