import java.util.*;
import static java.lang.System.*;
public class p62 {
	public static void main(String[] args) {
		if(args.length==0) {
			out.println("USO: java -ea p62 <String>");
			exit(1);
		}
		printArgs(args, 0);
	}
	public static void printArgs(String[] args, int n) {
		if(n==args.length) return;
		else {
			out.println(args[n]);
			printArgs(args, n+1);
		}
	}
}