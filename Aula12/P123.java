import p2utils.*;
import java.io.*;
import java.util.Scanner;
public class P123 {
	public static void main(String[] args)throws IOException {
		HashTable<Integer> numb = new HashTable<Integer>(100);
		Scanner sf = new Scanner(new File("numbers.txt"));

		do {

			String temp = sf.nextLine();
			String[] split = temp.split(" - ");
			Integer n = Integer.parseInt(split[0]);
			numb.set(split[1], n);

		}while(sf.hasNextLine());

		String[] argsTemp = args[0].split(" ");

		System.out.print("A list of numbers: ");

		for(int i = 0; i < argsTemp.length; i++) {
			if(!numb.contains(argsTemp[i])) {
				String[] newTemp = argsTemp[i].split("-");
				for(int j = 0; j < newTemp.length; j++) if(numb.contains(newTemp[j])) System.out.print(numb.get(newTemp[j]) + " ");
			}
			else System.out.print(numb.get(argsTemp[i]) + " ");
		}
		System.out.println();

	}
}