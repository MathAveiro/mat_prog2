import java.util.*;
import static java.lang.System.*;
public class p63 {
	public static void main(String[] args) {
		if(args.length==0) {
			out.println("USO: java -ea p63 <String>");
			exit(1);
		}
		printArgs(args, args.length-1);
	}
	public static void printArgs(String[] args, int n) {
		if(n==-1) return;
		else {
			out.println(args[n]);
			printArgs(args, n-1);
		}
	}
}