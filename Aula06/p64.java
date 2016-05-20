import java.util.*;
import static java.lang.System.*;
public class p64 {
	public static void main(String[] args) {
		if(args.length==0) {
			out.println("USO: java -ea p64 <String>");
			exit(1);
		}
		for (int i=0; i<args.length; i++) {
			out.println(args[i]+" -> "+invertString(args[i], args[i].length()-1));			
		}
		
	}
	public static String invertString(String args, int n) {
		String temp = new String();
		if(n==-1) return "";
		else {
			temp=temp+args.charAt(n) + invertString(args, n-1);
		}
		return temp;
	}
}