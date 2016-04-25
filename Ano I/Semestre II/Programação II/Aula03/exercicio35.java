import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio35 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int op;
		Caixa35 c = new Caixa35();
		do {
			op=menu();
			switch (op) {
				case 1:
					long moeda;
					do {
						System.out.print("Moeda: ");
						moeda=sc.nextLong();
						if(moeda!=0) {
							c.adicionaMoeda(moeda);
						}
					} while(moeda!=0);
					System.out.println();
					break;
				case 2:
					System.out.print("Valor mínimo a retirar: ");
          			long valorMin = sc.nextLong();
          			long r[] = c.retirarDinheiro(valorMin);
          			if(r[0]!=-1){
          				for(int i=0; i<r.length; i++)
            				System.out.println(r[i]);
            		}
            		System.out.println();
					break;
				case 3:
					long a[] = c.moedas();
					for(int i=0; i<a.length; i++) {
						System.out.println(a[i]);
					}
					System.out.println();
					break;
				case 4:
					System.out.println("Dinheiro na Caixa35: "+c.total());
					break;
				case 0: out.println("O programa vai terminar!");
					break;
				default: out.println("Operação inválida!"); 
					break;
			}
		} while(op!=0);
	}
	public static int menu() {
		out.printf("1. Adicionar Moedas\n2. Retirar dinheiro\n3. Ver moedas na carteira\n4. Ver total da carteira\n0. Termina\n\nOpção: ");
		return sc.nextInt();
	}
}