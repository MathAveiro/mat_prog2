import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import p2utils.LinkedList;

public class p77 {

	static Scanner scc = new Scanner (System.in);

	public static void main (String[] args) throws IOException {

		int line = 0;

        String text1 = args[0];

		File fin = new File(text1);

		if (!fin.exists())
		{
			out.println("ERROR: input file " + text1 + " does not exist!");
			exit(0);
		}
		if (fin.isDirectory())
		{
			out.println("ERROR: input file " + text1 + " is a directory!");
			exit(1);
		}
		if (!fin.canRead())
		{
			out.println("ERROR: cannot read from input file " + text1 + "!");
			exit(2);
		}

		Scanner sc = new Scanner(fin);

        LinkedList <String> t1 = new LinkedList <String>();

        LinkedList <String> t2 = new LinkedList <String>();

        LinkedList <String> t3 = new LinkedList <String>();

        while(sc.hasNextLine()) {
            
            String temp = sc.nextLine();
            
            if (temp.length() < 20) {
                
                if (t1.isEmpty()) t1.addFirst(temp);
                else t1.addLast(temp);
                
            } else if (temp.length() < 40) {
                
                if (t2.isEmpty()) t2.addFirst(temp);
                else t2.addLast(temp);
                
            } else {
            
                if (t3.isEmpty()) t3.addFirst(temp);
                else t3.addLast(temp);
              
            }
            
        }
        
		sc.close();
        
        out.println(t1.size());
        out.println(t2.size());   
        out.println(t3.size());
        
        for (int i = 0; i <= t1.size(); i++) {
            
            out.println(t1.first());
            t1.removeFirst();
            
        }
        
        for (int i = 0; i <= t2.size(); i++) {
            
            out.println(t2.first());
            t2.removeFirst();
            
        }
        
        for (int i = 0; i <= t3.size(); i++) {
            
            out.println(t3.first());
            t3.removeFirst();
            
        }
        
	}

}