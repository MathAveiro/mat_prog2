import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class CityTraveler
{
	public static void main(String[] args)throws IOException {
		HashTable<String> visitas = new HashTable<String>(100);
		for(int i = 0; i < args.length; i++) {
			addVisitas(visitas, args[i]);
		}

		String[] keys = visitas.keys();
		for(int i = 0; i < keys.length; i++) {
			out.println(keys[i] + ": " + visitas.get(keys[i]));
		}
	}

	public static void addVisitas(HashTable<String> visitas, String cidade)throws IOException {
		File f = new File(cidade);
		Scanner scf = new Scanner(f);
		String[] parts = cidade.split("[\\W]");
		while(scf.hasNextLine()) {
			String nome = scf.nextLine();
			String temp = "";
			if(visitas.contains(nome)) {
				temp = visitas.get(nome);
				visitas.set(nome, temp+" "+parts[0]);
			}
			else visitas.set(nome, parts[0]);
		}
	}
}
