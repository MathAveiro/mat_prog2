import java.util.*;
import java.io.*;
import static java.lang.Integer.*;
public class folha9ex3 {
	static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) throws IOException{
		int n=0;
		int numero[] = new int[50];	// declaração e reserva do array 'numero'.
		int op = 0;	// op corresponde à opção.
		do {
			op = printMenu();
			switch(op) {	// assume-se aqui o valor escolhido e validado na função printMenu().
			// a partir daqui temos diferentes ações paras as diferentes opções.
			case 1:
			n=lerSeq(numero);
			break;
			case 2:
			printSeq(numero);
			break;
			case 3:
			printMax(numero);
			break;
			case 4:
			printMin(numero);
			break;
			case 5:
			printMed(numero);
			break;
			case 6:
			printPar(numero);
			break;
			case 7:
			lerFich(numero);
			break;
			case 8:
			n=addNum(numero, n);
			break;
			case 9:
			saveSeq(numero);
			break;
			}
		} while(op != 10);	// enquanto a opção for diferente de 10, pq qd for "O programa terminou!".
		System.out.println("O programa terminou!");
	}
	public static int printMenu() {	// impressao do menu e escolha da opção.
		System.out.println("\nMENU");
		System.out.println(" 1 - Ler a sequencia");
		System.out.println(" 2 - Escrever a sequencia");
		System.out.println(" 3 - Calcular o maximo da sequencia");
		System.out.println(" 4 - Calcular o minimo da sequencia");
		System.out.println(" 5 - Calcular a media da sequencia");
		System.out.println(" 6 - Detetar se e uma sequencia so constituida por numeros pares");
		System.out.println(" 7 - Ler a sequência do ficheiro.");
		System.out.println(" 8 - Adicionar números à sequência.");
		System.out.println(" 9 - Gravar nova sequência em ficheiro.");
		System.out.println(" 10 - Terminar o programa");
		System.out.print("Opção: ");
		
		int op;
		do {
			op = sc.nextInt();
			if(!((op > 0 && op < 11))) System.out.print("Opção inválida!\nOpção: ");
			// se a opção não estiver entre 0 e 7, exclusive, ou de for diferente de 10, entao é considerada uma opção invalida.
		} while(!((op > 0 && op < 11)));	// o mesmo se tem de escrever como condição no while.
		return op;	// este valor tem de se devolver ao switch.
	}
	public static int lerSeq(int numero[]) {
		int n = 0, valor;
		System.out.println("Insira valores:");	// fora do 'do...while' para que nao esteja sempre a imprimir a mensagem.
		//~ System.out.printf("Valor[%d]: ", n);	(não é necessário!)
		do {
			valor = sc.nextInt();
			// temos aqui as 3 hipoteses, qd <0 , =0 e >0.
			if(valor > 0) {
				numero[n] = valor;
				n++;		
			}
			if(valor < 0) System.out.println("Valor inválido!"); // se o valor for negativo não é válido.
			if (valor == 0 || n == 50) break;
			
		} while(valor != 0 || n != 50);	// pq qd o valor for zero a sequencia pára!
		return n-1;
	}
	public static void printSeq(int numero[]) {
		int n = 0;
		do {
			if(numero[n] > 0)	// porque os números negativos que nao foram validados nao podem ser impressos aqui.
			System.out.println(" " + numero[n++]);
			// OU ~ System.out.print(" " + numero[n++] + " ");
		} while(numero[n] != 0);	// só imprime os números diferentes de zero.
	}
	public static void printMax(int numero[]) {
		int n=0, max=0;	// o maximo começa como zero pois no inicio nao temos nenhum maximo ainda.
		do {
			if(numero[n] > max) max = numero[n];	// se o numero é maior que o max, entao o numero é o novo max.
			n++;
		} while(numero[n] != 0);	// excluindo o zero.
		System.out.printf("Máximo: %d", max);
	}
	public static void printMin(int numero[]) {
		int n=0, min=Integer.MAX_VALUE;	// Decorar esta mariquice xD / Integer.MAX_VALUE é o maior número que há;
		// o min começa por ser esse, para que todos os números que estiverem na lista, por maiores que sejam, acabem por ser mais pequenos que o minimo inicial.
		do {
			if(numero[n] < min) min = numero[n];	// se o numero é menor que o min, entao o numero é o novo min.
			n++;
		} while(numero[n] != 0);	// excluindo o zero.
		System.out.printf("Mínimo: %d", min);
	}
	public static void printMed(int numero[]) {
		int n=0, med=0;	// a media começa como zero pois no inicio nao temos nenhuma media ainda.
		do {
			if(numero[n] > 0) {	// na media nao entram os numeros negativos que nao foram validados.
			med = med+numero[n];	// primeiro os valores vao somando. (Dentro do do...while)
			n++;
			}
		} while(numero[n] != 0);	// excluindo o zero.
		med = med/n;	// dps é que se faz a divisao pelo n. (Fora do do...while)
		System.out.printf("Média: %d", med);
	}
	public static void printPar(int numero[]) {
		int n=0;
		boolean soPar = true;	// começamos por admitir entao que 'soPar' é verdadeiro.
		do {
			if(numero[n] % 2 != 0) soPar = false;	// mas se o numero nao for divisivel por 2, entao 'soPar' já é falso.
			n++;
		} while(numero[n] != 0);	// excluindo o zero.
		if(soPar) System.out.println("São todos pares");	// se 'soPar' acontecer entao "Sao todos pares".
		else System.out.println("Existem impares");	// Se nao , é pq "Existem impares".
	}
	public static void lerFich(int numero[]) throws IOException{
		String nome = new String();

		int n=0;

		System.out.print("Nome de ficheiro: ");

		do {
            nome = sc.nextLine();
        } while(nome.length() == 0);

        File my_file = new File(nome);
		
		if (!my_file.exists()) 
		{
			System.out.println("ERROR: input file " + nome + " does not exist!");
			System.exit(2);
		}
		if (my_file.isDirectory())
		{
			System.out.println("ERROR: input file " + nome + " is a directory!");
			System.exit(3);
		}
		if (!my_file.canRead())
		{
			System.out.println("ERROR: cannot read from input file " + nome + "!");
			System.exit(4);
		}
		
		Scanner readfile = new Scanner(my_file);
		String []numeros = new String[50];
	
		do {
			numeros[n]=readfile.nextLine();
			System.out.println(numeros[n]);
			n++;
		} while(readfile.hasNextLine());
		for (int i=0;i<n;i++) {
			numero[i]=Integer.parseInt(numeros[i]);			
		}
		readfile.close();
	}
	public static int addNum(int numero[], int n){
		int i=n;
		System.out.println("Adicione números à lista: ");
		do {
			i++;
			numero[i]=sc.nextInt();
		} while(i<49 && numero[i]!=0);
		if(numero[i]==0) i=i-1;
		return i;
	}
	public static void saveSeq(int numero[]) throws IOException{
		String nome = new String ();
		int n=0;
		
		System.out.print("Nome do novo ficheiro: ");
		do {
            nome = sc.nextLine();
        } while(nome.length() == 0);
		
		File my_file = new File(nome);
		
		PrintWriter pw = new PrintWriter(my_file);

		for (n=0;n<numero.length;n++) {
			if(numero[n]==0) break;
			pw.println(numero[n]);
		}
		pw.close();
	}
}

