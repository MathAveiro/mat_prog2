import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
import p2utils.*;
public class P86 {
	public static void main(String[] args) {

		SortedList<Pessoa> lst = new SortedList<Pessoa>();

		Pessoa[] pessoa = new Pessoa[5];

		pessoa[0] = new Pessoa(new Data(12, 9, 1997), "pessoa1");
		pessoa[1] = new Pessoa(new Data(13, 10, 1997), "pessoa2");
		pessoa[2] = new Pessoa(new Data(11, 5, 1997), "pessoa3");
		pessoa[3] = new Pessoa(new Data(12, 9, 1997), "pessoa4");
		pessoa[4] = new Pessoa(new Data(12, 8, 1997), "pessoa5");

		for(int i=0; i<pessoa.length; i++) {
			lst.insert(pessoa[i]);
		}

		out.println(lst.toString());

	}
}