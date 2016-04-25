import java.util.*;
import java.io.*;
import static java.lang.Integer.*;
public class teste{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)throws IOException{
		int op=0;
		double media=0;
		Aluno[]p=new Aluno[4];
		for(int n=0;n<4;n++){
			p[n]=new Aluno();
		}
		do{
			op=funcaoMenu();
			switch(op){
				case 1:abrirFile(p);atualizar(p);break;
				case 2:alterarAluno(p);atualizar(p);break;
				case 3:removerAluno(p);atualizar(p);break;
				case 4:media=calcularMedia(p,media);break;
				case 5:System.out.println(media);break;
				case 6:imprimirMAluno(p);break;
				case 7:imprimirPNota();break;
				case 8:imprimirPNome();break;
				case 9:System.out.printf("O programa vai terminar");
			}

		}while(op!=9);
	}
	public static int funcaoMenu(){
		int op=0;
		System.out.printf("1:Abrir ficheiro\n2:Alterar aluno\n3:Remover aluno\n4:Calcular média\n5:Imprimir média\n6:Imprimir melhor aluno\n7:Imprimir por notas\n8:Imprimir por nome\n9:Terminar programa\n");
		do{
			System.out.printf("Opção:");
			op=sc.nextInt();
			if(op<0||op>9)System.out.printf("Opção inválida\n");
		}while(op<0||op>9);
		return op;
	}
	public static void abrirFile(Aluno[]p)throws IOException{
		int n=0;
		String nomeFile = new String();
		System.out.printf("Introduza o nome do ficheiro:");
		do{
			nomeFile=sc.nextLine();
		}while(nomeFile.length()==0);
		File fin=new File(nomeFile);
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
		Scanner scf=new Scanner(fin);
		String nome=new String();
		do{  
			p[n].nome=scf.nextLine(); 
			n++;
		}while(scf.hasNextLine());
		for(int temp=0;temp<n;temp++) {
			System.out.printf("Introduza o número mecanográgico do aluno %s:",p[temp].nome);
			p[temp].nmec=sc.nextInt();
			System.out.printf("Introduza a nota do aluno %s:",p[temp].nome);
			p[temp].nota=sc.nextInt();
		}
	}
	public static void alterarAluno(Aluno[]p){
		int nmec=0;
		System.out.printf("Introduza o número do aluno que pretende alterar:");
			nmec=sc.nextInt();
		for(int temp=0;temp<p.length;temp++){
			if(p[temp].nmec==nmec){
				System.out.printf("Introduza a nota do aluno %s:",p[temp].nome);
				p[temp].nota=sc.nextInt();
			}
		}
	}
	public static void removerAluno(Aluno[]p){
		System.out.printf("Introduza o número que pretende remover:");
		int remover=sc.nextInt();
		for(int temp=0;temp<p.length;temp++){
			if(p[temp].nmec==remover){
				for(int temp2=temp+1;temp2<p.length;temp2++){
					p[temp]=p[temp2];
				}
			}
		}
	}
	public static double calcularMedia(Aluno[]p,double media){
		int soma=0;
		for(int temp=0;temp<p.length;temp++){
			soma+=p[temp].nota;
		}
		media=soma/p.length;
		return media;
	}
	public static void imprimirMAluno(Aluno[]p){
		int notaM=0, reserva=0;
		for(int temp=0;temp<p.length;temp++){
			if(p[temp].nota>notaM){
				notaM=p[temp].nota;
				reserva=temp;
			}			
		}
		System.out.printf("O melhor aluno é: %s\tNúmero mecanográgico:%d\tNota:%d\n",p[reserva].nome,p[reserva].nmec,p[reserva].nota);
	}
	public static void imprimirPNota(){
		
	}
	public static void imprimirPNome(){
		
	}
	public static void atualizar(Aluno[]p)throws IOException{
		String gravar = new String();
		gravar = "sumário.txt";
		File f = new File(gravar);
		double media=0;
		int nalunos=0, npositivas=0,soma=0;
		for(int temp=0;temp<p.length;temp++) {
			soma+=p[temp].nota;
			nalunos=p.length;
			if(p[temp].nota>=10)npositivas++;
		}
		media=soma/p.length;
		PrintWriter pw = new PrintWriter(f);
		pw.printf("Média:%.0f\nNúmero de alunos:%d\nNúmero de positivas:%d\n",media,nalunos,npositivas);
		pw.close();
	}
}
class Aluno{
	String nome;
	int nota, nmec;
}