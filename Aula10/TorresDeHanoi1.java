
import static java.lang.System.*;
import java.util.Scanner;

public class TorresDeHanoi1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);

		moverDiscos (n, "torre1", "torre2", "torre3");

	}

	static void moverDiscos(int n, String origem, String destino, String auxiliar) {

		assert n >= 0;

    	if (n > 0) {

			moverDiscos(n-1, origem, auxiliar, destino); 
			
			out.println("Move disco "+n+" da torre "+origem+" para a torre "+destino); 
			
			moverDiscos(n-1, auxiliar, destino, origem); 
	
		}

	}

}

 