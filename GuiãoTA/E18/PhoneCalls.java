import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;
public class PhoneCalls {
	public static void main(String[] args) throws IOException {
		KeyValueList<String> numeros = new KeyValueList<String>();
		KeyValueList<String> lista = new KeyValueList<String>();
		KeyValueList<String> lista2 = new KeyValueList<String>();
		for(int i = 0; i < args.length; i++) {
			if(isNumeric(args[i])) {
				String numero = "";
				if (numeros.contains(args[i])) numero = numeros.get(args[i]);
				else numero = args[i];
				callsMade(args[i], lista, lista2, numero);
			}
			else {
				String extensãoString = "";
				File f = new File(args[i]);
				extensãoString = f.toString();
				String [] extensão = extensãoString.split("\\.",2);
				switch(extensão[1]) {
				case "nms": readNum(numeros, f);
				break;
				case "cls":
				numCall(numeros, f, lista, lista2);
				break;
				default: exit(1);
				}
			}
		}
	}
	public static void readNum (KeyValueList<String> numeros, File f) throws IOException {
		Scanner scf = new Scanner(f);
		while(scf.hasNextLine()){
			String numeroNome = scf.nextLine();
			String []arrayNumeroNome = numeroNome.split("\\ ",2);
			numeros.set(arrayNumeroNome[0], arrayNumeroNome[1]);
			out.println(arrayNumeroNome[0]);
		}
		scf.close();
	}
	public static void numCall (KeyValueList<String> numeros, File f, KeyValueList<String> lista, KeyValueList<String> lista2) throws IOException {
		Scanner scf = new Scanner(f);
		while(scf.hasNextLine()){
			String chamada = scf.nextLine();
			String [] arrayNumeroNome = chamada.split("\\ ",3);
			String num1 = arrayNumeroNome[0];
			String num2 = arrayNumeroNome[1];
			if(numeros.contains(arrayNumeroNome[0])) num1 = numeros.get(arrayNumeroNome[0]);
			if(numeros.contains(arrayNumeroNome[1])) num2 = numeros.get(arrayNumeroNome[1]);
			String tem = arrayNumeroNome[2];
			String origem = num1;
			String destino = "\t- to " + num2 + " (" + tem + " seconds)\n";
			if (lista.contains(arrayNumeroNome[0])) {
				String add = lista.get(arrayNumeroNome[0]);
				lista.set(arrayNumeroNome[0], destino+add);
			}
			else lista.set(arrayNumeroNome[0], destino);
			destino = "\t- from " + num1 + " (" + tem + " seconds)\n";
			if (lista2.contains(arrayNumeroNome[1])) {
				String add = lista2.get(arrayNumeroNome[1]);
				lista2.set(arrayNumeroNome[1], destino+add);
			}
			else lista2.set(arrayNumeroNome[1], destino);
			out.println(origem + " to " + num2 + " (" + tem + " seconds)");
		}
		scf.close();
	}
	public static void callsMade (String num, KeyValueList<String> lista, KeyValueList<String> lista2, String numero) {
		out.println("Calls made by " + numero + ":");
		if (lista.contains(num)) {
			String print = lista.get(num);
			out.printf(print);
		}
		out.println("Calls received by " + numero + ":");
		if(lista2.contains(num)) {
			String print = lista2.get(num);
			out.printf(print);
		}
	}
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}