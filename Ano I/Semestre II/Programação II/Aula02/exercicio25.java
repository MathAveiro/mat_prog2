import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio25 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		int op=0;
		Data25 data = new Data25();
		do {
			funcaoMenu();
			out.printf("Opção: ");
			op = sc.nextInt();
			switch (op) {
				case 1: data = new Data25(); break;
				case 2: out.printf("Dia: \n");
						int dia = sc.nextInt();
						out.printf("Mês: \n");
						int mes = sc.nextInt();
						out.printf("Ano: \n");
						int ano = sc.nextInt();
						data = new Data25(dia, mes, ano); break;
				case 3: if(data.ternoInteiro()) out.printf("Data válida\n");
						else out.printf("Data inválida\n"); break;
				case 4: out.printf("Data: ");
						data.defineData(); break;
				case 5: out.println(data.dataExtenso()); break;
				case 6: data.vaiParaOntem(); break;
				case 7: data.vaiParaAmanha(); break;
				case 0: break;
				default: out.printf("Opção inválida!\n");
				}
		} while (op!=0);

	}

	public static void funcaoMenu() {
		out.printf("1. Cria novo objeto com a data atual\n2. Cria novo objeto com uma qualquer data\n3. Indica se a data é válida\n4. Escreve a data\n5. Escreve a data por extenso\n6. Dia anterior\n7. Dia seguinte\n0. Termina\n");
	}

}