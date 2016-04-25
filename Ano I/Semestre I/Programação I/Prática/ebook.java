import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class ebook{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args)throws IOException{
		int op=0, cont=0;
		Utilizador[]u=new Utilizador[100];
		Livro[]p=new Livro[100];
		do{	
			op=menu();
			switch(op){
				case 1:cont=funcaoRegisto(u,cont);break;
				case 2://funcaoLogin();
				case 3:System.out.println("O programa vai terminar");break;
				default:
			}
		}while(op!=3);
	}
	public static int menu(){
		int op=0;
		System.out.printf("1:Registo\n2:Login\n3:Terminar o programa\n");
		do{
			System.out.print("Opção:");
			op=sc.nextInt();
			if(op<0||op>3)System.out.println("Opção inválida");
		}while(op<0||op>3);
		return op;
	}
	public static int funcaoRegisto(Utilizador[]u, int cont)throws IOException{
		u[cont]=new Utilizador();
		String temp=new String();
		System.out.printf("Nome: ");
		do{
			u[cont].nome=sc.nextLine();
		}while(u[cont].nome.length()==0);
		System.out.printf("E-mail (exemplo@ua.pt): ");
		do{
			temp=sc.nextLine();
		}while(temp.length()==0);
		u[cont].mail=temp+"@ua.pt\n";
		//System.out.printf(u[cont].mail);
		System.out.printf("Morada: ");
		do{
			u[cont].morada=sc.nextLine();
		}while(u[cont].morada.length()==0);
		System.out.printf("Idade: ");
		u[cont].idade=sc.nextInt();
		System.out.printf("Número de contacto: ");
		u[cont].telm=sc.nextInt();
		cont++;
		String nomeFile = new String();
		nomeFile="BaseDeRegistos.txt";
        File fin = new File(nomeFile);
		if (!fin.exists())
		{
			System.out.println("ERROR: input file " + nomeFile + " does not exist!");
			System.exit(2);
		}
		if (fin.isDirectory())
		{
			System.out.println("ERROR: input file " + nomeFile + " is a directory!");
			System.exit(3);
		}
		if (!fin.canRead())
		{
			System.out.println("ERROR: cannot read from input file " + nomeFile+ "!");
			System.exit(4);
		}
		Scanner scf = new Scanner(fin);
		int tempcont = 0;
		String detalhes = new String();
		System.out.println("cor");
		do {
			String verifica=new String();
			if(scf.hasNextLine()){
				verifica=scf.nextLine();
				if(verifica.length()==0)break;
			}
			System.out.println("cor"+tempcont);
			tempcont++;
		} while(scf.hasNextLine());
		scf.close();
		String gravarFile=new String();
		gravarFile="BaseDeRegistos.txt";
		File finGravar=new File(gravarFile);
		PrintWriter pw=new PrintWriter(finGravar);
		for (int temp2=tempcont;temp2<cont;temp2++) {
			pw.printf("Informações de Utilizadores: Nome: %s\tMail: %s\tMorada: %s\tIdade: %d\tContacto: %d\n",u[temp2].nome,u[temp2].mail,u[temp2].morada,u[temp2].idade,u[temp2].telm); 
		}
		pw.close();
		return cont;
	}
}
class Utilizador{
	String nome, mail, morada;
	int telm, idade;
}
class Livro{
	String autor, nome, editora, mail;
}
