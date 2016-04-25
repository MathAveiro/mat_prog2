import static java.lang.System.*;
import java.io.*;

public class P71
{
	public static void main(String[] args) throws IOException
	{
		LinkedList<Integer> lst = new LinkedList<Integer>();

		for(int i=0; i<10; i++) 
		{
			lst.addFirst(i);
			lst.addLast(100+i);
		}
		out.println(lst.first());

		lst.removeFirst();

        @SuppressWarnings("unchecked")

		LinkedList<Integer> cln = lst.clone();

		out.println(cln.first());

        @SuppressWarnings("unchecked")

		LinkedList<Integer> rev = cln.reverse();

		out.println(rev.first());

		out.println(rev.contains(5));
		rev.remove(5);
		out.println(rev.contains(5));
     
		for(int p=0; p<rev.size(); p++) 
			out.println(rev.get(p));
	}
}


