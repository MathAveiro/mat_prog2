import p2utils.*;
import java.io.*;
import java.util.Scanner;
public class P124 {
	public static void main(String[] args)throws IOException {
		HashTable<Integer> numb = new HashTable<Integer>(100);

		Scanner sf = new Scanner(new File("numbers.txt"));
		
		LinkedList<Integer> lista = new LinkedList<Integer>();

		LinkedList<Integer> final1 = new LinkedList<Integer>();

		do {

			String temp = sf.nextLine();
			
			String[] split = temp.split(" - ");
			
			int n = Integer.parseInt(split[0]);
			
			numb.set(split[1], n);


		} while (sf.hasNextLine());

		String[] argsTemp = args[0].split(" ");

		for(int i = 0; i < argsTemp.length; i++) {
		
			if(!numb.contains(argsTemp[i])) {
		
				String[] newTemp = argsTemp[i].split("-");
		
				for(int j = 0; j < newTemp.length; j++) 

					if(numb.contains(newTemp[j])) lista.addLast(numb.get(newTemp[j]));
		
			}
		
			else lista.addLast(numb.get(argsTemp[i]));;
		
		}
		
		calc(lista, lista.first(), 0, lista.size(), 0, final1);

		int total = soma(final1, 0);

		System.out.println(args[0] + " -> " + total);

	}

	public static void calc (LinkedList<Integer> lista, int elemento, int total, int size, int cont, LinkedList<Integer> final1) {

		if (lista.first() != null) {

			int elementoaguardar = lista.first();

			lista.removeFirst();

			if (!lista.isEmpty()) {

				int segundoelemento = lista.first();

				lista.removeFirst();

				if (elemento < segundoelemento) {

					total = (elemento * segundoelemento);
					
					int elementoacomparar = lista.first();

					if (total > elementoacomparar) final1.addLast(total);

					else lista.addFirst(total);

				} else {

					total += elemento;

					lista.addFirst(segundoelemento);

					final1.addLast(total);

				}

				int elementoapassar = lista.first();

				calc (lista, elementoapassar, 0, size, cont+1, final1);

			} else {

				final1.addLast(elementoaguardar);

				return;

			}

		} else return;

	}

	public static int soma (LinkedList<Integer> final1, int total) {

		if (final1.isEmpty()) return total;

		total += final1.first();

		final1.removeFirst();

		return soma(final1, total);

	}

}