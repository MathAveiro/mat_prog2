import java.util.*;
import static java.lang.System.*;
public class p61 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		if(args.length!=1) {
			out.println("USO: java -ea p61 <n>");
			exit(1);
		}
		int n=0;
		do {
			out.println("fibonacci("+n+") = "+Fibonnaci(n));
			n++;
		} while(n<=Integer.parseInt(args[0]));
		
	}
	public static int Fibonnaci(int n) {
		int valor;
		if(n==0) {
			valor = 0;
		}
		else if(n==1) {
			valor = 1;
		}
		else {
			valor = Fibonnaci(n-2)+Fibonnaci(n-1);
		}
		return valor;
	}
}