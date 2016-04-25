import java.util.*;
import java.io.*;
import static java.lang.Integer.*;
public class nome{
	static Scanner sc = new Scanner(System.in);
	public static void main (String[]args)throws IOException{
		Teste[]p=new Teste[10];
		for(int temp=0;temp<10;temp++){
			p[temp]=new Teste();
		}
		funcaoAbrir(p);
		guardarNovo(p);
	}
	public static void funcaoAbrir(Teste[]p)throws IOException{
		int n=0;
		String file = new String();
		System.out.printf("...");
		do{
			file=sc.nextLine();
		}while(file.length()==0);
		File fin = new File(file);
		Scanner scf=new Scanner(fin);
		do{
			p[n].nome=scf.nextLine();
		}while(scf.hasNextLine());
		scf.close();
	}
	public static void guardarNovo(Teste[]p)throws IOException{
		int n=0;
		String gravar=new String();
		System.out.printf("...");
		do{
			gravar=sc.nextLine();
		}while(gravar.length()==0);
		File fin = new File(gravar);
		PrintWriter pw=new PrintWriter(fin);
		pw.printf("...");
		pw.close();
	}
}
class Teste{
	String nome;
}