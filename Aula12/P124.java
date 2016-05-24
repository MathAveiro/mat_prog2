import p2utils.*;
import java.io.*;
import java.util.Scanner;
public class P124 {
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
		int cont;
		for(int i = 0; i < argsTemp.length; i++) {
			if(!numb.contains(argsTemp[i])) {
				String[] newTemp = argsTemp[i].split("-");
				for(int j = 0; j < newTemp.length; j++) {
					if(j>0 || j<argsTemp.length-1) {
						if (numb.get(newTemp[j]) < numb.get(newTemp[j+1]) {
							
						}
				}
			}
			else System.out.print(numb.get(argsTemp[i]) + " ");
		}
		System.out.println();

	}
}